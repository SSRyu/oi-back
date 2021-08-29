package oioi.back.oiback.post.services

import oioi.back.oiback.post.dto.request.PostCreateRequest
import oioi.back.oiback.post.dto.request.PostUpdateRequest
import oioi.back.oiback.post.dto.response.PostResponse
import oioi.back.oiback.post.entities.Post
import oioi.back.oiback.post.repositories.PostRepository
import oioi.back.oiback.user.entities.OiUser
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.persistence.EntityNotFoundException

@Service
class PostService (
    val postRepository: PostRepository
) {
    fun findAll(): MutableIterable<Post> {
        // TODO : paginated post list
        return postRepository.findAll()
    }

    fun findById(postId: Long): Post {
        return postRepository.findById(postId).orElseThrow{
            EntityNotFoundException("Post not found.")
        }
    }

    fun getPost(postId: Long): PostResponse {
        val post = findById(postId)
        return PostResponse(
            title = post.title,
            author = post.author.nickName,
            content = post.content,
            category = post.category,
            ingredients = post.ingredients,
            view = post.view,
            good = post.good,
            replies = post.replies,
            tags = post.tags,
            createdAt = post.createdAt,
            updatedAt = post.updatedAt,
        )
    }

    fun createPost(request: PostCreateRequest) {
        // TODO : get author from user token
        val author = OiUser(
            userId = "userId",
            userPassword = "userPassword",
            nickName = "nickName"
        )
        val post = Post(
            title = request.title,
            author = author,
            content = request.content,
            category = request.category,
            ingredients = request.ingredient,
            tags = request.tags
        )
        postRepository.save(post)
    }

    fun updatePost(postId: Long, request: PostUpdateRequest) {
        val post = findById(postId)
        post.title = request.title
        post.content = request.content
        post.category = request.category
        post.ingredients = request.ingredient
        post.tags = request.tags
        postRepository.save(post)
    }

    fun delete(postId: Long) {
        val post = findById(postId)
        post.isDeleted = true
        post.deletedAt = LocalDateTime.now()
        postRepository.save(post)
    }
}