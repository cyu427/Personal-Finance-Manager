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

    @GetMapping("getAllIncome")
    public ResponseEntity<BigDecimal> getAllIncome() {
        List<TransactionModel> allIncome = dashboardDAO.getAllIncome();
        BigDecimal totalIncome = BigDecimal.ZERO;
        for (TransactionModel transaction : allIncome) {
            totalIncome = totalIncome.add(transaction.getAmount());
        }

        return ResponseEntity.ok(totalIncome);
    }

    @GetMapping("getAllSpending")
    public ResponseEntity<BigDecimal> getAllSpending() {
        List<TransactionModel> allSpending = dashboardDAO.getAllSpending();
        BigDecimal totalSpending = BigDecimal.ZERO;
        for (TransactionModel transaction : allSpending) {
            totalSpending = totalSpending.add(transaction.getAmount());
        }

        return ResponseEntity.ok(totalSpending);
    }

    @GetMapping("getAllSaving")
    public ResponseEntity<BigDecimal> getAllSaving() {
        List<TransactionModel> allSaving = dashboardDAO.getAllSaving();
        BigDecimal totalSaving = BigDecimal.ZERO;
        for (TransactionModel transaction : allSaving) {
            totalSaving = totalSaving.add(transaction.getAmount());
        }

        return ResponseEntity.ok(totalSaving);
    }

    @GetMapping("getAllInvestment")
    public ResponseEntity<BigDecimal> getAllInvestment() {
        List<TransactionModel> allInvestment = dashboardDAO.getAllInvestment();
        BigDecimal totalInvestment = BigDecimal.ZERO;
        for (TransactionModel transaction : allInvestment) {
            totalInvestment = totalInvestment.add(transaction.getAmount());
        }

        return ResponseEntity.ok(totalInvestment);
    }

    @GetMapping("getNetWorth")
    public ResponseEntity<BigDecimal> getNetWorth() {
        List<TransactionModel> allIncome = dashboardDAO.getAllIncome();
        List<TransactionModel> allSpending = dashboardDAO.getAllSpending();
        List<TransactionModel> allSaving = dashboardDAO.getAllSaving();
        List<TransactionModel> allInvestment = dashboardDAO.getAllInvestment();

        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalSpending = BigDecimal.ZERO;
        BigDecimal totalSaving = BigDecimal.ZERO;
        BigDecimal totalInvestment = BigDecimal.ZERO;
        BigDecimal netWorth;

        for (TransactionModel transaction : allIncome) {
            totalIncome = totalIncome.add(transaction.getAmount());
        }

        for (TransactionModel transaction : allSpending) {
            totalSpending = totalSpending.add(transaction.getAmount());
        }

        for (TransactionModel transaction : allSaving) {
            totalSaving = totalSaving.add(transaction.getAmount());
        }

        for (TransactionModel transaction : allInvestment) {
            totalInvestment = totalInvestment.add(transaction.getAmount());
        }

        netWorth = totalIncome.add(totalInvestment).add(totalSaving).subtract(totalSpending);


        return ResponseEntity.ok(netWorth);
    }

    @GetMapping("getTotalCash")
    public ResponseEntity<BigDecimal> getTotalCash() {
        List<TransactionModel> allIncome = dashboardDAO.getAllIncome();
        List<TransactionModel> allSpending = dashboardDAO.getAllSpending();
        List<TransactionModel> allSaving = dashboardDAO.getAllSaving();
        List<TransactionModel> allInvestment = dashboardDAO.getAllInvestment();

        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalSpending = BigDecimal.ZERO;
        BigDecimal totalSaving = BigDecimal.ZERO;
        BigDecimal totalInvestment = BigDecimal.ZERO;
        BigDecimal netWorth;

        for (TransactionModel transaction : allIncome) {
            totalIncome = totalIncome.add(transaction.getAmount());
        }

        for (TransactionModel transaction : allSpending) {
            totalSpending = totalSpending.add(transaction.getAmount());
        }

        for (TransactionModel transaction : allSaving) {
            totalSaving = totalSaving.add(transaction.getAmount());
        }

        for (TransactionModel transaction : allInvestment) {
            totalInvestment = totalInvestment.add(transaction.getAmount());
        }

        netWorth = totalIncome.subtract(totalInvestment).subtract(totalSaving).subtract(totalSpending);

        return ResponseEntity.ok(netWorth);
    }
}
