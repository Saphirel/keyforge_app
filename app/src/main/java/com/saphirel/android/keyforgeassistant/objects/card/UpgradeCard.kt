package com.saphirel.android.keyforgeassistant.objects.card

import com.saphirel.android.keyforgeassistant.database.models.ActionDb
import com.saphirel.android.keyforgeassistant.database.models.UpgradeDb
import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.Extensions
import com.saphirel.android.keyforgeassistant.objects.Types
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class UpgradeCard(): Card {

    override var name = ""
    override lateinit var extension: List<Extensions>
    override var aember = 0
    override lateinit var effects: List<Effect>
    override var type: Types = Types.UPGRADE

    constructor(name: String, extension: List<Extensions>, aember: Int, effects: List<Effect>): this() {
        this.name = name
        this.extension = extension
        this.aember = aember
        this.effects = effects
    }

    constructor(upgradeDb: UpgradeDb, effects: List<Effect>): this() {
        this.name = upgradeDb.name
        this.aember = upgradeDb.aember

        this.extension = ArrayList()
        upgradeDb.expansion.split(",").map { expansion -> (this.extension as ArrayList).add(Extensions.valueOf(expansion)) }

        this.effects = effects
    }

    fun toDb(serializedEffectsIds: String, houseName: String): UpgradeDb {
        return UpgradeDb(houseName, this.name, this.aember, Extensions.serialize(this.extension), serializedEffectsIds)
    }
}