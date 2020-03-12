package com.saphirel.android.keyforgeassistant.ui.listing.cards

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.objects.card.CreatureCard
import com.saphirel.android.keyforgeassistant.ui.adapters.CreaturesAdapter
import kotlinx.android.synthetic.main.fragment_creatures.*

class CreaturesFragment(
    val cards: List<CreatureCard>,
    val houseName: String
): CardFragment(R.layout.fragment_creatures) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cardAdapter = CreaturesAdapter(
            cards,
            houseName,
            context!!
        ) as RecyclerView.Adapter<RecyclerView.ViewHolder>
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        creatures_rv.apply {
            layoutManager = viewManager
            adapter = cardAdapter
        }
    }
}