package main.domain.exceptions

import io.ktor.http.HttpStatusCode

class CastLimitException(): MovieApiException() {

    override fun response() = "O limite de integrantes no cast não pode ser maior que 10"

    override fun statusCode() = HttpStatusCode.BadRequest
}

