package com.pm.zorvynfinancedashboardbackend.controller;



import com.pm.zorvynfinancedashboardbackend.dto.DashboardResponse;
import com.pm.zorvynfinancedashboardbackend.entity.FinancialRecord;
import com.pm.zorvynfinancedashboardbackend.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.pm.zorvynfinancedashboardbackend.dto.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")

    @GetMapping("/summary")
    public ApiResponse<DashboardResponse> getSummary() {
        return new ApiResponse<>("success", dashboardService.getSummary());
    }
    @GetMapping("/recent")
    public ApiResponse<List<FinancialRecord>> getRecent() {
        return new ApiResponse<>("success", dashboardService.getRecentTransactions());
    }

}

