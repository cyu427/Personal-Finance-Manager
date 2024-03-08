package net.personalfinancemanager.backend.dao;

import net.personalfinancemanager.backend.model.CategoryModel;

import java.util.List;
public interface CategoryDAO {

    List<CategoryModel> getAllCategory();

    CategoryModel createCategory(CategoryModel categoryModel);

    CategoryModel updateCategory(int category_id, CategoryModel updatedCategory);

    void deleteCategory(int category_id);

}
