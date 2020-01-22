package com.saphirel.android.keyforgeassistant.objects.card

import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.Extensions
import com.saphirel.android.keyforgeassistant.objects.Traits
import com.saphirel.android.keyforgeassistant.objects.Types
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class CreatureCard(): Card {

    var armor: Int = 0
    var power: Int = 0
    lateinit var traits: List<Traits>

    override var name = ""
    override lateinit var extension: List<Extensions>
    override var aember = 0
    override lateinit var effects: List<Effect>
    override var type: Types = Types.CREATURE

    constructor(name: String, extension: List<Extensions>, aember: Int, traits: List<Traits>, effects: List<Effect>, power: Int, armor: Int): this() {
        this.name = name
        this.extension = extension
        this.aember = aember
        this.traits = traits
        this.effects = effects
        this.power = power
        this.armor = armor
    }
}