package com.saphirel.android.keyforgeassistant.objects

import com.saphirel.android.keyforgeassistant.objects.card.*
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class House (var name: String, var creatures: List<CreatureCard>, var upgrades: List<UpgradeCard>, var artifacts: List<ArtifactCard>, var actions: List<ActionCard>) {

}