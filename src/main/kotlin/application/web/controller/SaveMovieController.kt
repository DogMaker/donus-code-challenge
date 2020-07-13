package main.application.web.controller

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import main.application.web.validations.MovieValidations
import main.domain.entities.Movie
import main.domain.entities.MovieResponse
import main.domain.services.SaveMovieService


object SaveMovieController{

    fun create(json: String): MovieResponse {
         val json = runCatching  {
               objectMapperConfig()!!.readValue(json, Movie::class.java)
         }.getOrElse {
             throw Exception("Criar DeserializationException")
         }
         MovieValidations().requiredFields(json)
         return SaveMovieService().create(json)
     }
}

fun objectMapperConfig(): ObjectMapper {
    val objectMapper = jacksonObjectMapper()
    objectMapper.setSerializationInclusion(Include.NON_NULL)
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

    return objectMapper
}

