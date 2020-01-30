package com.saphirel.android.keyforgeassistant.objects.card

import com.saphirel.android.keyforgeassistant.objects.*
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class ArtifactCard(var name: String, var extension: List<Extensions>, var type: Types = Types.ARTIFACT, var aember: Int, var traits: List<Traits>, var effects: List<Effect>) {

}