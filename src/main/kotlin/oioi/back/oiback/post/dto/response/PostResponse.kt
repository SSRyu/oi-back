package oioi.back.oiback.post.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import oioi.back.oiback.post.PostCategory
import oioi.back.oiback.post.entities.Ingredient
import oioi.back.oiback.post.entities.Reply
import oioi.back.oiback.post.entities.Tag
import java.time.LocalDateTime

data class PostResponse(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("author")
    val author: String,
    @JsonProperty("content")
    val content: String,

    @JsonProperty("category")
    var category: PostCategory,
    @JsonProperty("ingredients")
    var ingredients: List<Ingredient>,

    @JsonProperty("view")
    val view: Long = 0L,
    @JsonProperty("good")
    val good: Long = 0L,

    @JsonProperty("replies")
    val replies: List<Reply>,
    @JsonProperty("tags")
    val tags: List<Tag>,

    @JsonProperty("createdAt")
    val createdAt: LocalDateTime,
    @JsonProperty("updatedAt")
    val updatedAt: LocalDateTime,
)
