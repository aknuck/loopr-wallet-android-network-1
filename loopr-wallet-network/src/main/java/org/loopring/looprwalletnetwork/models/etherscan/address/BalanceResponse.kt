package org.loopring.looprwalletnetwork.models.etherscan.address

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import java.math.BigDecimal

/**
 * Created by arknw229 on 2/28/18.
 *
 * Etherscan API
 *
 * Retrieve account balance:
 *
 * ```
 * {
 *   status
 *   message
 *   balance
 * }
 * ```
 *
 * @author arknw229
 */
open class BalanceResponse : RealmObject() {

    /**
     * Status of the request. Can be 1 for complete or 0 for failure.
     */
    var status: Int? = null

    /**
     * Status message. Can be "OK" for successful calls or "NOTOK" for failures
     */
    var message: String? = null

    /**
     * The balance of the account in wei, example output - 670456215218885498951364 would be 670,456.21... eth
     */
    var balance: BigDecimal?
        get() = mBalance?.let { BigDecimal(it) }
        set(value) {
            mBalance = value?.toPlainString()
        }

    @SerializedName("result")
    private var mBalance: String? = null

}
