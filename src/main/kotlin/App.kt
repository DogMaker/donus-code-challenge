package main

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import main.application.web.routes.routesModule

fun main(args: Array<String>) {

    embeddedServer(Netty, port = 8080){
        jacksonConfig()
        routesModule()
    }.start(wait = true)
}
fun Application.jacksonConfig() {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
}





