package main

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentConverter
import io.ktor.features.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.jackson.JacksonConverter
import io.ktor.jackson.jackson
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import main.domain.entities.Movie

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

fun Application.routesModule() {
    routing {
        get("/") {
            call.respondText("Consulta", ContentType.Text.Plain)
        }

        post("/cadastro") {
            val post = call.receive<Movie>()
            call.respond(HttpStatusCode.Created, post.details)
        }
    }
}



