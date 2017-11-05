package controller

import io.ark.core.Network
import io.ark.core.Transaction
import io.javalin.Context

class TransactionController(private var moduleController: ModuleController)
{
    fun getLatest(context: Context)
    {
        //Queries the
    }

    fun sendMessage(context: Context)
    {

        /*
        Requires:
            Recipient Address
            Vendor Field Message
            Module Address
         */

        var peer =  Network.getDevnet().randomPeer

        var transaction = constructMessage("test", "test", "test")

        var result = peer.postTransaction(transaction)
    }

    fun constructMessage(moduleAddress: String, recipientAddress: String, vendorField: String) : Transaction
    {
        return Transaction.createTransaction(recipientAddress,
                1,
                vendorField,
                moduleController.getPassphrase(moduleAddress))
    }
}