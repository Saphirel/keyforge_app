package com.saphirel.android.keyforgeassistant

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.Extensions
import com.saphirel.android.keyforgeassistant.objects.SpecialEffects
import com.saphirel.android.keyforgeassistant.ui.adapters.EffectAdapter
import kotlinx.android.synthetic.main.card_artifact_view.view.*

class Utils {

    companion object {
        fun toggleExtensionIcon(cardExtensionsLayout: LinearLayout, extensions: List<Extensions>) {
            if (extensions.contains(Extensions.COTA))
                cardExtensionsLayout.cota_icon.visibility = View.VISIBLE
            if (extensions.contains(Extensions.AOA))
                cardExtensionsLayout.aoa_icon.visibility = View.VISIBLE
            if (extensions.contains(Extensions.WC))
                cardExtensionsLayout.wc_icon.visibility = View.VISIBLE
        }

        fun bindEffectsAdapter(effects: List<Effect>, view: RecyclerView, context: Context) {
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

        fun formatSpecialCombatEffects(appliesWhen: List<SpecialEffects>): String {
            var res = ""
            appliesWhen.map {s ->
                when (s) {
                    SpecialEffects.ELUSIVE -> res += ", Elusive"
                    SpecialEffects.SKIRMISH -> res += ", Skirmish"
                    SpecialEffects.ASSAULT_1 -> res += ", Assault 1"
                    SpecialEffects.ASSAULT_2 -> res += ", Assault 2"
                    SpecialEffects.ASSAULT_3 -> res = ", Assault 3"
                    SpecialEffects.ASSAULT_4 -> res = ", Assault 4"
                    SpecialEffects.ALPHA -> res = ", Alpha"
                    SpecialEffects.OMEGA -> res = ", Omega"
                    //SpecialEffects. -> res = ""
                    else -> res += ""
                }
            }
            if (res.length > 0)
                res = "${res.subSequence(2, res.length)}"

            return res
        }

        fun formatEffectTriggers(appliesWhen: List<SpecialEffects>): String {
            var res = ""
            appliesWhen.map {s ->
                when (s) {
                    SpecialEffects.ACTION -> res += "/Action"
                    SpecialEffects.REAP -> res += "/Reap"
                    SpecialEffects.FIGHT -> res += "/Fight"
                    SpecialEffects.PLAY -> res += "/Play"
                    SpecialEffects.ANY -> res = ""
                    else -> res += ""
                }
            }
            if (res.length > 0)
                res = "<b>${res.subSequence(1, res.length)} : </b>"

            return res
        }
    }
}