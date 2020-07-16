package main.commons.exceptions

import io.ktor.http.HttpStatusCode
import main.commons.ErrorResponse

abstract class MovieApiException : RuntimeException() {

    abstract fun response(): ErrorResponse

    abstract fun statusCode(): HttpStatusCode
}