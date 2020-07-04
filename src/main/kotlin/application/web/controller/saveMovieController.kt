package main.application.web.controller

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.sun.xml.internal.ws.encoding.soap.DeserializationException
import org.slf4j.LoggerFactory

object SaveMovieController{

     val logger = LoggerFactory.getLogger(this::class.java)

     fun create(json: String):String {
         //jacksonObjectMapper().readAsTypedValue<Movie>(json)
         logger.info("Starting route creation process with json $json")
         return "$json"
     }
}
inline fun <reified T> ObjectMapper.readAsTypedValue(json: String): T =
        runCatching { readValue<T>(json, object : TypeReference<T>() {}) }
                .getOrElse { throw DeserializationException(
                        json,
                        T::class.java.name
                )
                }