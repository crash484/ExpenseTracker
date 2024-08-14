package com.shashwat.ExpenseTracker.dto;

import com.shashwat.ExpenseTracker.entities.Expense;
import com.shashwat.ExpenseTracker.entities.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    private List<Expense> expenseList;

    private List<Income> incomeList;
}
