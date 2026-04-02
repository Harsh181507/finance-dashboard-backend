package com.pm.zorvynfinancedashboardbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResponse {
    private Double totalIncome;
    private Double totalExpense;
    private Double netBalance;
}