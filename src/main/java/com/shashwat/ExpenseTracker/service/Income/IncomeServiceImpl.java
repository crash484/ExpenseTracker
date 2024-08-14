package com.shashwat.ExpenseTracker.service.Income;

import com.shashwat.ExpenseTracker.dto.IncomeDTO;
import com.shashwat.ExpenseTracker.entities.Income;
import com.shashwat.ExpenseTracker.repo.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    public Income postIncome(IncomeDTO incomeDTO){
        return saveOrUpdateIncome(new Income(), incomeDTO);
    }

    private Income saveOrUpdateIncome(Income income,IncomeDTO incomeDTO){
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());
        income.setAmount(incomeDTO.getAmount());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription());

        return incomeRepository.save(income);
    }

    public List<Income> getAllIncome(){
        return incomeRepository.findAll().stream().sorted(
                Comparator.comparing(Income::getDate).reversed())
                .collect(Collectors.toList());
    }

    public Income updateIncome(Long id,IncomeDTO incomeDTO){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()){
            return saveOrUpdateIncome(optionalIncome.get(),incomeDTO);
        }else{
            throw new EntityNotFoundException("income with id "+id +" isnt present");
        }
    }

    public Income getIncomeById(Long id){
        return incomeRepository.findById(id).get();
    }

    public String deleteIncomeById(Long id){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()){
            incomeRepository.delete(optionalIncome.get());
            return "income with id is deleted";
        }else {
            throw new EntityNotFoundException("income with id doesnt exist"+id);
        }
    }

}
