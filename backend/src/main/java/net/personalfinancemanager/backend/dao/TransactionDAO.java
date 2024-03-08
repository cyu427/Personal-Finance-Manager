package net.personalfinancemanager.backend.dao;

import net.personalfinancemanager.backend.model.TransactionModel;

import java.util.List;

public interface TransactionDAO {
    List<TransactionModel> getAllTransaction();

    TransactionModel createTransaction(TransactionModel transactionModel);

    TransactionModel updateTransaction(int transaction_id, TransactionModel updatedTransaction);

    void deleteTransaction(int transaction_id);
}
