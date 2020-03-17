package com.saphirel.android.keyforgeassistant.objects.card

import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.Extensions
import com.saphirel.android.keyforgeassistant.objects.SpecialEffect
import com.saphirel.android.keyforgeassistant.objects.Types

interface Card {
    var name: String
    var extension: List<Extensions>
    var aember: Int
    var effects: List<Effect>
    var type: Types
}