package org.loopring.looprwalletnetwork.models.loopring.responseObjects

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import java.util.*

open class LooprCutoff : RealmObject() {

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
     * The cutoff timestamp string
     * Example output - "1501232222"
     */
    @SerializedName("result")
    var cutoff : Date? = null
}