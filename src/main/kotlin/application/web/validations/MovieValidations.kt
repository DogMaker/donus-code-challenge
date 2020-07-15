package main.application.web.validations

import main.domain.entities.MovieResponse

class MovieValidations {
    private val ary = ArrayList<String>()

    fun requiredFields(json: MovieResponse): ArrayList<String> {
        if (json.movie.name.isBlank()) ary.add("name")
        if (json.movie.details.cast.contains(" ")
                ||json.movie.details.cast.contains("")) ary.add("details.cast")
        if (json.movie.details.direction.isBlank()) ary.add("details.direction")

        return ary
    }

    fun date(){

    }

    fun cast(){

    }
}