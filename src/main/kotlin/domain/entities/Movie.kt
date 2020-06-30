package main.domain.entities

import java.util.Date

data class Movie(
  val name: String,
  val censured: Boolean,
  val releaseDate: String,
  val details: Details
)