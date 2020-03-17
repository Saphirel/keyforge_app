package com.saphirel.android.keyforgeassistant.objects

import com.saphirel.android.keyforgeassistant.objects.card.*
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class House() {
    var name: String = ""
    var creatures: List<CreatureCard> = ArrayList()
    var upgrades: List<UpgradeCard> = ArrayList()
    var artifacts: List<ArtifactCard> = ArrayList()
    var actions: List<ActionCard> = ArrayList()

    constructor(houseName: String): this() {
        this.name = houseName
    }

    fun addCard(card: Card) {
        when (card.type) {
            Types.CREATURE -> (this.creatures as ArrayList).add(card as CreatureCard)
            Types.ACTION -> (this.actions as ArrayList).add(card as ActionCard)
            Types.ARTIFACT -> (this.artifacts as ArrayList).add(card as ArtifactCard)
            Types.UPGRADE -> (this.upgrades as ArrayList).add(card as UpgradeCard)
        }
    }
}