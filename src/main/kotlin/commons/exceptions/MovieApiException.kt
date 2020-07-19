package main.commons.exceptions

import io.ktor.http.HttpStatusCode


abstract class MovieApiException : Exception {
    constructor() : super()

    abstract fun response(): String
    abstract fun statusCode(): HttpStatusCode
}


