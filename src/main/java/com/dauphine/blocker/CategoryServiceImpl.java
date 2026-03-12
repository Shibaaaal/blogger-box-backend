package com.dauphine.blocker;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class CategoryServiceImpl implements CategoryService{

    private final List<Category> temporaryCategories;


    public CategoryServiceImpl() {
        temporaryCategories = new ArrayList<>();
        temporaryCategories.add(new Category(UUID.randomUUID(),"Sport"));
        temporaryCategories.add(new Category(UUID.randomUUID(),"Culture"));
        temporaryCategories.add(new Category(UUID.randomUUID(),"Politique"));
    }

    @Override
    public List<Category> getAllCategories() {
        return temporaryCategories;
    }

    @Override
    public Category getCategoryById(UUID id) {
        return temporaryCategories.stream().filter(category -> category.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Category createCategory(String name) {
        return new Category(UUID.randomUUID(),name);
    }

    @Override
    public Category updateCategory(UUID id, String name) {
        Category category = temporaryCategories.stream().filter(category1 -> category1.getId().equals(id)).findFirst().orElse(null);
        if( category != null)
            category.setName(name);
        return category;
    }

    @Override
    public void deleteCategory(UUID id) {
        temporaryCategories.removeIf(category -> category.getId().equals(id));
    }
}
