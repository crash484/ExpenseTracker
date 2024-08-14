package com.shashwat.ExpenseTracker.service.Stats;

import com.shashwat.ExpenseTracker.dto.GraphDTO;
import com.shashwat.ExpenseTracker.dto.StatsDto;
import com.shashwat.ExpenseTracker.entities.Expense;
import com.shashwat.ExpenseTracker.entities.Income;
import com.shashwat.ExpenseTracker.repo.ExpenseRepository;
import com.shashwat.ExpenseTracker.repo.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final IncomeRepository incomeRepository;

    private final ExpenseRepository expenseRepository;

    public GraphDTO getChartData(){
        LocalDate endDate=LocalDate.now();
        LocalDate startDate= endDate.minusDays(27);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate,endDate));
        graphDTO.setExpenseList(expenseRepository.findByDateBetween(startDate,endDate));


        return graphDTO;
    }

    public StatsDto getStats(){
        Double totalIncome= incomeRepository.sumAllAmounts();
        Double totalExpense= expenseRepository.sumAllAmounts();

        Optional<Income> optionalIncome=incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense> optionalExpense=expenseRepository.findFirstByOrderByDateDesc();



        StatsDto statsDto = new StatsDto();
        statsDto.setExpense(totalExpense);
        statsDto.setIncome(totalIncome);

        if(optionalIncome.isPresent()) statsDto.setLatestIncome(optionalIncome.get());

        if(optionalExpense.isPresent()) statsDto.setLatestExpense(optionalExpense.get());
        return statsDto;
    }
}
