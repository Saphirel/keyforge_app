package com.saphirel.android.keyforgeassistant.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArtifactDb(
    @ColumnInfo(name = "artifactHouseName") var houseName: String,
    @ColumnInfo(name = "artifactName") var name: String,
    @ColumnInfo(name = "artifactAember") val aember: Int,
    @ColumnInfo(name = "artifactExpansion") val expansion: String,
    @ColumnInfo(name = "artifactTraits") val traits: String,
    @ColumnInfo(name = "artifactEffects") val serializedEffectsIds: String) {

    @PrimaryKey(autoGenerate = true) var artifactId: Int = 0

}