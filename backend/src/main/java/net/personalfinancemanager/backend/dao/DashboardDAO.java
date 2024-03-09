package net.personalfinancemanager.backend.dao;

import net.personalfinancemanager.backend.model.TransactionModel;

import java.math.BigDecimal;
import java.util.List;

public interface DashboardDAO {

    List<TransactionModel> getAllIncome();

    List<TransactionModel> getAllSpending();

    List<TransactionModel> getAllSaving();

    List<TransactionModel> getAllInvestment();

    List<TransactionModel> getCurrentMonthIncome();

    List<TransactionModel> getLastMonthIncome();

    List<TransactionModel> getCurrentYearIncome();


}
