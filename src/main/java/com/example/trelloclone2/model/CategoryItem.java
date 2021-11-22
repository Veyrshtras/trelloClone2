package com.example.trelloclone2.model;

import com.example.trelloclone2.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryItem {
    private String name;

    public static CategoryItem fromCategory(Category category){
        CategoryItem categoryItem=new CategoryItem();
        categoryItem.setName(category.getName());
        return categoryItem;
    }
}
