package main.application.web.controller

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import main.application.web.validations.MovieValidations
import main.commons.exceptions.DeserializationException
import main.domain.entities.Movie
import main.domain.entities.MovieResponse
import main.domain.services.SaveMovieService

object SaveMovieController{

    fun create(json: String): MovieResponse {
        val movieRequest = try {
            objectMapperConfig().readValue(json, Movie::class.java)
        }catch (e: JsonParseException) {
            throw DeserializationException()
        }

        MovieValidations().requiredFields(movieRequest)

        return SaveMovieService().create(movieRequest)
    }
    fun objectMapperConfig(): ObjectMapper {
        val objectMapper = jacksonObjectMapper()
        objectMapper.propertyNamingStrategy =  SNAKE_CASE
        objectMapper.setSerializationInclusion(Include.NON_NULL)
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

        return objectMapper
    }
}


