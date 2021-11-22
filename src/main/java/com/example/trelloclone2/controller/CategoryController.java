package com.example.trelloclone2.controller;

import com.example.trelloclone2.model.CategoryItem;
import com.example.trelloclone2.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("api/s2/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Inject
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public ResponseEntity list(){
        return ResponseEntity.ok(categoryService.list());
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.get(id));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody CategoryItem categoryItem){
        return ResponseEntity.ok(categoryService.add(categoryItem));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody CategoryItem categoryItem){
        return ResponseEntity.ok(categoryService.update(id, categoryItem));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.delete(id));
    }
}
