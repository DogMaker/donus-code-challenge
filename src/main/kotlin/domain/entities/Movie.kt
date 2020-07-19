package main.domain.entities

data class Movie(
  val name: String,
  val censured: Boolean,
  val releaseDate: String,
  val details: Details
)