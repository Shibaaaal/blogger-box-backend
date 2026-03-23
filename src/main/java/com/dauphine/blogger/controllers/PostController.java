package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.PostRequest;
import com.dauphine.blogger.exceptions.NotFoundException;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) UUID categoryId) {
        if (categoryId != null) {
            return ResponseEntity.ok(postService.getAllByCategoryId(categoryId));
        }
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable UUID id) throws NotFoundException {
        Post post = postService.getPostById(id);
        if (post == null) {
            throw new NotFoundException("Post with ID " + id + " not found.");
        }
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest) {
        Post post = postService.createPost(
                postRequest.getTitle(),
                postRequest.getContent(),
                postRequest.getAuthor(),
                postRequest.getCategoryId()
        );
        return ResponseEntity.created(URI.create("/v1/posts/" + post.getId())).body(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable UUID id, @RequestBody PostRequest postRequest) throws NotFoundException {
        Post post = postService.updatePost(
                id,
                postRequest.getTitle(),
                postRequest.getContent(),
                postRequest.getAuthor(),
                postRequest.getCategoryId()
        );
        if (post == null) {
            throw new NotFoundException("Post with ID " + id + " not found.");
        }
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllPosts() {
        postService.deleteAllPosts();
        return ResponseEntity.noContent().build();
    }
}
