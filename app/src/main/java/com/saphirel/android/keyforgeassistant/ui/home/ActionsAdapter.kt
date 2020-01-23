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
import com.saphirel.android.keyforgeassistant.objects.card.ActionCard
import com.saphirel.android.keyforgeassistant.objects.card.CreatureCard
import kotlinx.android.synthetic.main.card_view.view.*

class ActionsAdapter(private val dataset: List<ActionCard>, private val context: Context): RecyclerView.Adapter<ActionsAdapter.ActionCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionCardViewHolder {
        val constraintLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false) as ConstraintLayout

        return ActionCardViewHolder(constraintLayout)
    }

    override fun onBindViewHolder(holder: ActionCardViewHolder, position: Int) {
        holder.constraintLayout.card_name_tv.text = dataset[position].name
        holder.constraintLayout.card_extension_tv.text = dataset[position].extension.toString()

        bindEffectsAdapter(dataset[position].effects, holder.constraintLayout.card_effects_recycler)
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

    class ActionCardViewHolder(val constraintLayout: ConstraintLayout) : RecyclerView.ViewHolder(constraintLayout) {

    }
}