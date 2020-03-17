package com.saphirel.android.keyforgeassistant.database.models.converters

import androidx.room.TypeConverter

class ListConverter {
    @TypeConverter
    fun toStringList(value: String?): List<String>? {
        return value?.split(',')
    }

    @TypeConverter
    fun toIntList(value: String?): List<Integer>? {
        val intList: ArrayList<Integer> = ArrayList()
        value?.split(',')?.map { e -> intList.add(Integer(e)) }
        return intList
    }

    @TypeConverter
    fun listToString(list: List<String>?): String? {
        return list?.joinToString(",")
    }
}