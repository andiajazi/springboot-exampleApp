package com.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CustomerDto {
//        @NotBlank(message = "First name cannot be blank!")
        @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$")
        private String firstName;
//        @NotBlank(message = "Last name cannot be blank!")
        @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$")
        private String lastName;
//        @NotNull
        @Min(value = 18, message = "The customer must be at least 18 years old!")
        private Integer age;
        private ContactDto contact;

        public CustomerDto(String firstName, String lastName, Integer age, ContactDto contact) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.age = age;
                this.contact = contact;
        }

        public @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$") String getFirstName() {
                return firstName;
        }

        public void setFirstName(@Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$") String firstName) {
                this.firstName = firstName;
        }

        public @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$") String getLastName() {
                return lastName;
        }

        public void setLastName(@Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$") String lastName) {
                this.lastName = lastName;
        }

        public @Min(value = 18, message = "The customer must be at least 18 years old!") Integer getAge() {
                return age;
        }

        public void setAge(@Min(value = 18, message = "The customer must be at least 18 years old!") Integer age) {
                this.age = age;
        }

        public ContactDto getContact() {
                return contact;
        }

        public void setContact(ContactDto contact) {
                this.contact = contact;
        }
}