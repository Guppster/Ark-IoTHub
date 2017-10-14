package controller

import io.ark.core.Network
import io.ark.core.Transaction
import io.javalin.Context

class TransactionController(private var moduleController: ModuleController)
{
    fun getLatest(context: Context)
    {

    }

    fun sendMessage(context: Context)
    {
        var peer =  Network.getDevnet().randomPeer

        var transaction = Transaction.createTransaction("recipient address extracted from context",1, "Some message we extract from context", moduleController.getPassphrase("Address extracted from context"))

        var result = peer.postTransaction(transaction)
    }
}