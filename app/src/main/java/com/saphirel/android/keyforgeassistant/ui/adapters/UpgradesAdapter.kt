package com.saphirel.android.keyforgeassistant.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.Utils
import com.saphirel.android.keyforgeassistant.Utils.Companion.bindEffectsAdapter
import com.saphirel.android.keyforgeassistant.objects.card.UpgradeCard
import kotlinx.android.synthetic.main.card_artifact_view.view.*
import kotlinx.android.synthetic.main.card_upgrade_view.view.*
import kotlinx.android.synthetic.main.card_upgrade_view.view.aember_layout
import kotlinx.android.synthetic.main.card_upgrade_view.view.aember_tv
import kotlinx.android.synthetic.main.card_upgrade_view.view.card_effects_recycler
import kotlinx.android.synthetic.main.card_upgrade_view.view.card_extensions_layout
import kotlinx.android.synthetic.main.card_upgrade_view.view.card_name_tv

class UpgradesAdapter(private val dataset: List<UpgradeCard>, private val context: Context): RecyclerView.Adapter<UpgradesAdapter.UpgradesCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpgradesCardViewHolder {
        val constraintLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_upgrade_view, parent, false) as ConstraintLayout

        return UpgradesCardViewHolder(
            constraintLayout
        )
    }

    override fun onBindViewHolder(holder: UpgradesCardViewHolder, position: Int) {
        holder.constraintLayout.card_name_tv.text = dataset[position].name
        Utils.toggleExtensionIcon(holder.constraintLayout.card_extensions_layout, dataset[position].extension)

        when (dataset[position].aember) {
            0 -> holder.constraintLayout.aember_layout.visibility = View.GONE
            else -> holder.constraintLayout.aember_tv.text = dataset[position].aember.toString()
        }
        bindEffectsAdapter(
            dataset[position].effects,
            holder.constraintLayout.card_effects_recycler,
            context
        )

        bindEffectsAdapter(dataset[position].effects, holder.constraintLayout.card_effects_recycler, context)
    }

    override fun getItemCount() = dataset.size

    class UpgradesCardViewHolder(val constraintLayout: ConstraintLayout) : RecyclerView.ViewHolder(constraintLayout) {

    }
}