package com.saphirel.android.keyforgeassistant.objects.card

import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.Extensions
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class UpgradeCard(var name: String, var extension: List<Extensions>, var aember: Int, var effects: List<Effect>) {
}