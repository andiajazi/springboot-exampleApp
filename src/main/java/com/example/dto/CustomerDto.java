package com.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CustomerDto(
        @NotBlank(message = "First name cannot be blank!")
        @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$")
        String f_name,
        @NotBlank(message = "Last name cannot be blank!")
        @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$")
        String l_name,
        @NotBlank(message = "e-mail cannot be blank!")
        @Pattern(regexp = "^[a-z0-9._+:-]+@[A-Za-z.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email format!")
        String email,
        @NotBlank(message = "Phone number is required!")
        @Pattern(regexp = "^\\+3556[98]\\d{7}$", message = "Incorrect phone number format!")
        String phone,
        @NotNull
        @Min(value = 18, message = "The customer must be at least 18 years old!")
        Integer age) {
}