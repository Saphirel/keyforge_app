package com.saphirel.android.keyforgeassistant.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UpgradeDb(
    @ColumnInfo(name = "upgradeHouseName") var houseName: String,
    @ColumnInfo(name = "upgradeName") var name: String,
    @ColumnInfo(name = "upgradeAember") val aember: Int,
    @ColumnInfo(name = "upgradeExpansion") val expansion: String,
    @ColumnInfo(name = "upgradeEffects") val serializedEffectsIds: String) {

    @PrimaryKey(autoGenerate = true) var upgradeId: Int = 0

}