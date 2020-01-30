package com.saphirel.android.keyforgeassistant.json

import android.content.Context
import android.content.res.Resources
import com.saphirel.android.keyforgeassistant.objects.House
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.BufferedReader

class JSonManager {
    companion object {
        fun loadHouseCardsFromJSon(houseName: String, resources: Resources, context: Context): House? {
//            db = Room.databaseBuilder(
//                context!!,
//                Database::class.java, "keyforge-assistant"
//            ).build()

            val raw = resources.openRawResource(resources.getIdentifier(houseName, "raw", context.packageName))
            val content = raw.bufferedReader().use(BufferedReader::readText)

            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val jsonAdapter: JsonAdapter<House> = moshi.adapter(
                House::class.java)

            return jsonAdapter.fromJson(content)
        }
    }
}