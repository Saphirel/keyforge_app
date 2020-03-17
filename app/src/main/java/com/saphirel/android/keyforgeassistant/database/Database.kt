package com.saphirel.android.keyforgeassistant.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saphirel.android.keyforgeassistant.database.dao.*
import com.saphirel.android.keyforgeassistant.database.models.*
import com.saphirel.android.keyforgeassistant.database.models.converters.ListConverter

@Database(entities = arrayOf(HouseDb::class, EffectDb::class, CreatureDb::class, ActionDb::class, ArtifactDb::class, UpgradeDb::class), version = 1)
@TypeConverters(ListConverter::class)
abstract class Database : RoomDatabase() {
    abstract fun houseDao(): HouseDao
    abstract fun effectDao(): EffectDao
    abstract fun creatureDao(): CreatureDao
    abstract fun actionDao(): ActionDao
    abstract fun artifactDao(): ArtifactDao
    abstract fun upgradeDao(): UpgradeDao
}