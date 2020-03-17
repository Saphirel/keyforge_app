package com.saphirel.android.keyforgeassistant.objects

import com.saphirel.android.keyforgeassistant.database.models.EffectDb

class Effect() {

    lateinit var appliesWhen: List<Trigger>
    lateinit var text: String

    constructor(appliesWhen: List<Trigger>, text: String): this() {
// dataset.add(new BBCHItem(cursor.getInt(0), cursor.getString(2)));
        this.appliesWhen = appliesWhen
        this.text = text
    }

    constructor(effectDb: EffectDb): this() {
        val tmp = ArrayList<Trigger>()
        effectDb.triggers.map { triggerDb -> tmp.add(Trigger.valueOf(triggerDb)) }

        this.appliesWhen = tmp
        this.text = effectDb.text
    }

    fun toDb(): EffectDb {
        val serializedTriggers: ArrayList<String> = ArrayList()
        appliesWhen.map { trigger -> serializedTriggers.add(trigger.name) }
        return EffectDb(serializedTriggers, text)
    }

}