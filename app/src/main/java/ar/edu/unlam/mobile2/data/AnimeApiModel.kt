package ar.edu.unlam.mobile2.data

data class AnimeApiModel (
    val mal_id: Int,
    val url: String,
    val image_url: String,
    val title: String,
    val title_english: String,
    val title_japanese: String,
    val episodes: Int,
    val status: String,
    val from: String,
    val to: String,
    val duration: String,
    val score: Float,
    val scoredB_by: Int,
    val rank: Int,
    val popularity: Int,
    val members: Int,
    val favorites: Int,
    val synopsis: String,
    val year: Int
)