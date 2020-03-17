package com.saphirel.android.keyforgeassistant.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.saphirel.android.keyforgeassistant.database.models.ArtifactDb

@Dao
interface ArtifactDao {
    @Query("SELECT * FROM artifactdb")
    fun getAll(): List<ArtifactDb>

    @Query("SELECT * FROM artifactdb WHERE artifactId IN (:artifactIds)")
    fun loadAllByIds(artifactIds: IntArray): List<ArtifactDb>

    @Query("SELECT * FROM artifactdb WHERE artifactHouseName LIKE (:houseName)")
    fun loadAllByHouseName(houseName: String): List<ArtifactDb>

    @Query("SELECT * FROM artifactdb WHERE artifactName LIKE :name")
    fun findByName(name: String): ArtifactDb

    @Insert
    fun insertAll(vararg artifacts: ArtifactDb)

    @Delete
    fun delete(artifact: ArtifactDb)
}