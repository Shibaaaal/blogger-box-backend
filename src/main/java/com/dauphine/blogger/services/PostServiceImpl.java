package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final CategoryService categoryService;

    public PostServiceImpl(PostRepository repository, CategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    @Override
    public Post createPost(String title, String content, String author, UUID categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        Post post = new Post(UUID.randomUUID(), title, content, author, category);
        return repository.save(post);
    }

    @Override
    public Post getPostById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deletePost(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Post updatePost(UUID id, String title, String content, String author, UUID categoryId) {
        Post post = getPostById(id);
        if (post == null) {
            return null;
        }
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);
        Category category = categoryService.getCategoryById(categoryId);
        post.setCategory(category);
        return repository.save(post);
    }

    @Override
    public void deleteAllPosts() {
        repository.deleteAll();
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        return repository.findAllByCategoryId(categoryId);
    }
}
