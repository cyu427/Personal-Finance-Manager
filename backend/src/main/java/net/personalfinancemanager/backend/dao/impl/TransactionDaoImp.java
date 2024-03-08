package net.personalfinancemanager.backend.dao.impl;

import net.personalfinancemanager.backend.dao.TransactionDAO;
import net.personalfinancemanager.backend.model.TransactionModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class TransactionDaoImp implements TransactionDAO {

    private static final Logger log = LoggerFactory.getLogger(TransactionDaoImp.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<TransactionModel> rowMapper = (rs, rowNum) -> {
        TransactionModel transaction = new TransactionModel();
        transaction.setTransaction_id(rs.getInt("transaction_id"));
        transaction.setAmount(rs.getBigDecimal("amount"));
        transaction.setCategory_id(rs.getInt("category_id"));
        transaction.setDate(rs.getDate("date"));
        return transaction;
    };

    public TransactionDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<TransactionModel> getAllTransaction() {
        String sql = "SELECT * from transaction";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public TransactionModel createTransaction(TransactionModel transactionModel) {
        return null;
    }

    @Override
    public TransactionModel updateTransaction(int transaction_id, TransactionModel updatedTransaction) {
        return null;
    }

    @Override
    public void deleteTransaction(int transaction_id) {

    }
}
