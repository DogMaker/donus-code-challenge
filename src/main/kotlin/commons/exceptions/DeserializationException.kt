package main.commons.exceptions

import io.ktor.http.HttpStatusCode


class DeserializationException() : MovieApiException() {
    override fun response() = "Cannot deserialize json to requested class"

    override fun statusCode() = HttpStatusCode.BadRequest
}
