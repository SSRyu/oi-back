package oioi.back.oiback.post.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import oioi.back.oiback.post.PostCategory
import oioi.back.oiback.user.entities.OiUser
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "post")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator::class, property = "id")
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long = 0L,

    @Column(name = "title", nullable = false)
    var title: String,
    @ManyToOne
    @JoinColumn(name = "user_id")
    var author: OiUser,
    @Column(name = "content", nullable = false)
    var content: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    var category: PostCategory,
    @OneToMany(mappedBy = "id")
    @Column(name = "ingredients", nullable = true)
    var ingredients: List<Ingredient> = mutableListOf(),

    @Column(name = "view", nullable = false)
    var view: Long = 0L,
    @Column(name = "good", nullable = false)
    var good: Long = 0L,

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "deleted_at", nullable = true)
    var deletedAt: LocalDateTime? = null,
    @Column(name = "is_deleted", nullable = false)
    var isDeleted: Boolean = false,

    @OneToMany(mappedBy = "id")
    @Column(name = "replies")
    var replies: List<Reply> = mutableListOf(),
    @OneToMany(mappedBy = "id")
    @Column(name = "tags")
    var tags: List<Tag> = mutableListOf(),
)
