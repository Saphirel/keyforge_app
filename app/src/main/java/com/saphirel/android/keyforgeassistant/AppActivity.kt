package com.saphirel.android.keyforgeassistant

import android.app.Application
import androidx.room.Room
import com.saphirel.android.keyforgeassistant.database.Database


class AppActivity : Application() {
    var db: Database? = null

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder<Database>(
            applicationContext,
            Database::class.java,
            "keyforge-assistant"
        ).build()
    }

    fun getDatabase(): Database? {
        return db
    }
}