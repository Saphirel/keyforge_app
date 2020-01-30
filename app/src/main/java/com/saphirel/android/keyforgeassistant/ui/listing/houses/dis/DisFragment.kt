package com.saphirel.android.keyforgeassistant.ui.listing.houses.dis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.json.JSonManager
import com.saphirel.android.keyforgeassistant.ui.CardsPager
import kotlinx.android.synthetic.main.fragment_gallery.*


class DisFragment : Fragment() {

    private lateinit var viewModel: DisViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabs.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = CardsPager(fragmentManager!!, JSonManager.loadHouseCardsFromJSon("dis", resources, context!!)!!)
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                view_pager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(DisViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)

        return root
    }
}