package com.saphirel.android.keyforgeassistant.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saphirel.android.keyforgeassistant.database.dao.HouseDao
import com.saphirel.android.keyforgeassistant.database.models.HouseDb

@Database(entities = arrayOf(HouseDb::class), version = 1)
abstract class Database : RoomDatabase() {
    abstract fun userDao(): HouseDao
}