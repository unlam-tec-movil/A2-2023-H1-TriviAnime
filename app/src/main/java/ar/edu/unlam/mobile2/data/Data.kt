package ar.edu.unlam.mobile2.data
import com.google.gson.annotations.SerializedName

data class Data(
  @SerializedName("mal_id")
  val malId: Long,
  val url: String,
  val images: Images,
  val trailer: Trailer,
  val approved: Boolean,
  val titles: List<Title>,
  val title: String,
  @SerializedName("title_english")
  val titleEnglish: Any?,
  @SerializedName("title_japanese")
  val titleJapanese: String,
  @SerializedName("title_synonyms")
  val titleSynonyms: List<Any?>,
  val type: String,
  val source: String,
  val episodes: Long,
  val status: String,
  val airing: Boolean,
  val aired: Aired,
  val duration: String,
  val rating: String,
  val score: Double,
  @SerializedName("scored_by")
  val scoredBy: Long,
  val rank: Long,
  val popularity: Long,
  val members: Long,
  val favorites: Long,
  val synopsis: String,
  val background: Any?,
  val season: String,
  val year: Long,
  val broadcast: Broadcast,
  val producers: List<Producer>,
  val licensors: List<Any?>,
  val studios: List<Any?>,
  val genres: List<Genre>,
  @SerializedName("explicit_genres")
  val explicitGenres: List<Any?>,
  val themes: List<Any?>,
  val demographics: List<Demographic>,
)

data class Images(
  val jpg: Jpg,
  val webp: Webp,
)

data class Jpg(
  @SerializedName("image_url")
  val imageUrl: String,
  @SerializedName("small_image_url")
  val smallImageUrl: String,
  @SerializedName("large_image_url")
  val largeImageUrl: String,
)

data class Webp(
  @SerializedName("image_url")
  val imageUrl: String,
  @SerializedName("small_image_url")
  val smallImageUrl: String,
  @SerializedName("large_image_url")
  val largeImageUrl: String,
)

data class Trailer(
  @SerializedName("youtube_id")
  val youtubeId: Any?,
  val url: Any?,
  @SerializedName("embed_url")
  val embedUrl: Any?,
  val images: Images2,
)

data class Images2(
  @SerializedName("image_url")
  val imageUrl: Any?,
  @SerializedName("small_image_url")
  val smallImageUrl: Any?,
  @SerializedName("medium_image_url")
  val mediumImageUrl: Any?,
  @SerializedName("large_image_url")
  val largeImageUrl: Any?,
  @SerializedName("maximum_image_url")
  val maximumImageUrl: Any?,
)

data class Title(
  val type: String,
  val title: String,
)

data class Aired(
  val from: String,
  val to: String,
  val prop: Prop,
  val string: String,
)

data class Prop(
  val from: From,
  val to: To,
)

data class From(
  val day: Long,
  val month: Long,
  val year: Long,
)

data class To(
  val day: Long,
  val month: Long,
  val year: Long,
)

data class Broadcast(
  val day: Any?,
  val time: Any?,
  val timezone: Any?,
  val string: String,
)

data class Producer(
  @SerializedName("mal_id")
  val malId: Long,
  val type: String,
  val name: String,
  val url: String,
)

data class Genre(
  @SerializedName("mal_id")
  val malId: Long,
  val type: String,
  val name: String,
  val url: String,
)

data class Demographic(
  @SerializedName("mal_id")
  val malId: Long,
  val type: String,
  val name: String,
  val url: String,
)
