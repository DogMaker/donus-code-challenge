package main.commons.exceptions

import io.ktor.http.HttpStatusCode

class NotNullFieldsException(private val parameter: String) : MovieApiException() {
    override fun response() = "Os campos devem estar preenchidos $parameter"

    override fun statusCode() = HttpStatusCode.BadRequest
}

