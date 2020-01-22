package com.saphirel.android.keyforgeassistant.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.objects.Effect
import kotlinx.android.synthetic.main.card_view.view.*
import kotlinx.android.synthetic.main.effect_view.view.*

class EffectAdapter(private val dataset: List<Effect>): RecyclerView.Adapter<EffectAdapter.EffectViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EffectViewHolder {
        val constraintLayout = LayoutInflater.from(parent.context).inflate(R.layout.effect_view, parent, false) as ConstraintLayout

        return EffectViewHolder(constraintLayout)
    }

    override fun onBindViewHolder(holder: EffectViewHolder , position: Int) {
        holder.constraintLayout.effect_text.text = dataset[position].text
        holder.constraintLayout.effect_trigger.text = dataset[position].appliesWhen.toString()
    }

    override fun getItemCount() = dataset.size

    class EffectViewHolder(val constraintLayout: ConstraintLayout) : RecyclerView.ViewHolder(constraintLayout)
}