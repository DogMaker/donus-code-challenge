package main.domain.exceptions

import io.ktor.http.HttpStatusCode

class DuplicateMovieException(): MovieApiException() {

    override fun response() = "Este filme ja existe no registro"

    override fun statusCode() = HttpStatusCode.BadRequest
}
