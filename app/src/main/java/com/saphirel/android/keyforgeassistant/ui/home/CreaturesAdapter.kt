package com.saphirel.android.keyforgeassistant.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.Types
import com.saphirel.android.keyforgeassistant.objects.card.CreatureCard
import kotlinx.android.synthetic.main.card_view.view.*

class CreaturesAdapter(private val dataset: List<CreatureCard>, private val context: Context): RecyclerView.Adapter<CreaturesAdapter.CreatureCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatureCardViewHolder {
        val constraintLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false) as ConstraintLayout

        return CreatureCardViewHolder(constraintLayout)
    }

    override fun onBindViewHolder(holderCreature: CreatureCardViewHolder, position: Int) {
        holderCreature.constraintLayout.card_name_tv.text = dataset[position].name
        holderCreature.constraintLayout.card_extension_tv.text = dataset[position].extension.toString()
        holderCreature.constraintLayout.card_type_tv.text = dataset[position].type.name
        if (dataset[position].type == Types.CREATURE) {
            val value: CreatureCard = dataset[position] as CreatureCard
            holderCreature.constraintLayout.card_power_tv.text = "${value.power} ${value.armor}"
        }
        bindEffectsAdapter(dataset[position].effects, holderCreature.constraintLayout.card_effects_recycler)
    }

    private fun bindEffectsAdapter(effects: List<Effect>, view: RecyclerView) {
        val viewManager = LinearLayoutManager(context)
        val viewAdapter = EffectAdapter(effects)

        view.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun getItemCount() = dataset.size

    class CreatureCardViewHolder(val constraintLayout: ConstraintLayout) : RecyclerView.ViewHolder(constraintLayout) {

    }
}