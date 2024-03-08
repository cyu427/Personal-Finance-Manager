package net.personalfinancemanager.backend.controller;

import lombok.AllArgsConstructor;
import net.personalfinancemanager.backend.dao.TransactionDAO;
import net.personalfinancemanager.backend.model.CategoryModel;
import net.personalfinancemanager.backend.model.TransactionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
