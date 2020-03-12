package com.saphirel.android.keyforgeassistant.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.R
import com.saphirel.android.keyforgeassistant.Utils
import com.saphirel.android.keyforgeassistant.Utils.Companion.bindEffectsAdapter
import com.saphirel.android.keyforgeassistant.objects.card.CreatureCard
import kotlinx.android.synthetic.main.card_creature_view.view.*
import kotlinx.android.synthetic.main.card_creature_view.view.card_effects_recycler
import kotlinx.android.synthetic.main.card_creature_view.view.card_extensions_layout
import kotlinx.android.synthetic.main.card_creature_view.view.card_name_tv

class CreaturesAdapter(private val dataset: List<CreatureCard>, private val houseName: String, private val context: Context): RecyclerView.Adapter<CreaturesAdapter.CreatureCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatureCardViewHolder {
        val constraintLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_creature_view, parent, false) as ConstraintLayout

        return CreatureCardViewHolder(
            constraintLayout
        )
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: CreatureCardViewHolder, position: Int) {
        updateCardNameBackgroundColorDependingHouse(holder.constraintLayout.card_title_layout, houseName)

        holder.constraintLayout.card_name_tv.text = dataset[position].name
        Utils.toggleExtensionIcon(holder.constraintLayout.card_extensions_layout, dataset[position].extension)

        when (dataset[position].aember) {
            0 -> holder.constraintLayout.aember_layout.visibility = View.GONE
            else -> {
                holder.constraintLayout.aember_layout.visibility = View.VISIBLE
                holder.constraintLayout.aember_tv.text = dataset[position].aember.toString()
            }
        }

        holder.constraintLayout.card_power_tv.text = "${dataset[position].power}"
        holder.constraintLayout.card_shield_tv.text = "${dataset[position].armor}"
        holder.constraintLayout.card_combat_effects_tv.text = Utils.formatSpecialCombatEffects(dataset[position].special)

        bindEffectsAdapter(dataset[position].effects, holder.constraintLayout.card_effects_recycler, context)
    }

    @SuppressLint("ResourceAsColor")
    private fun updateCardNameBackgroundColorDependingHouse(
        cardTitleLayout: ConstraintLayout,
        houseName: String
    ) {
        when (houseName) {
            "brobnar" -> cardTitleLayout.setBackgroundColor(context.resources.getColor(R.color.brobnarTitleCard))
            "dis" -> cardTitleLayout.setBackgroundColor(context.resources.getColor(R.color.disTitleCard))
            "logos" -> cardTitleLayout.setBackgroundColor(context.resources.getColor(R.color.logosTitleCard))
            "mars" -> cardTitleLayout.setBackgroundColor(context.resources.getColor(R.color.marsTitleCard))
            "sanctum" -> cardTitleLayout.setBackgroundColor(context.resources.getColor(R.color.sanctumTitleCard))
            "saurian" -> cardTitleLayout.setBackgroundColor(context.resources.getColor(R.color.saurianTitleCard))
            "shadow" -> cardTitleLayout.setBackgroundColor(context.resources.getColor(R.color.shadowTitleCard))
            "staralliance" -> cardTitleLayout.setBackgroundColor(context.resources.getColor(R.color.starallianceTitleCard))
            "untamed" -> cardTitleLayout.setBackgroundColor(context.resources.getColor(R.color.untamedTitleCard))
        }
    }

    override fun getItemCount() = dataset.size

    class CreatureCardViewHolder(val constraintLayout: ConstraintLayout) : RecyclerView.ViewHolder(constraintLayout) {

    }
}