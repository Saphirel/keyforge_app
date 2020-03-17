package com.saphirel.android.keyforgeassistant.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CreatureDb(
    @ColumnInfo(name = "creatureHouseName") var houseName: String,
    @ColumnInfo(name = "creatureName") var name: String,
    @ColumnInfo(name = "creaturePower") var power: Int,
    @ColumnInfo(name = "creatureArmor") val armor: Int,
    @ColumnInfo(name = "creatureAember") val aember: Int,
    @ColumnInfo(name = "creatureExpansion") val expansion: String,
    @ColumnInfo(name = "creatureSpecialEffects") val specialEffects: String,
    @ColumnInfo(name = "creatureTraits") val traits: String,
    @ColumnInfo(name = "creatureEffects") val serializedEffectsIds: String) {

    @PrimaryKey(autoGenerate = true) var creatureId: Int = 0

}