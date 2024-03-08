package net.personalfinancemanager.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionModel {
    private int transaction_id;
    private BigDecimal amount;
    private int category_id;
    private Date date;
}
