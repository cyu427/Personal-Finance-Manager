package net.personalfinancemanager.backend.dao;

import net.personalfinancemanager.backend.model.TransactionModel;

import java.math.BigDecimal;
import java.util.List;

public interface DashboardDAO {

    List<TransactionModel> getAllIncome();

    List<BigDecimal> getAllSpending();

    List<BigDecimal> getAllSaving();

    List<BigDecimal> getAllInvestment();
}
