package net.personalfinancemanager.backend.dao.impl;

import lombok.AllArgsConstructor;
import net.personalfinancemanager.backend.dao.CategoryDAO;
import net.personalfinancemanager.backend.model.CategoryModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Component
public class CategoryDaoImp implements CategoryDAO {

    private static final Logger log = LoggerFactory.getLogger(CategoryDaoImp.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<CategoryModel> rowMapper = (rs,rowNum) -> {
        CategoryModel category = new CategoryModel();
        category.setCategory_id(rs.getInt("category_id"));
        category.setName(rs.getString("name"));
        category.setType(rs.getString("type"));
        return category;
    };

    public CategoryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CategoryModel> getAllCategory() {
        String sql = "SELECT * from category";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public CategoryModel createCategory(CategoryModel categoryModel) {
        //String categoryId = UUID.randomUUID().toString();
        String sql = "INSERT into category (name,type) values (?,?)";
        jdbcTemplate.update(sql, categoryModel.getName(), categoryModel.getType());
        return categoryModel;
    }

    @Override
    public CategoryModel updateCategory(int category_id, CategoryModel updatedCategory) {
        String sql = "UPDATE category SET name=?, type=? WHERE category_id=?";
        jdbcTemplate.update(sql, updatedCategory.getName(), updatedCategory.getType(),category_id);
        return updatedCategory;
    }

    @Override
    public void deleteCategory(int category_id) {
        String sql = "DELETE from category WHERE category_id=?";
        jdbcTemplate.update(sql,category_id);
    }
}
