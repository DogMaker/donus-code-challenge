package main.application.web.validations

import main.domain.entities.Movie

class MovieValidations {
    private val ary = ArrayList<String>()

    fun requiredFields(json: Movie): ArrayList<String> {
        if (json.name.isBlank()) ary.add("name")
        if (json.details.cast.contains(" ")||json.details.cast.contains("")) ary.add("details.cast")
        if (json.details.direction.isBlank()) ary.add("details.direction")

        return ary
    }

    fun date(){

    }

    fun cast(){

    }
}