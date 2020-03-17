package com.saphirel.android.keyforgeassistant.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ActionDb(
    @ColumnInfo(name = "actionHouseName") var houseName: String,
    @ColumnInfo(name = "actionName") var name: String,
    @ColumnInfo(name = "actionAember") val aember: Int,
    @ColumnInfo(name = "actionExpansion") val expansion: String,
    @ColumnInfo(name = "actionSpecialEffects") val specialEffects: String,
    @ColumnInfo(name = "actionEffects") val serializedEffectsIds: String) {

    @PrimaryKey(autoGenerate = true) var actionId: Int = 0

}