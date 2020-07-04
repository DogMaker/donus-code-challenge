package main.application.web.routes

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.request.receiveText
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import main.application.web.controller.SaveMovieController


fun Application.routesModule() {
    routing {
        get("/") {
            call.respondText("Consulta", ContentType.Text.Plain)
        }

        post("/cadastro") {
            val json = call.receiveText()
            val response = SaveMovieController.create(json)
            call.respondText(response, ContentType.Text.Plain)
        }
    }
}
