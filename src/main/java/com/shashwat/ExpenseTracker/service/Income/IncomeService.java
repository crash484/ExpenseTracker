package com.shashwat.ExpenseTracker.service.Income;

import com.shashwat.ExpenseTracker.dto.IncomeDTO;
import com.shashwat.ExpenseTracker.entities.Income;

import java.util.List;

public interface IncomeService {

    Income postIncome(IncomeDTO incomeDTO);

    List<Income> getAllIncome();

    Income updateIncome(Long id, IncomeDTO incomeDTO);

    Income getIncomeById(Long id);

    String deleteIncomeById(Long id);
}
