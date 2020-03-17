package com.saphirel.android.keyforgeassistant.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.saphirel.android.keyforgeassistant.database.models.HouseDb

@Dao
interface HouseDao {
    @Query("SELECT * FROM housedb")
    fun getAll(): List<HouseDb>

    @Query("SELECT * FROM housedb WHERE id IN (:houseIds)")
    fun loadAllByIds(houseIds: IntArray): List<HouseDb>

    @Query("SELECT * FROM housedb WHERE houseName LIKE :name")
    fun findByName(name: String): HouseDb

    @Insert
    fun insertAll(vararg houses: HouseDb)

    @Delete
    fun delete(user: HouseDb)
}