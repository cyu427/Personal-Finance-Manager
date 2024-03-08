package net.personalfinancemanager.backend.controller;

import lombok.AllArgsConstructor;
import net.personalfinancemanager.backend.dao.CategoryDAO;
import net.personalfinancemanager.backend.model.CategoryModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryDAO categoryDAO;

    @GetMapping
    public ResponseEntity<List<CategoryModel>> getAllEmployees() {
        List<CategoryModel> category = categoryDAO.getAllCategory();

        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel categoryModel) {
        CategoryModel savedCategory = categoryDAO.createCategory(categoryModel);

        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryModel> updateCategory(@PathVariable("id") int category_id,
                                                      @RequestBody CategoryModel updatedCategory) {
        CategoryModel category = categoryDAO.updateCategory(category_id, updatedCategory);

        return ResponseEntity.ok(category);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int category_id) {
        categoryDAO.deleteCategory(category_id);

        return ResponseEntity.ok("Category deleted successfully");
    }

}
