package com.saphirel.android.keyforgeassistant.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HouseDb(
    @ColumnInfo(name = "houseName") val name: String?
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}