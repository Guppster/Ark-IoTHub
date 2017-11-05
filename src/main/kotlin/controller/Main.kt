package controller

import io.ark.core.Network
import io.javalin.ApiBuilder.*
import io.javalin.Javalin

//Constants
val VERSION = "0.0.1"

val PORT = 4567

fun main(args: Array<String>)
{
    Network.getDevnet().warmup()

    val app = Javalin.create().apply{
        port(PORT)
    }.start()

    val moduleController = ModuleController
    val transactionController = TransactionController(moduleController)

    //The root path
    app.routes{

        path("")
        {
            post(ModuleController::register)
        }

        path("message")
        {
            get(transactionController::getLatest)
            post(transactionController::sendMessage)
        }
    }
}

