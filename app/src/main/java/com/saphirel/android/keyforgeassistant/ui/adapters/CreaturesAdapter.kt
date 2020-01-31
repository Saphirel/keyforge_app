package com.saphirel.android.keyforgeassistant.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.Utils
import com.saphirel.android.keyforgeassistant.Utils.Companion.bindEffectsAdapter
import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.Types
import com.saphirel.android.keyforgeassistant.objects.card.CreatureCard
import kotlinx.android.synthetic.main.card_creature_view.view.*

class CreaturesAdapter(private val dataset: List<CreatureCard>, private val context: Context): RecyclerView.Adapter<CreaturesAdapter.CreatureCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatureCardViewHolder {
        val constraintLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_creature_view, parent, false) as ConstraintLayout

        return CreatureCardViewHolder(
            constraintLayout
        )
    }

    override fun onBindViewHolder(holderCreature: CreatureCardViewHolder, position: Int) {
        holderCreature.constraintLayout.card_name_tv.text = dataset[position].name
        Utils.toggleExtensionIcon(holderCreature.constraintLayout.card_extensions_layout, dataset[position].extension)
        holderCreature.constraintLayout.card_power_tv.text = "${dataset[position].power}"
        holderCreature.constraintLayout.card_shield_tv.text = "${dataset[position].armor}"
        holderCreature.constraintLayout.card_combat_effects_tv.text = Utils.formatSpecialCombatEffects(dataset[position].special)

        bindEffectsAdapter(dataset[position].effects, holderCreature.constraintLayout.card_effects_recycler, context)
    }

    override fun getItemCount() = dataset.size

    class CreatureCardViewHolder(val constraintLayout: ConstraintLayout) : RecyclerView.ViewHolder(constraintLayout) {

    }
}