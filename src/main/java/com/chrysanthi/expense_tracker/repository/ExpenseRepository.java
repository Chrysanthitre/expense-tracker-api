package com.chrysanthi.expense_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chrysanthi.expense_tracker.model.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

    @Query("SELECT e.category, SUM(e.amount) FROM ExpenseEntity e GROUP BY e.category")
    List<Object[]> getTotalByCategory();

    @Query("SELECT MONTH(e.date), SUM(e.amount) FROM ExpenseEntity e GROUP BY MONTH(e.date)")
    List<Object[]> getTotalByMonth();
    
}
