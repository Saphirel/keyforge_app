package com.saphirel.android.keyforgeassistant.objects.card

import com.saphirel.android.keyforgeassistant.database.models.CreatureDb
import com.saphirel.android.keyforgeassistant.objects.*
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class CreatureCard(): Card {

    var armor: Int = 0
    var power: Int = 0
    lateinit var traits: List<Traits>
    lateinit var special: List<SpecialEffect>

    override var name = ""
    override lateinit var extension: List<Extensions>
    override var aember = 0
    override lateinit var effects: List<Effect>
    override var type: Types = Types.CREATURE

    constructor(name: String, extension: List<Extensions>, aember: Int, traits: List<Traits>, special: List<SpecialEffect>, effects: List<Effect>, power: Int, armor: Int): this() {
        this.name = name
        this.extension = extension
        this.aember = aember
        this.traits = traits
        this.effects = effects
        this.power = power
        this.armor = armor
        this.special = special
    }

    constructor(creatureDb: CreatureDb, effects: List<Effect>): this() {
        this.name = creatureDb.name
        this.aember = creatureDb.aember
        this.power = creatureDb.power
        this.armor = creatureDb.armor

        this.special = ArrayList()
        if (creatureDb.specialEffects != "")
            creatureDb.specialEffects.split(",").map { special -> (this.special as ArrayList).add(SpecialEffect.valueOf(special)) }

        this.extension = ArrayList()
        creatureDb.expansion.split(",").map { expansion -> (this.extension as ArrayList).add(Extensions.valueOf(expansion)) }

        this.traits = ArrayList()
        creatureDb.traits.split(",").map { trait -> (this.traits as ArrayList).add(Traits.valueOf(trait)) }

        this.effects = effects
    }

    fun toDb(serializedEffectsIds: String, houseName: String): CreatureDb {
        return CreatureDb(houseName, this.name, this.power,this.armor, this.aember, Extensions.serialize(this.extension), SpecialEffect.serialize(this.special), Traits.serialize(this.traits), serializedEffectsIds)
    }
}