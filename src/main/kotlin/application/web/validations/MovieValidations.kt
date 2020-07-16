package main.application.web.validations

import main.commons.exceptions.NotNullFieldsException
import main.domain.entities.Movie

class MovieValidations {
    private val ary = ArrayList<String>()

    fun requiredFields(json: Movie): ArrayList<String> {
        try {
            json.name.isBlank()
        } catch (e: Exception) {
            throw NotNullFieldsException()
        }
        when {
            json.name.isBlank() -> throw NotNullFieldsException()
            else -> {
                return ary
            }

            /*
                if (json.name.isBlank()) ary.add("O campo name deve ser informado")

        if (json.details.cast.contains(" ")
                ||json.details.cast.contains("")) ary.add("Os item do cast não podem ter valores em brancos ou vazios")
        if (json.details.cast.size == 0 ) ary.add("Deve existir ao menos um item na lista de cast")
        if (json.details.direction.isBlank()) ary.add("O campo direction deve ser informado")
*/

        }

        fun date() {

        }

        fun cast() {

        }
    }
}