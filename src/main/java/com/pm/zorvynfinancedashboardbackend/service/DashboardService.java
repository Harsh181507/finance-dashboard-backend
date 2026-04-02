package com.pm.zorvynfinancedashboardbackend.service;



import com.pm.zorvynfinancedashboardbackend.dto.DashboardResponse;
import com.pm.zorvynfinancedashboardbackend.entity.FinancialRecord;
import com.pm.zorvynfinancedashboardbackend.entity.enums.RecordType;
import com.pm.zorvynfinancedashboardbackend.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final FinancialRecordRepository recordRepository;

    public double getTotalIncome() {
        return recordRepository.findByType(RecordType.INCOME)
                .stream()
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double getTotalExpense() {
        return recordRepository.findByType(RecordType.EXPENSE)
                .stream()
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double getNetBalance() {
        return getTotalIncome() - getTotalExpense();
    }

    public List<FinancialRecord> getRecentTransactions() {
        return recordRepository.findAll()
                .stream()
                .filter(r -> !r.isDeleted())
                .sorted((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()))
                .limit(5)
                .toList();
    }
    public DashboardResponse getSummary() {
        double income = getTotalIncome();
        double expense = getTotalExpense();

        return new DashboardResponse(
                income,
                expense,
                income - expense
        );
    }
}

