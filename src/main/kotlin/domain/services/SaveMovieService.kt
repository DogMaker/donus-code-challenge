package main.domain.services

import main.domain.entities.Movie
import main.domain.entities.MovieResponse
import java.util.UUID

class SaveMovieService{
    fun create(json: Movie): MovieResponse{
        println("Criar validação de regras")
        println("Chamando Repository para inserir no banco")

        return MovieResponse(UUID.randomUUID(), json)
    }
}