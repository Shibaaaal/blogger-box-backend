package com.dauphine.blocker;

import java.util.List;
import java.util.UUID;

public interface PostService {

    public Post createPost(UUID id, String name, String description);
    public Post getPostById(UUID id);
    public void deletePost(UUID id);
    public Post updatePost(UUID id, String name);
    public void deleteAllPosts();
    public List<Post> GetAll();
    public List<Post> GetAllbyCategory(UUID CategoryID);


}
