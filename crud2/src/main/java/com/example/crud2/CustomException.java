package com.example.crud2;

public class CustomException extends RuntimeException {
    private final String errorCode;

    public CustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public static CustomException customerNotFound(int id) {
        return new CustomException("Customer not found with id: " + id, "CUSTOMER_NOT_FOUND");
    }

    public static CustomException invalidCustomerName(String name) {
        return new CustomException("Invalid customer name: " + name + ". Name cannot be empty or contain only numbers.", "INVALID_CUSTOMER_NAME");
    }

    // Add more static methods for other edge cases as needed
}