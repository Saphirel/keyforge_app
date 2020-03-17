package com.saphirel.android.keyforgeassistant.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.saphirel.android.keyforgeassistant.database.models.EffectDb

@Dao
interface EffectDao {
    @Query("SELECT * FROM effectdb")
    fun getAll(): List<EffectDb>

    @Query("SELECT * FROM effectdb WHERE effectId IN (:effectId)")
    fun loadAllByIds(effectId: IntArray): List<EffectDb>

    @Query("SELECT * FROM effectdb WHERE effectText LIKE :name")
    fun findByName(name: String): EffectDb

    @Query("SELECT * FROM effectdb WHERE effectId LIKE :id")
    fun findById(id: Int): EffectDb

    @Insert
    fun insertAll(vararg effects: EffectDb): List<Long>

    @Delete
    fun delete(effect: EffectDb)
}