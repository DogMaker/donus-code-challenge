package main.commons.exceptions

import io.ktor.http.HttpStatusCode
import main.commons.ErrorResponse

class NotNullFieldsException() : MovieApiException() {
    override fun response() = ErrorResponse
            .create("Request cannot be processed because it contains invalid data", listOf("Cu temperado"))

    override fun statusCode() = HttpStatusCode.BadRequest
}