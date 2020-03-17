package com.saphirel.android.keyforgeassistant.objects

enum class Extensions {
    COTA,
    AOA,
    WC;

    companion object {
        fun serialize(extensions: List<Extensions>): String {
            return extensions.joinToString(",")
        }
    }
}