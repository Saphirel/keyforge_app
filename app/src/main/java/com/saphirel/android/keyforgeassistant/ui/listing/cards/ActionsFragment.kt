package com.saphirel.android.keyforgeassistant.ui.listing.cards

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.objects.card.ActionCard
import com.saphirel.android.keyforgeassistant.ui.adapters.ActionsAdapter
import kotlinx.android.synthetic.main.fragment_actions.*

class ActionsFragment (val cards: List<ActionCard>): CardFragment(R.layout.fragment_actions) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cardAdapter = ActionsAdapter(
            cards,
            context!!
        ) as RecyclerView.Adapter<RecyclerView.ViewHolder>
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        actions_rv.apply {
            layoutManager = viewManager
            adapter = cardAdapter
        }
    }
}