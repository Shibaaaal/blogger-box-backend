package com.dauphine.blocker;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> getAllCategories();
    Category getCategoryById(UUID id);
    Category createCategory(String name);
    Category updateCategory(UUID id, String name);
    void deleteCategory(UUID id);
}
