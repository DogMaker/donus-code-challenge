package main

import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import main.application.web.routes.routesModule

fun main(args: Array<String>) {

    embeddedServer(Netty, port = 8080){
        routesModule()
    }.start(wait = true)
}






