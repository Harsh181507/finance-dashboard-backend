package com.pm.zorvynfinancedashboardbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResponse {
    private double totalIncome;
    private double totalExpense;
    private double netBalance;
}


