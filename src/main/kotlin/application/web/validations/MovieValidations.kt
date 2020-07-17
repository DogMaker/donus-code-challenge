package main.application.web.validations

import main.commons.exceptions.NotNullFieldsException
import main.domain.entities.Details
import main.domain.entities.Movie
import org.valiktor.ConstraintViolationException
import org.valiktor.functions.hasSize
import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isNotEmpty
import org.valiktor.validate

class MovieValidations {
    private val ary = ArrayList<String>()

    fun requiredFields(json: Movie) {
        validate(json) {
            validate(Movie::name).isNotBlank().isNotEmpty().hasSize(1,100)
        }
    }
}