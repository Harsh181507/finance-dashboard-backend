package com.pm.zorvynfinancedashboardbackend.controller;



import com.pm.zorvynfinancedashboardbackend.dto.ApiResponse;
import com.pm.zorvynfinancedashboardbackend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public ApiResponse<String> login(@RequestParam String email,
                                     @RequestParam String password) {
        return new ApiResponse<>("success", authService.login(email, password));
    }
}


