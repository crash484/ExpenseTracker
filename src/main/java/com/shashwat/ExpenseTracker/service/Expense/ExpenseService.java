package com.shashwat.ExpenseTracker.service.Expense;

import com.shashwat.ExpenseTracker.dto.ExpenseDTO;
import com.shashwat.ExpenseTracker.entities.Expense;

import java.util.List;

public interface ExpenseService {

    //method to update after performing an expense hence why post*
    Expense postExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id,ExpenseDTO expenseDTO);

    String deleteExpense(Long id);

}
