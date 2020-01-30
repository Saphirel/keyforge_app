package com.saphirel.android.keyforgeassistant.ui.listing.cards

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.objects.card.ArtifactCard
import com.saphirel.android.keyforgeassistant.ui.adapters.ArtifactsAdapter
import kotlinx.android.synthetic.main.fragment_artifacts.*

class ArtifactsFragment(val cards: List<ArtifactCard>): CardFragment(R.layout.fragment_artifacts) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cardAdapter = ArtifactsAdapter(
            cards,
            context!!
        ) as RecyclerView.Adapter<RecyclerView.ViewHolder>
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        artifacts_rv.apply {
            layoutManager = viewManager
            adapter = cardAdapter
        }
    }
}