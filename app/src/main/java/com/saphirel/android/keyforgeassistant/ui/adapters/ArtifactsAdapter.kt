package com.saphirel.android.keyforgeassistant.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.card.ArtifactCard
import kotlinx.android.synthetic.main.card_artifact_view.view.*

class ArtifactsAdapter(private val dataset: List<ArtifactCard>, private val context: Context): RecyclerView.Adapter<ArtifactsAdapter.ArtifactCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtifactCardViewHolder {
        val constraintLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_artifact_view, parent, false) as ConstraintLayout

        return ArtifactCardViewHolder(
            constraintLayout
        )
    }

    override fun onBindViewHolder(cardHolder: ArtifactCardViewHolder, position: Int) {
        cardHolder.constraintLayout.card_name_tv.text = dataset[position].name
        cardHolder.constraintLayout.aember_tv.text = dataset[position].aember.toString()
        cardHolder.constraintLayout.card_extension_tv.text = dataset[position].extension.toString()

        bindEffectsAdapter(dataset[position].effects, cardHolder.constraintLayout.card_effects_recycler)
    }

    private fun bindEffectsAdapter(effects: List<Effect>, view: RecyclerView) {
        val viewManager = LinearLayoutManager(context)
        val viewAdapter =
            EffectAdapter(
                effects
            )

        view.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun getItemCount() = dataset.size

    class ArtifactCardViewHolder(val constraintLayout: ConstraintLayout) : RecyclerView.ViewHolder(constraintLayout) {

    }
}