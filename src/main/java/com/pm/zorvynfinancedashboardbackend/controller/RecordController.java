package com.pm.zorvynfinancedashboardbackend.controller;



import com.pm.zorvynfinancedashboardbackend.dto.ApiResponse;
import com.pm.zorvynfinancedashboardbackend.entity.FinancialRecord;
import com.pm.zorvynfinancedashboardbackend.entity.enums.RecordType;
import com.pm.zorvynfinancedashboardbackend.service.RecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<FinancialRecord> create(@Valid @RequestBody FinancialRecord record) {
        return new ApiResponse<>("success", recordService.createRecord(record));
    }

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping
    public ApiResponse<List<FinancialRecord>> getAllRecords(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return new ApiResponse<>("success",
                recordService.getAllRecordsSorted(sortBy, direction));
    }

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping("/paginated")
    public ApiResponse<Page<FinancialRecord>> getPaginatedRecords(Pageable pageable) {
        return new ApiResponse<>("success", recordService.getAllRecordsPaginated(pageable));
    }


    @PutMapping("/{id}")
    public FinancialRecord update(@PathVariable Long id, @RequestBody FinancialRecord record) {
        return recordService.updateRecord(id, record);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return "Record deleted (soft)";
    }


    @GetMapping("/type")
    public List<FinancialRecord> byType(@RequestParam RecordType type) {
        return recordService.filterByType(type);
    }

    @GetMapping("/category")
    public List<FinancialRecord> byCategory(@RequestParam String category) {
        return recordService.filterByCategory(category);
    }

    @GetMapping("/date")
    public List<FinancialRecord> byDate(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end
    ) {
        return recordService.filterByDate(start, end);
    }

    @GetMapping("/my")
    public ApiResponse<List<FinancialRecord>> getMyRecords() {
        return new ApiResponse<>("success", recordService.getMyRecords());
    }

    @GetMapping("/search")
    public ApiResponse<List<FinancialRecord>> search(
            @RequestParam String category
    ) {
        return new ApiResponse<>("success",
                recordService.searchByCategory(category));
    }
}

