package com.saphirel.android.keyforgeassistant.objects.card

import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.Extensions
import com.saphirel.android.keyforgeassistant.objects.SpecialEffects
import com.saphirel.android.keyforgeassistant.objects.Traits
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class ArtifactCard(var name: String, var extension: List<Extensions>, var aember: Int, var traits: List<Traits>, var special: List<SpecialEffects>, var effects: List<Effect>) {

}