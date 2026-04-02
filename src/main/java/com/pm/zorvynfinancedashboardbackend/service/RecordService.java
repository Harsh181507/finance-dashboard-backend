package com.pm.zorvynfinancedashboardbackend.service;



import com.pm.zorvynfinancedashboardbackend.entity.FinancialRecord;
import com.pm.zorvynfinancedashboardbackend.entity.User;
import com.pm.zorvynfinancedashboardbackend.entity.enums.RecordType;
import com.pm.zorvynfinancedashboardbackend.repository.FinancialRecordRepository;
import com.pm.zorvynfinancedashboardbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final FinancialRecordRepository recordRepository;
    private final UserRepository userRepository;

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

    public List<FinancialRecord> getAllRecordsSorted(String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return recordRepository.findAll(sort);
    }

    public List<FinancialRecord> getMyRecords() {

        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return recordRepository.findByUser(user);
    }

    public List<FinancialRecord> searchByCategory(String category) {
        return recordRepository.findByCategoryContainingIgnoreCase(category);
    }

}


