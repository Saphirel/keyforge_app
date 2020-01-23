package com.saphirel.android.keyforgeassistant.objects.card

import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.Extensions
import com.saphirel.android.keyforgeassistant.objects.SpecialEffects
import com.saphirel.android.keyforgeassistant.objects.Types
import com.squareup.moshi.JsonClass

interface Card {
    var name: String
    var extension: List<Extensions>
    var aember: Int
    var effects: List<Effect>
    var type: Types
    var special: List<SpecialEffects>
}