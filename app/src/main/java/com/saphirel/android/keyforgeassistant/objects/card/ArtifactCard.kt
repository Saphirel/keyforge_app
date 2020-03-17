package com.saphirel.android.keyforgeassistant.objects.card

import com.saphirel.android.keyforgeassistant.database.models.ArtifactDb
import com.saphirel.android.keyforgeassistant.objects.*
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class ArtifactCard(): Card {

    lateinit var traits: List<Traits>

    override var name = ""
    override lateinit var extension: List<Extensions>
    override var aember = 0
    override lateinit var effects: List<Effect>
    override var type: Types = Types.ARTIFACT

    constructor(name: String, extension: List<Extensions>, aember: Int, traits: List<Traits>, effects: List<Effect>): this() {
        this.name = name
        this.extension = extension
        this.aember = aember
        this.traits = traits
        this.effects = effects
    }

    constructor(artifactDb: ArtifactDb, effects: List<Effect>): this() {
        this.name = artifactDb.name
        this.aember = artifactDb.aember

        this.traits = ArrayList()
        artifactDb.traits.split(",").map { trait -> (this.traits as ArrayList).add(Traits.valueOf(trait)) }

        this.extension = ArrayList()
        artifactDb.expansion.split(",").map { expansion -> (this.extension as ArrayList).add(Extensions.valueOf(expansion)) }

        this.effects = effects
    }

    fun toDb(serializedEffectsIds: String, houseName: String): ArtifactDb {
        return ArtifactDb(houseName, this.name, this.aember, Extensions.serialize(this.extension), Traits.serialize(this.traits), serializedEffectsIds)
    }
}