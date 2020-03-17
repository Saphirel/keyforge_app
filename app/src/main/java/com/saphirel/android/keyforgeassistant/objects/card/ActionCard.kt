package com.saphirel.android.keyforgeassistant.objects.card

import com.saphirel.android.keyforgeassistant.database.models.ActionDb
import com.saphirel.android.keyforgeassistant.objects.*
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class ActionCard(): Card {

    lateinit var special: List<SpecialEffect>

    override var name = ""
    override lateinit var extension: List<Extensions>
    override var aember = 0
    override lateinit var effects: List<Effect>
    override var type: Types = Types.ACTION

    constructor(
        name: String,
        extension: List<Extensions>,
        aember: Int,
        special: List<SpecialEffect>,
        effects: List<Effect>
    ): this() {
        this.name = name
        this.extension = extension
        this.aember = aember
        this.special = special
        this.effects = effects
    }

    constructor(actionDb: ActionDb, effects: List<Effect>): this() {
        this.name = actionDb.name
        this.aember = actionDb.aember

        this.special = ArrayList()
        if (actionDb.specialEffects != "")
            actionDb.specialEffects.split(",").map { special -> (this.special as ArrayList).add(SpecialEffect.valueOf(special)) }

        this.extension = ArrayList()
        actionDb.expansion.split(",").map { expansion -> (this.extension as ArrayList).add(Extensions.valueOf(expansion)) }

        this.effects = effects
    }

    fun toDb(serializedEffectsIds: String, houseName: String): ActionDb {
        return ActionDb(houseName, this.name, this.aember, Extensions.serialize(this.extension), SpecialEffect.serialize(this.special), serializedEffectsIds)
    }
}