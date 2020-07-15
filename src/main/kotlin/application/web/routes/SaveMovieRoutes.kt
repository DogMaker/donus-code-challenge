package main.application.web.routes

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.content.TextContent
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.request.receiveText
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import main.application.web.controller.SaveMovieController
import main.application.web.controller.objectMapperConfig
import main.application.web.validations.MovieValidations
import main.commons.ErrorResponse


fun Application.routesModule() {
    routing {
        get("/") {
            call.respondText("Consulta", ContentType.Text.Plain)
        }

        post("/cadastro") {
            val json = call.receiveText()
            val responseObj = SaveMovieController.create(json)
            val responseJson = objectMapperConfig()!!.writeValueAsString(responseObj)
            val fields = MovieValidations().requiredFields(responseObj)
            if(fields.size > 0){
                val messageError = ErrorResponse.create("Os campos não devem ser vazios ou nulos", fields)
                val fieldsResponse = objectMapperConfig()!!.writeValueAsString(messageError)
                call.respond(
                        TextContent (
                                fieldsResponse,
                                ContentType.Application.Json,
                                HttpStatusCode.BadRequest
                        )
                )
            }
            call.respond(
                    TextContent (
                            responseJson!!,
                            ContentType.Application.Json,
                            HttpStatusCode.Created
                    )
            )
        }
    }
}
