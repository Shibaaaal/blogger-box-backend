package com.dauphine.blogger.repositories;

import com.dauphine.blogger.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByCategoryId(UUID categoryId);
}
