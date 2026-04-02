package com.pm.zorvynfinancedashboardbackend.service;



import com.pm.zorvynfinancedashboardbackend.entity.FinancialRecord;
import com.pm.zorvynfinancedashboardbackend.entity.enums.RecordType;
import com.pm.zorvynfinancedashboardbackend.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final FinancialRecordRepository recordRepository;

    public FinancialRecord createRecord(FinancialRecord record) {
        return recordRepository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return recordRepository.findByDeletedFalse();
    }



    public Page<FinancialRecord> getAllRecordsPaginated(Pageable pageable) {
        return recordRepository.findAll(pageable);
    }

    public FinancialRecord updateRecord(Long id, FinancialRecord updated) {
        FinancialRecord record = recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setAmount(updated.getAmount());
        record.setCategory(updated.getCategory());
        record.setType(updated.getType());
        record.setDate(updated.getDate());
        record.setNotes(updated.getNotes());

        return recordRepository.save(record);
    }

    public void deleteRecord(Long id) {
        FinancialRecord record = recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setDeleted(true);
        recordRepository.save(record);
    }

    public List<FinancialRecord> filterByType(RecordType type) {
        return recordRepository.findByType(type);
    }

    public List<FinancialRecord> filterByCategory(String category) {
        return recordRepository.findByCategory(category);
    }

    public List<FinancialRecord> filterByDate(LocalDate start, LocalDate end) {
        return recordRepository.findByDateBetween(start, end);
    }


}


