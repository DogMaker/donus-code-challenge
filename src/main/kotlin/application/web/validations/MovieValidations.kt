package main.application.web.validations

import main.commons.exceptions.NotNullFieldsException
import main.domain.entities.Movie
import org.valiktor.ConstraintViolationException
import org.valiktor.functions.isNotBlank
import org.valiktor.validate

class MovieValidations {
    private val ary = ArrayList<String>()

    fun requiredFields(json: Movie) {
        try {
            validate(json) {
                validate(Movie::name).isNotBlank()
            }
        } catch (ex: ConstraintViolationException) {
            ex.constraintViolations
                    .map { throw NotNullFieldsException(it.constraint.name)}
        }

    }

}