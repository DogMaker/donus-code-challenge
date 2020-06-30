package main

import io.ktor.application.call
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JacksonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
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
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText("Consulta", ContentType.Text.Plain)
            }

            post("/cadastro") {
                //val post = call.receive<Movie>()
                call.respond(HttpStatusCode.Created, "teste cadastro")
            }
        }
    }
    server.start(wait = true)
}
