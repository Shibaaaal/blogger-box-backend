package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    Post createPost(String title, String content, String author, UUID categoryId);
    Post getPostById(UUID id);
    void deletePost(UUID id);
    Post updatePost(UUID id, String title, String content, String author, UUID categoryId);
    void deleteAllPosts();
    List<Post> getAll();
    List<Post> getAllByCategoryId(UUID categoryId);
}
