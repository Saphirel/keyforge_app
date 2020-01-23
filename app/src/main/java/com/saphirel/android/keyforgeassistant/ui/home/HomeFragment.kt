package com.saphirel.android.keyforgeassistant.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.database.Database
import com.saphirel.android.keyforgeassistant.objects.House
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.fragment_home.*
import java.io.BufferedReader


class HomeFragment : Fragment() {

    private lateinit var actionsViewManager: RecyclerView.LayoutManager
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var db: Database
    private var house: House? = null
    private lateinit var creaturesAdapter: RecyclerView.Adapter<*>
    private lateinit var actionsAdapter: RecyclerView.Adapter<*>
    private lateinit var artefactsAdapter: RecyclerView.Adapter<*>
    private lateinit var upgradesAdapter: RecyclerView.Adapter<*>
    private lateinit var creaturesViewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDb()

        creaturesViewManager = LinearLayoutManager(context)
        actionsViewManager = LinearLayoutManager(context)
        creaturesAdapter = CreaturesAdapter(house!!.creatures, context!!)
        actionsAdapter = ActionsAdapter(house!!.actions, context!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        creatures_rv.apply {
            //setHasFixedSize(true)
            layoutManager = creaturesViewManager
            adapter = creaturesAdapter
        }
        action_rv.apply {
            layoutManager = actionsViewManager
            adapter = actionsAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    private fun initDb() {
        db = Room.databaseBuilder(
            context!!,
            Database::class.java, "keyforge-assistant"
        ).build()

        var tmp = resources.openRawResource(resources.getIdentifier("brobnar", "raw", context!!.packageName))
        val content = tmp.bufferedReader().use(BufferedReader::readText)

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val jsonAdapter: JsonAdapter<House> = moshi.adapter(
            House::class.java)

        house = jsonAdapter.fromJson(content)

        Log.e("File", house!!.name)
    }
}