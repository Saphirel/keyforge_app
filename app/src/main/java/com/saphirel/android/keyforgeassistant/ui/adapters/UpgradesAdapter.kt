package com.saphirel.android.keyforgeassistant.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.card.UpgradeCard
import kotlinx.android.synthetic.main.card_artifact_view.view.*

class UpgradesAdapter(private val dataset: List<UpgradeCard>, private val context: Context): RecyclerView.Adapter<UpgradesAdapter.UpgradesCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpgradesCardViewHolder {
        val constraintLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_upgrade_view, parent, false) as ConstraintLayout

        return UpgradesCardViewHolder(
            constraintLayout
        )
    }

    override fun onBindViewHolder(holderUpgradeCard: UpgradesCardViewHolder, position: Int) {
        holderUpgradeCard.constraintLayout.card_name_tv.text = dataset[position].name
        holderUpgradeCard.constraintLayout.card_extension_tv.text = dataset[position].extension.toString()

        bindEffectsAdapter(dataset[position].effects, holderUpgradeCard.constraintLayout.card_effects_recycler)
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

    class UpgradesCardViewHolder(val constraintLayout: ConstraintLayout) : RecyclerView.ViewHolder(constraintLayout) {

    }
}