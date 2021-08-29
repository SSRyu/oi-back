package oioi.back.oiback.controller

import oioi.back.oiback.post.dto.request.PostCreateRequest
import oioi.back.oiback.post.dto.request.PostUpdateRequest
import oioi.back.oiback.post.entities.Post
import oioi.back.oiback.post.services.PostService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController (
    val postService: PostService
) {

    @GetMapping
    fun getPostList(): MutableIterable<Post> {
        return postService.findAll()
    }

    @GetMapping("/{postId}")
    fun getPost(@PathVariable("postId") postId: Long): Post {
        return postService.findById(postId)
    }

    @PostMapping
    fun createPost(@RequestBody request: PostCreateRequest) {
        postService.createPost(request)
    }

    @PutMapping("/{postId}")
    fun updatePost(@PathVariable("postId") postId: Long, @RequestBody request: PostUpdateRequest) {
        postService.updatePost(postId, request)
    }

    @DeleteMapping("/{postId}")
    fun deletePost(@PathVariable("postId") postId: Long) {
        postService.delete(postId)
    }

}