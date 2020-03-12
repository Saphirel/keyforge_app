package com.saphirel.android.keyforgeassistant.ui.listing.houses

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.json.JSonManager
import com.saphirel.android.keyforgeassistant.ui.CardsPager
import kotlinx.android.synthetic.main.fragment_gallery.*


class HouseFragment : Fragment() {

    private lateinit var viewModel: HouseViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabs.tabGravity = TabLayout.GRAVITY_FILL
        val houseName = arguments?.getString("house")

        val adapter = CardsPager(fragmentManager!!, houseName?.let {
            JSonManager.loadHouseCardsFromJSon(
                it, resources, context!!)
        }!!)
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        updateToolbarColorDependingHouse(houseName)

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

    private fun updateToolbarColorDependingHouse(houseName: String) {
        when (houseName) {
            "brobnar" -> (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context!!, R.color.brobnarToolbar)))
            "dis" -> (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context!!, R.color.disToolbar)))
            "logos" -> (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context!!, R.color.logosToolbar)))
            "mars" -> (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context!!, R.color.sanctumToolbar)))
            "sanctum" -> (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context!!, R.color.sanctumToolbar)))
            "saurian" -> (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context!!, R.color.saurianToolbar)))
            "shadow" -> (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context!!, R.color.shadowToolbar)))
            "staralliance" -> (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context!!, R.color.starallianceToolbar)))
            "untamed" -> (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context!!, R.color.untamedToolbar)))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(HouseViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        return root
    }
}