package com.saphirel.android.keyforgeassistant

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.Extensions
import com.saphirel.android.keyforgeassistant.objects.SpecialEffect
import com.saphirel.android.keyforgeassistant.ui.adapters.EffectAdapter
import kotlinx.android.synthetic.main.card_artifact_view.view.*

class Utils {

    companion object {
        fun toggleExtensionIcon(cardExtensionsLayout: LinearLayout, extensions: List<Extensions>) {
            if (extensions.contains(Extensions.COTA))
                cardExtensionsLayout.cota_icon.visibility = View.VISIBLE
            else
                cardExtensionsLayout.cota_icon.visibility = View.GONE
            if (extensions.contains(Extensions.AOA))
                cardExtensionsLayout.aoa_icon.visibility = View.VISIBLE
            else
                cardExtensionsLayout.aoa_icon.visibility = View.GONE
            if (extensions.contains(Extensions.WC))
                cardExtensionsLayout.wc_icon.visibility = View.VISIBLE
            else
                cardExtensionsLayout.wc_icon.visibility = View.GONE
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
    }
}