package main.commons

data class ErrorResponse(
        val message: String,
        val details: List<String>
) {
    companion object {
        fun create(message: String, details: List<String> ) =
                ErrorResponse(
                        message = message,
                        details = details
                )
    }
}