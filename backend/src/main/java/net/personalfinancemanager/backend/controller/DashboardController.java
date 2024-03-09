package net.personalfinancemanager.backend.controller;

import lombok.AllArgsConstructor;
import net.personalfinancemanager.backend.dao.DashboardDAO;
import net.personalfinancemanager.backend.model.TransactionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private DashboardDAO dashboardDAO;

    @GetMapping
    public ResponseEntity<BigDecimal> getAllIncome() {
        List<TransactionModel> allIncome = dashboardDAO.getAllIncome();
        BigDecimal totalIncome = BigDecimal.ZERO;
        for (TransactionModel transaction : allIncome) {
            totalIncome = totalIncome.add(transaction.getAmount());
        }

        return ResponseEntity.ok(totalIncome);
    }
}
