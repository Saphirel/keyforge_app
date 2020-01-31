package com.saphirel.android.keyforgeassistant.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.Utils
import com.saphirel.android.keyforgeassistant.Utils.Companion.bindEffectsAdapter
import com.saphirel.android.keyforgeassistant.objects.card.ArtifactCard
import kotlinx.android.synthetic.main.card_artifact_view.view.aember_layout
import kotlinx.android.synthetic.main.card_artifact_view.view.aember_tv
import kotlinx.android.synthetic.main.card_artifact_view.view.card_effects_recycler
import kotlinx.android.synthetic.main.card_artifact_view.view.card_extensions_layout
import kotlinx.android.synthetic.main.card_artifact_view.view.card_name_tv

class ArtifactsAdapter(private val dataset: List<ArtifactCard>, private val context: Context): RecyclerView.Adapter<ArtifactsAdapter.ArtifactCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtifactCardViewHolder {
        val constraintLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_artifact_view, parent, false) as ConstraintLayout

        return ArtifactCardViewHolder(
            constraintLayout
        )
    }

    override fun onBindViewHolder(holder: ArtifactCardViewHolder, position: Int) {
        holder.constraintLayout.card_name_tv.text = dataset[position].name
        when (dataset[position].aember) {
            0 -> holder.constraintLayout.aember_layout.visibility = View.GONE
            else -> holder.constraintLayout.aember_tv.text = dataset[position].aember.toString()
        }
        Utils.toggleExtensionIcon(holder.constraintLayout.card_extensions_layout, dataset[position].extension)

//        val specialEffects = Utils.formatSpecialCombatEffects(dataset[position].special)
//        when (specialEffects.length) {
//            0 -> holder.constraintLayout.card_combat_effects_tv.visibility = View.GONE
//            else -> holder.constraintLayout.card_combat_effects_tv.text = specialEffects
//        }
        bindEffectsAdapter(dataset[position].effects, holder.constraintLayout.card_effects_recycler, context)
    }

    override fun getItemCount() = dataset.size

    class ArtifactCardViewHolder(val constraintLayout: ConstraintLayout) : RecyclerView.ViewHolder(constraintLayout) {

    }
}