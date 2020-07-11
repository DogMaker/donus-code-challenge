package main.domain.entities

import java.util.UUID

data class MovieResponse(
  val id: UUID,
  val movie: Movie
)