package com.saphirel.android.keyforgeassistant.ui.listing.cards

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.objects.card.UpgradeCard
import com.saphirel.android.keyforgeassistant.ui.adapters.UpgradesAdapter
import kotlinx.android.synthetic.main.fragment_upgrades.*

class UpgradesFragment (val cards: List<UpgradeCard>): CardFragment(R.layout.fragment_upgrades) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cardAdapter = UpgradesAdapter(
            cards,
            context!!
        ) as RecyclerView.Adapter<RecyclerView.ViewHolder>
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        upgrades_rv.apply {
            layoutManager = viewManager
            adapter = cardAdapter
        }
    }
}