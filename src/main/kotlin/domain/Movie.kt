package main.domain

import java.util.Date

data class Movie(
  val name: String,
  val censured: Boolean,
  val date: Date,
  val details: Details
)