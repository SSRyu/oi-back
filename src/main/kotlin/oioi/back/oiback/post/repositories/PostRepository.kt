package oioi.back.oiback.post.repositories

import oioi.back.oiback.post.entities.Post
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : CrudRepository<Post, Long> {
    fun save(post: Post): Post
}
