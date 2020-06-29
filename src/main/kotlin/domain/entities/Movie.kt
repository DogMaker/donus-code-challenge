package main.domain.entities

import main.domain.entities.Details
import java.util.Date

data class Movie(
  val name: String,
  val censured: Boolean,
  val date: Date,
  val details: Details
)