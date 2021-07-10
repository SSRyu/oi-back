package oioi.back.oiback.post.entities

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "post")
data class Post (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long,

    @Column(name = "title", nullable = false)
    val title: String,
    @Column(name = "author", nullable = false)
    val author: String,
    @Column(name = "content", nullable = false)
    val content: String,

    @Column(name = "view", nullable = false)
    val view: Long = 0L,
    @Column(name = "like", nullable = false)
    val like: Long = 0L,
    @CreatedDate
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime,
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    val updatedAt: LocalDateTime,
    @Column(name = "deleted_at", nullable = true)
    val deletedAt: LocalDateTime?,
    @Column(name = "is_deleted", nullable = false)
    val isDeleted: Boolean = false,

//    @OneToMany(mappedBy = "id")
//    @Column(name = "replies")
//    val replies: List<Reply> = mutableListOf(),
//    @OneToMany(mappedBy = "id")
//    @Column(name = "tags")
//    val tags: List<Tag> =  = mutableListOf(),
)
