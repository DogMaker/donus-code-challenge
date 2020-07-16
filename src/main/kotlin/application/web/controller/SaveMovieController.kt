package main.application.web.controller

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import main.application.web.validations.MovieValidations
import main.commons.ErrorResponse
import main.domain.entities.Movie
import main.domain.entities.MovieResponse
import main.domain.services.SaveMovieService
import java.util.*


object SaveMovieController{

    fun create(json: String): MovieResponse {
         val json = runCatching  {
               objectMapperConfig()!!.readValue(json, Movie::class.java)
         }.getOrElse {
             throw Exception("Criar DeserializationException")
         }
        val fields = MovieValidations().requiredFields(json)
        if(fields.size > 0) {
            val messageError = ErrorResponse.create("Os campos não devem ser vazios ou nulos", fields)
            MovieResponse(UUID.randomUUID(), json)
        }
        return SaveMovieService().create(json)
     }
}

fun objectMapperConfig(): ObjectMapper {
    val objectMapper = jacksonObjectMapper()
    objectMapper.propertyNamingStrategy =  SNAKE_CASE
    objectMapper.setSerializationInclusion(Include.NON_NULL)
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

    return objectMapper
}

