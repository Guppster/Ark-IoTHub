package controller

import io.javalin.Context
import model.Module
import khttp.get
import org.json.JSONArray
import org.json.JSONObject

const val NODE_ADDRESS = "https://api.arknode.net"
const val TRANSACTION_ENDPOINT = "/api/transactions"
const val IOT_MODULE_LABEL = "IOT MODULE:"

class ModuleController
{
    private var modules = mutableListOf<Module>()

    fun register(ctx: Context)
    {
        //Get the address of the account
        //Record available functionality (eg. lock/unlock)

        registerModule("temp")
        TODO("Extract address from context")
    }

    /**
     * Registers a module with the hub using it's address
     */
    fun registerModule(address: String)
    {
        val tempModule: Module = Module(address = address, passphrase = null, functionality = null)

        //Get functionality from blockchain
        val transactions: JSONArray = getTransactions(address = address).getJSONArray("transactions")

        val firstTxn: JSONObject = transactions.getJSONObject(transactions.length() - 1)

        //if the functionality block couldn't be processed, it is not a IoT module and we should not register it
        //if the firsttxn doesnt have a vendorfield, its not a IOT Module
        if (!firstTxn.has("vendorField")) return

        val vendorField = firstTxn.getString("vendorField")

        //If its not a IOT Module, return
        if(!vendorField.startsWith(IOT_MODULE_LABEL)) return

        //The first transaction on a module's account will be it's functionality csv
        tempModule.functionality = vendorField.substringAfter(IOT_MODULE_LABEL).split(",")

        println(tempModule.functionality)

        //Add this module to the list
        modules.add(tempModule)
    }

    fun getModules(): List<Module>
    {
       return modules
    }

    fun getTransactions(address: String): JSONObject
    {
        val payload = mapOf("senderId" to address, "recipientId" to address)

        return get(NODE_ADDRESS + TRANSACTION_ENDPOINT, params=payload).jsonObject
    }

    fun getPassphrase(address: String): String?
    {
       TODO()
    }
}
