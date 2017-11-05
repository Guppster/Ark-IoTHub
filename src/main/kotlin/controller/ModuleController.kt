package controller

import io.javalin.Context
import model.Module

object ModuleController
{
    private var modules = mutableListOf<Module>()

    fun register(ctx: Context)
    {
        //Get the address of the account
        //Record available functionality (eg. lock/unlock)

        registerModule("temp")
        TODO("Extract address from context")
    }

    private fun registerModule(address: String)
    {
        //Get functionality from blockchain

        modules.add(Module(address = address, passphrase = null, functionality = null))
    }

    fun getPassphrase(address: String): String?
    {
       TODO()
    }
}
