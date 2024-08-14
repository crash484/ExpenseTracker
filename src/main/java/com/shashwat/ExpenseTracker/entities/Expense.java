package com.shashwat.ExpenseTracker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data//no need to create getters and setters itself does it
public class Expense {

    @Id//sets it as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
    private Long id;

    private String title;

    private String description;

    private String category;

    private LocalDate date;

    private Integer amount;

}
