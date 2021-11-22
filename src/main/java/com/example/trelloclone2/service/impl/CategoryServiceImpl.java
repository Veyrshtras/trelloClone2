package com.example.trelloclone2.service.impl;

import com.example.trelloclone2.entity.Category;
import com.example.trelloclone2.model.CategoryItem;
import com.example.trelloclone2.repositorty.CategoryRepository;
import com.example.trelloclone2.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryItem> list() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryItem::fromCategory)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryItem get(Long id) {
        return CategoryItem.fromCategory(categoryRepository.getById(id));
    }

    @Override
    public CategoryItem add(CategoryItem categoryItem) {
        Category category=new Category();
        category.setName(categoryItem.getName());
        categoryRepository.save(category);
        return categoryItem;
    }

    @Override
    public CategoryItem update(Long id, CategoryItem categoryItem) {
        Category category=categoryRepository.getById(id);
        category.setName(categoryItem.getName());
        categoryRepository.save(category);
        return categoryItem;
    }

    @Override
    public boolean delete(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }
}
