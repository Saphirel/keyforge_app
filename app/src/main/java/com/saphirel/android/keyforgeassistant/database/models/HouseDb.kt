package com.saphirel.android.keyforgeassistant.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HouseDb(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?
)