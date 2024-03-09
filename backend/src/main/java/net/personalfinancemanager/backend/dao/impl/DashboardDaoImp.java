package net.personalfinancemanager.backend.dao.impl;

import net.personalfinancemanager.backend.dao.DashboardDAO;
import net.personalfinancemanager.backend.model.CategoryModel;
import net.personalfinancemanager.backend.model.TransactionModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Component
public class DashboardDaoImp implements DashboardDAO {

    private static final Logger log = LoggerFactory.getLogger(DashboardDaoImp.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<TransactionModel> rowMapperTransaction = (rs, rowNum) -> {
        TransactionModel transaction = new TransactionModel();
        //transaction.setTransaction_id(rs.getInt("transaction_id"));
        transaction.setAmount(rs.getBigDecimal("amount"));
        //transaction.setCategory_id(rs.getInt("category_id"));
        //transaction.setDate(rs.getDate("date"));
        return transaction;
    };

    RowMapper<CategoryModel> rowMapperCategory = (rs, rowNum) -> {
        CategoryModel category = new CategoryModel();
        category.setCategory_id(rs.getInt("category_id"));
        category.setName(rs.getString("name"));
        category.setType(rs.getString("type"));
        return category;
    };

    @Override
    public List<TransactionModel> getAllIncome() {
        String sql = "SELECT transaction.amount from transaction,category WHERE transaction.category_id=category.category_id AND category.type='INCOME' ";
        return jdbcTemplate.query(sql, rowMapperTransaction);
    }

    @Override
    public List<BigDecimal> getAllSpending() {
        return null;
    }

    @Override
    public List<BigDecimal> getAllSaving() {
        return null;
    }

    @Override
    public List<BigDecimal> getAllInvestment() {
        return null;
    }
}
