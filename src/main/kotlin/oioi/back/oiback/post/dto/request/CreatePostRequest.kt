package oioi.back.oiback.post.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

data class CreatePostRequest (
    @JsonProperty("title")
    val title: String,
    @JsonProperty("author")
    val author: String,
    @JsonProperty("content")
    val content: String,
)