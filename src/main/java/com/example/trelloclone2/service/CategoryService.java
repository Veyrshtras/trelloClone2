package com.example.trelloclone2.service;

import com.example.trelloclone2.entity.Category;
import com.example.trelloclone2.model.CategoryItem;

import java.util.List;

public interface CategoryService {

    List<CategoryItem> list();

    CategoryItem get(Long id);

    CategoryItem add(CategoryItem categoryItem);

    CategoryItem update(Long id, CategoryItem categoryItem);

    boolean delete(Long id);
}
