package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ContactDto(
//                         @NotBlank(message = "e-mail cannot be blank!")
                         @Pattern(regexp = "^[a-z0-9._+:-]+@[A-Za-z.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email format!")
                         String email,
//                         @NotBlank(message = "Phone number is required!")
                         @Pattern(regexp = "^\\+3556[98]\\d{7}$", message = "Incorrect phone number format!")
                         String phone,
//                         @NotBlank(message = "City is required!")
                         @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Please type in a valid city name!")
                         String city,
//                         @NotBlank(message = "Address is required!")
                         String address) {
}
