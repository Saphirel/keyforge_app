package com.saphirel.android.keyforgeassistant.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.saphirel.android.keyforgeassistant.database.models.CreatureDb

@Dao
interface CreatureDao {
    @Query("SELECT * FROM creaturedb")
    fun getAll(): List<CreatureDb>

    @Query("SELECT * FROM creaturedb WHERE creatureId IN (:creatureIds)")
    fun loadAllByIds(creatureIds: IntArray): List<CreatureDb>

    @Query("SELECT * FROM creaturedb WHERE creatureHouseName LIKE (:houseName)")
    fun loadAllByHouseName(houseName: String): List<CreatureDb>

    @Query("SELECT * FROM creaturedb WHERE creatureName LIKE :name")
    fun findByName(name: String): CreatureDb

    @Insert
    fun insertAll(vararg creatures: CreatureDb)

    @Delete
    fun delete(creature: CreatureDb)
}