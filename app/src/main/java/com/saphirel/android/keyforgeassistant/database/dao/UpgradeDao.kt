package com.saphirel.android.keyforgeassistant.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.saphirel.android.keyforgeassistant.database.models.ActionDb
import com.saphirel.android.keyforgeassistant.database.models.CreatureDb
import com.saphirel.android.keyforgeassistant.database.models.UpgradeDb

@Dao
interface UpgradeDao {
    @Query("SELECT * FROM upgradedb")
    fun getAll(): List<UpgradeDb>

    @Query("SELECT * FROM upgradedb WHERE upgradeId IN (:upgradeIds)")
    fun loadAllByIds(upgradeIds: IntArray): List<UpgradeDb>

    @Query("SELECT * FROM upgradedb WHERE upgradeHouseName LIKE (:houseName)")
    fun loadAllByHouseName(houseName: String): List<UpgradeDb>

    @Query("SELECT * FROM upgradedb WHERE upgradeName LIKE :name")
    fun findByName(name: String): UpgradeDb

    @Insert
    fun insertAll(vararg upgrades: UpgradeDb)

    @Delete
    fun delete(upgrade: UpgradeDb)
}