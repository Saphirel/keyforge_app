package com.saphirel.android.keyforgeassistant.database

import android.util.Log
import com.saphirel.android.keyforgeassistant.AppActivity
import com.saphirel.android.keyforgeassistant.database.models.ActionDb
import com.saphirel.android.keyforgeassistant.database.models.CreatureDb
import com.saphirel.android.keyforgeassistant.database.models.HouseDb
import com.saphirel.android.keyforgeassistant.json.JSonManager
import com.saphirel.android.keyforgeassistant.objects.Effect
import com.saphirel.android.keyforgeassistant.objects.House
import com.saphirel.android.keyforgeassistant.objects.Types
import com.saphirel.android.keyforgeassistant.objects.card.*
import kotlinx.coroutines.*

class DbUtils {

//    var res: List<CreatureDb>
//    val process = GlobalScope.async {
//        res = app.db?.creatureDao()!!.getAll()
//    }
//    runBlocking { process.await() }
//
//    print("prout")

    companion object {

        fun initDbWithJsonFiles(app: AppActivity) {
            val houseNames = arrayOf("brobnar", "dis", "logos", "untamed", "sanctum", "mars", "saurian", "shadow")

            pushHousesToDb(houseNames, app)
            houseNames.map { houseName -> pushHouseCardsToDb(JSonManager.loadHouseCardsFromJSon(houseName, app.resources, app.applicationContext)!!, app) }
        }

        private fun pushHousesToDb(houseNames: Array<String>, app: AppActivity) {
            val process = GlobalScope.async {
                houseNames.map { houseName -> app.db?.houseDao()!!.insertAll(HouseDb(houseName)) }
            }
            runBlocking { process.await() }
        }

        fun pushHouseCardsToDb(house: House, app: AppActivity) {
            Log.d("CREATURE", "Loading creatures...")
            house.creatures.map { creature -> pushCardToDb(creature, app, house.name) }
            print("Loading actions...")
            house.actions.map { action -> pushCardToDb(action, app, house.name) }
            print("Loading artifacts...")
            house.artifacts.map { artifact -> pushCardToDb(artifact, app, house.name) }
            print("Loading upgrades...")
            house.upgrades.map { upgrade -> pushCardToDb(upgrade, app, house.name) }
        }

        private fun pushCardToDb(
            card: Card,
            app: AppActivity,
            houseName: String
        ) {
            val effectsIds = pushEffectToDb(card.effects, app)

            val process = when (card.type) {
                Types.CREATURE -> GlobalScope.async {
                    app.db?.creatureDao()!!.insertAll((card as CreatureCard).toDb(effectsIds.joinToString(","), houseName))
                }
                Types.UPGRADE -> GlobalScope.async {
                    app.db?.upgradeDao()!!.insertAll((card as UpgradeCard).toDb(effectsIds.joinToString(","), houseName))
                }
                Types.ARTIFACT -> GlobalScope.async {
                    app.db?.artifactDao()!!.insertAll((card as ArtifactCard).toDb(effectsIds.joinToString(","), houseName))
                }
                Types.ACTION -> GlobalScope.async {
                    app.db?.actionDao()!!.insertAll((card as ActionCard).toDb(effectsIds.joinToString(","), houseName))
                }
            }

            runBlocking { process.await() }
        }

        fun pullCardsFromDbByHouse(
            houseName: String,
            app: AppActivity
        ): House {
            val house = House(houseName)
            val creaturesProcess = GlobalScope.async {
                val creatureDbList = app.db?.creatureDao()!!.loadAllByHouseName(houseName)
                creatureDbList.map { creatureDb -> house.addCard(CreatureCard(creatureDb, getEffectsForCard(creatureDb.serializedEffectsIds, app))) }
            }

            val actionsProcess = GlobalScope.async {
                val actionDbList = app.db?.actionDao()!!.loadAllByHouseName(houseName)
                actionDbList.map { actionDb -> house.addCard(ActionCard(actionDb, getEffectsForCard(actionDb.serializedEffectsIds, app))) }
            }

            val upgradesProcess = GlobalScope.async {
                val upgradeDbList = app.db?.upgradeDao()!!.loadAllByHouseName(houseName)
                upgradeDbList.map { upgradeDb -> house.addCard(UpgradeCard(upgradeDb, getEffectsForCard(upgradeDb.serializedEffectsIds, app))) }
            }

            val artifactsProcess = GlobalScope.async {
                val artifactDbList = app.db?.artifactDao()!!.loadAllByHouseName(houseName)
                artifactDbList.map { artifactDb -> house.addCard(ArtifactCard(artifactDb, getEffectsForCard(artifactDb.serializedEffectsIds, app))) }
            }

            runBlocking {
                creaturesProcess.await()
                actionsProcess.await()
                upgradesProcess.await()
                artifactsProcess.await()
            }

            return house

//            val process = when (card.type) {
//                Types.CREATURE -> GlobalScope.async {
//                    app.db?.creatureDao()!!.insertAll((card as CreatureCard).toDb(effectsIds.joinToString(","), name))
//                }
//                Types.UPGRADE -> GlobalScope.async {
//                    app.db?.upgradeDao()!!.insertAll((card as UpgradeCard).toDb(effectsIds.joinToString(","), name))
//                }
//                Types.ARTIFACT -> GlobalScope.async {
//                    app.db?.artifactDao()!!.insertAll((card as ArtifactCard).toDb(effectsIds.joinToString(","), name))
//                }
//                Types.ACTION -> GlobalScope.async {
//                    app.db?.actionDao()!!.insertAll((card as ActionCard).toDb(effectsIds.joinToString(","), name))
//                }
//            }

            //runBlocking { process.await() }
        }

        private fun getEffectsForCard(serializedEffectsIds: String, app: AppActivity): List<Effect> {
            return if (serializedEffectsIds != "")
                pullEffectFromDb(serializedEffectsIds.split(",").map { it.toInt() }.toIntArray(), app)
            else
                ArrayList()
        }

        private fun pushEffectToDb(effects: List<Effect>, app: AppActivity): ArrayList<Long> {
            val effectsIds: ArrayList<Long> = ArrayList()
            effects.map { effect ->
                effectsIds.add(pushEffectToDb(effect, app))
            }

            return effectsIds
        }

        private fun pushEffectToDb(effect: Effect, app: AppActivity): Long {
            var id: Long = 0
            val process = GlobalScope.async {
                id = app.db?.effectDao()!!.insertAll(effect.toDb())[0]
            }
            runBlocking { process.await() }

            return id
        }

        private fun pullEffectFromDb(ids: IntArray, app: AppActivity): ArrayList<Effect> {
            val effects: ArrayList<Effect> = ArrayList()
            val process = GlobalScope.async {
                app.db?.effectDao()!!.loadAllByIds(ids).map { effectDb -> effects.add(Effect(effectDb)) }
            }
            runBlocking { process.await() }

            return effects
        }

        private fun pullEffectFromDb(id: Int, app: AppActivity): Effect {
            lateinit var effect: Effect
            val process = GlobalScope.async {
                effect = Effect(app.db?.effectDao()!!.findById(id))
            }
            runBlocking { process.await() }

            return effect
        }
    }
}