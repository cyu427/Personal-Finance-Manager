package net.personalfinancemanager.backend.controller;

import lombok.AllArgsConstructor;
import net.personalfinancemanager.backend.dao.TransactionDAO;
import net.personalfinancemanager.backend.model.CategoryModel;
import net.personalfinancemanager.backend.model.TransactionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private TransactionDAO transactionDAO;

    @GetMapping
    public ResponseEntity<List<TransactionModel>> getAllTransaction() {
        List<TransactionModel> transaction = transactionDAO.getAllTransaction();

        return ResponseEntity.ok(transaction);
    }

    @PostMapping
    public ResponseEntity<TransactionModel> createTransaction(@RequestBody TransactionModel transactionModel) {
        TransactionModel savedTransaction = transactionDAO.createTransaction(transactionModel);

        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<TransactionModel> updateCategory(@PathVariable("id") int transaction_id,
                                                        @RequestBody TransactionModel updatedTransaction) {
        TransactionModel transaction = transactionDAO.updateTransaction(transaction_id, updatedTransaction);

        return ResponseEntity.ok(transaction);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int transaction_id) {
        transactionDAO.deleteTransaction(transaction_id);

        return ResponseEntity.ok("Category deleted successfully");
    }
}
