package main.commons.exceptions

import io.ktor.application.ApplicationCall
import io.ktor.content.TextContent
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond


abstract class MovieApiException : Exception {
    constructor() : super()

    abstract fun response(): String
    abstract fun statusCode(): HttpStatusCode
}


