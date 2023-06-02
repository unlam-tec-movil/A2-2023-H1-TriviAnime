package ar.edu.unlam.mobile2.data

data class AnimeApiModel (
    val id: String,
    val title: String,
    val large: String,
    val medium: String,
    val synonyms: Array<String>,
    val en: String,
    val ja: String,
    val start_date: String,
    val end_date: String,
    val synopsis: String,
    val mean: Float,
    val rank: Int,
    val popularity: Int,
    val num_episodes: Int,
)