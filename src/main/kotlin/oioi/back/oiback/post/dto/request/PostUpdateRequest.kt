package oioi.back.oiback.post.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import oioi.back.oiback.post.PostCategory
import oioi.back.oiback.post.entities.Ingredient
import oioi.back.oiback.post.entities.Tag

data class PostUpdateRequest(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("content")
    val content: String,
    @JsonProperty("category")
    val category: PostCategory,
    @JsonProperty("ingredients")
    val ingredient: List<Ingredient> = mutableListOf(),
    @JsonProperty("tags")
    val tags: List<Tag> = mutableListOf(),
)
