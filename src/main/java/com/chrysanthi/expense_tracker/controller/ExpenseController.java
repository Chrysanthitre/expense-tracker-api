package com.chrysanthi.expense_tracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrysanthi.expense_tracker.model.ExpenseEntity;
import com.chrysanthi.expense_tracker.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    
    @GetMapping
    public List<ExpenseEntity> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Optional<ExpenseEntity> getById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }
    
    @PostMapping
    public ExpenseEntity createExpense(@RequestBody ExpenseEntity expense) {
        return expenseService.createExpense(expense);
    }

    @PutMapping("/{id}")
    public ExpenseEntity updateExpense(@PathVariable Long id, @RequestBody ExpenseEntity expense) {
        return expenseService.updateExpense(id,expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

}




