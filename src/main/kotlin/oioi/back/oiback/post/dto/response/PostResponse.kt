package oioi.back.oiback.post.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class PostResponse(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("author")
    val author: String,
    @JsonProperty("content")
    val content: String,

    @JsonProperty("view")
    val view: Long = 0L,
    @JsonProperty("like")
    val like: Long = 0L,
    @JsonProperty("createdAt")
    val createdAt: LocalDateTime,
    @JsonProperty("updatedAt")
    val updatedAt: LocalDateTime,

//    @JsonProperty("replies")
//    val replies: List<Reply> = mutableListOf(),
//    @JsonProperty("tags")
//    val tags: List<Tag> =  = mutableListOf(),
)
