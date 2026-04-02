package com.pm.zorvynfinancedashboardbackend.controller;



import com.pm.zorvynfinancedashboardbackend.dto.ApiResponse;
import com.pm.zorvynfinancedashboardbackend.entity.User;
import com.pm.zorvynfinancedashboardbackend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<User> createUser(@Valid @RequestBody User user) {
        return new ApiResponse<>("success", userService.createUser(user));
    }

    @GetMapping
    public ApiResponse<List<User>> getAllUsers() {
        return new ApiResponse<>("success", userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ApiResponse<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return new ApiResponse<>("success", userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ApiResponse<>("success", "User deleted successfully");
    }

}
