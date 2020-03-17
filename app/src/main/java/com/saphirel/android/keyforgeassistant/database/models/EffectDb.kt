package com.saphirel.android.keyforgeassistant.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EffectDb(
    @ColumnInfo(name = "effectTriggers") val triggers: List<String>,
    @ColumnInfo(name = "effectText") val text: String
    ) {
    @PrimaryKey(autoGenerate = true) var effectId: Int = 0
}