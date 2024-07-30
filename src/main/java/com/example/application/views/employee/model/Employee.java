package com.example.application.views.employee.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Please provide a valid Turkish Identification Number, this field should not be null.")
    @NotBlank(message = "Please provide a valid Turkish Identification Number, this field should not be blank.")
    @Pattern(regexp = "[1-9][0-9]{10}", message = "Please provide a valid 11 digit for Turkish Identification Number.")
    private String turkishIdentificationNumber;
    @NotNull(message = "Please provide a valid name, this field should not be null.")
    @NotBlank(message = "Please provide a valid name, this field should not be blank.")
    @Size(min = 1, message = "The name is too short.")
    @Size(max = 200, message = "The name is too long.")
    private String name;
    @NotNull(message = "Please provide a valid surname, this field should not be null.")
    @NotBlank(message = "Please provide a valid surname, this field should not be blank.")
    @Size(min = 1, message = "The surname is too short.")
    @Size(max = 200, message = "The surname is too long.")
    private String surname;

    public Employee() {
        this.turkishIdentificationNumber = "";
        this.name = "";
        this.surname = "";
    }

    public Employee(Long id, String turkishIdentificationNumber, String name, String surname) {
        this.id = id;
        this.turkishIdentificationNumber = turkishIdentificationNumber;
        this.name = name;
        this.surname = surname;
    }

    public void setTurkishIdentificationNumber(String turkishIdentificationNumber) {
        this.turkishIdentificationNumber = turkishIdentificationNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTurkishIdentificationNumber() {
        return this.turkishIdentificationNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Employee otherEmployee = (Employee) other;
        return Objects.equals(this.turkishIdentificationNumber, otherEmployee.turkishIdentificationNumber) &&
                Objects.equals(this.name, otherEmployee.name) &&
                Objects.equals(this.surname, otherEmployee.surname);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(turkishIdentificationNumber, name, surname);
    }
}
