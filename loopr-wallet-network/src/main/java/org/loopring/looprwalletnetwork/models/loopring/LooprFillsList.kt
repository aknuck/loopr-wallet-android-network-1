package org.loopring.looprwalletnetwork.models.loopring

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import java.lang.reflect.Type

open class LooprFillsList : RealmObject() {

    /**
     * TODO - figure out what this id is
     * Example output - 64
     */
    @SerializedName("id")
    var id : Int?  = null

    /**
     * String representing the version of jsonrpc. Should match the one used in the request
     * Example output - "2.0"
     */
    @SerializedName("jsonrpc")
    var jsonrpc : String? = null

    /**
     * The list of results in the form of [LooprFill] objects
     */
    var fills : RealmList<LooprFill>? = null

    /**
     * Page index
     * Example output - 1
     */
    var pageIndex : Int? = null

    /**
     * Page size
     * Example output - 20
     */
    var pageSize : Int? = null

    /**
     * Total amount of fills
     * Example output - 212
     */
    var total : Int? = null


    /**
     * Custom class deserializer
     */
    class LooprFillsListDeserializer : JsonDeserializer<LooprFillsList> {
        @Throws(JsonParseException::class)
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): LooprFillsList? {
            if (json.isJsonNull || json.isJsonPrimitive) {
                return null
            } else {
                val jsonObj = json.asJsonObject
                val fillList = LooprFillsList()

                //TODO - check if this code is enough to handle normally encountered errors
                jsonObj.get("id")?.let {
                    fillList.id = it.asInt
                }

                jsonObj.get("jsonrpc")?.let {
                    fillList.jsonrpc  = it.asString
                }

                jsonObj.get("result")?.let {
                    fillList.fills = RealmList()

                    val jsonFillsArray = it.asJsonObject.get("data").asJsonArray
                    jsonFillsArray.forEach {
                        fillList.fills?.add(context.deserialize(it.asJsonObject,LooprFill::class.java))
                    }

                    it.asJsonObject.get("pageIndex")?.let {
                        fillList.pageIndex = it.asInt
                    }

                    it.asJsonObject.get("pageSize")?.let {
                        fillList.pageSize = it.asInt
                    }

                    it.asJsonObject.get("total")?.let {
                        fillList.total = it.asInt
                    }
                }

                return fillList
            }
        }

    }


}