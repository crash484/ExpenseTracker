package com.shashwat.ExpenseTracker.dto;

import com.shashwat.ExpenseTracker.entities.Expense;
import com.shashwat.ExpenseTracker.entities.Income;
import lombok.Data;

@Data
public class StatsDto {

    private Double income;

    private Double expense;

    private Income latestIncome;

    private Expense latestExpense;
}
