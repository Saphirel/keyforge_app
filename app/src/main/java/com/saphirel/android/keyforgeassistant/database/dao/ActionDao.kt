package com.saphirel.android.keyforgeassistant.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.saphirel.android.keyforgeassistant.database.models.ActionDb

@Dao
interface ActionDao {
    @Query("SELECT * FROM actiondb")
    fun getAll(): List<ActionDb>

    @Query("SELECT * FROM actiondb WHERE actionId IN (:actionIds)")
    fun loadAllByIds(actionIds: IntArray): List<ActionDb>

    @Query("SELECT * FROM actiondb WHERE actionHouseName LIKE (:houseName)")
    fun loadAllByHouseName(houseName: String): List<ActionDb>

    @Query("SELECT * FROM actiondb WHERE actionName LIKE :name")
    fun findByName(name: String): ActionDb

    @Insert
    fun insertAll(vararg actions: ActionDb)

    @Delete
    fun delete(action: ActionDb)
}