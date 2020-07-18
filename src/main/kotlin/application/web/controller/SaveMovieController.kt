package main.application.web.controller

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import main.commons.exceptions.NotNullFieldsException
import main.domain.entities.Movie
import java.lang.Exception


object SaveMovieController{

    fun create(json: String): Any? {
        //MovieValidations().requiredFields(json)
        //MovieResponse(UUID.randomUUID(), movieRequest)

       // return SaveMovieService().create(movieRequest)
        return try {
            objectMapperConfig()!!.readValue(json, Movie::class.java)
        }catch (e: JsonParseException) {
              throw  NotNullFieldsException("VOce e trouxa")
        }
     }
    fun objectMapperConfig(): ObjectMapper {
        val objectMapper = jacksonObjectMapper()
        objectMapper.propertyNamingStrategy =  SNAKE_CASE
        objectMapper.setSerializationInclusion(Include.NON_NULL)
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

        return objectMapper
    }
}


