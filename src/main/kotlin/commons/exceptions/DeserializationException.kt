package main.commons.exceptions

import io.ktor.http.HttpStatusCode
import main.domain.exceptions.MovieApiException


class DeserializationException() : MovieApiException() {
    override fun response() = "Cannot deserialize json to requested class"

    override fun statusCode() = HttpStatusCode.BadRequest
}
