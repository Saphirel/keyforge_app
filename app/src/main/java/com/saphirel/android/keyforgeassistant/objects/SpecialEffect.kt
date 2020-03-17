package com.saphirel.android.keyforgeassistant.objects

enum class SpecialEffect {
    ALPHA,
    OMEGA,

    ASSAULT_1,
    ASSAULT_2,
    ASSAULT_3,
    ASSAULT_4,

    HAZARDOUS_1,
    HAZARDOUS_2,
    HAZARDOUS_3,
    HAZARDOUS_4,
    HAZARDOUS_5,
    HAZARDOUS_6,

    ELUSIVE,
    SKIRMISH,
    TAUNT,
    DEPLOY,
    POISON;

    companion object {

        fun serialize(special: List<SpecialEffect>): String {
            return special.joinToString(",")
        }

        fun formatSpecialCombatEffects(appliesWhen: List<SpecialEffect>): String {
            var res = ""
            appliesWhen.map {s ->
                when (s) {
                    ELUSIVE -> res += ", Elusive"
                    SKIRMISH -> res += ", Skirmish"
                    DEPLOY -> res += ", Deploy"
                    TAUNT -> res += ", Taunt"
                    POISON -> res += ", Poison"

                    ASSAULT_1 -> res += ", Assault 1"
                    ASSAULT_2 -> res += ", Assault 2"
                    ASSAULT_3 -> res = ", Assault 3"
                    ASSAULT_4 -> res = ", Assault 4"

                    HAZARDOUS_1 -> res = ", Hazardous 1"
                    HAZARDOUS_2 -> res = ", Hazardous 2"
                    HAZARDOUS_3 -> res = ", Hazardous 3"
                    HAZARDOUS_4 -> res = ", Hazardous 4"
                    HAZARDOUS_5 -> res = ", Hazardous 5"
                    HAZARDOUS_6 -> res = ", Hazardous 6"

                    ALPHA -> res = ", Alpha"
                    OMEGA -> res = ", Omega"
                    else -> res += ""
                }
            }
            if (res.length > 0)
                res = "${res.subSequence(2, res.length)}"

            return res
        }
    }
}