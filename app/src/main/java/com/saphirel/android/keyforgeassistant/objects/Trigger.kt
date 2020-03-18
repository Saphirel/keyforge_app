package com.saphirel.android.keyforgeassistant.objects

enum class Trigger {
    PLAY,
    FIGHT,
    REAP,
    ACTION,
    OMNI,
    DESTROYED,
    BEFORE_FIGHT,
    LEAVES_PLAY,
    ANY;

    companion object {
        fun formatEffectTriggers(appliesWhen: List<Trigger>): String {
            var res = ""
            appliesWhen.map {s ->
                when (s) {
                    ACTION -> res += "/Action"
                    REAP -> res += "/Reap"
                    FIGHT -> res += "/Fight"
                    PLAY -> res += "/Play"
                    LEAVES_PLAY -> res += "/Leaves Play"
                    OMNI -> res += "/Omni"
                    BEFORE_FIGHT -> res += "/Before Fight"
                    DESTROYED -> res += "/Destroyed"
                    ANY -> res = ""
                }
            }
            if (res.length > 0)
                res = "<b>${res.subSequence(1, res.length)} : </b>"

            return res
        }
    }
}