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
import main.commons.exceptions.NotNullFieldsException


fun Application.routesModule() {
    routing {
        get("/") {
            call.respondText("Consulta", ContentType.Text.Plain)
        }

        post("/cadastro") {
            val json = call.receiveText()
            val responseObj = try{
                SaveMovieController.create(json)
            }catch (e: NotNullFieldsException) {
                call.respond(
                   responseTemplate("desearilizar",HttpStatusCode.BadRequest)
                )
            } catch (e: NotNullFieldsException) {
                call.respond(
                        responseTemplate("Validação",HttpStatusCode.BadRequest)
                )
            }
            val responseJson = SaveMovieController.objectMapperConfig()!!
                    .writeValueAsString(responseObj)

            call.respond(
                    TextContent(
                            responseJson!!,
                            ContentType.Application.Json,
                            HttpStatusCode.Created
                    )
            )
        }
    }
}

fun responseTemplate(contentBody: String, responseCode: HttpStatusCode): TextContent {
    return TextContent(
            contentBody,
            ContentType.Application.Json,
            responseCode
    )
}
