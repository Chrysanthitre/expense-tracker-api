package com.chrysanthi.expense_tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrysanthi.expense_tracker.model.ExpenseEntity;
import com.chrysanthi.expense_tracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<ExpenseEntity> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<ExpenseEntity> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public ExpenseEntity createExpense(ExpenseEntity expense) {
        return expenseRepository.save(expense);
    }

    public ExpenseEntity updateExpense(Long id, ExpenseEntity expense) {
        expense.setId(id);
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public List<Object[]> getTotalByCategory() {
        return expenseRepository.getTotalByCategory();
    }

    public List<Object[]> getTotalByMonth() {
        return expenseRepository.getTotalByMonth();
    }

}
