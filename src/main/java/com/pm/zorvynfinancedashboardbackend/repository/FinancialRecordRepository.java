package com.pm.zorvynfinancedashboardbackend.repository;

import com.pm.zorvynfinancedashboardbackend.entity.FinancialRecord;
import com.pm.zorvynfinancedashboardbackend.entity.User;
import com.pm.zorvynfinancedashboardbackend.entity.enums.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

    List<FinancialRecord> findByType(RecordType type);

    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);

    List<FinancialRecord> findByDeletedFalse();

    List<FinancialRecord> findByUser(User user);

    List<FinancialRecord> findByCategoryContainingIgnoreCase(String category);

}

