package main.application.web.validations

import main.commons.exceptions.NotNullFieldsException
import main.domain.entities.Details
import main.domain.entities.Movie
import org.valiktor.ConstraintViolationException
import org.valiktor.functions.isNotBlank
import org.valiktor.validate

class MovieValidations {
    private val ary = ArrayList<String>()

    fun requiredFields(movieRequest: Movie) {
        try {
            validate(movieRequest) {
                validate(Movie::name).isNotBlank()
                validate(Movie::releaseDate).isNotBlank()
            }
            validate(movieRequest.details) {
                validate(Details::direction).isNotBlank()
            }

        } catch (e: ConstraintViolationException) {
            e.constraintViolations
                    .map { throw NotNullFieldsException(it.constraint.name)}
        }

    }
}