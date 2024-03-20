package com.coffee.shop.dto;

public class ApiResponse<T> {
    private int resultCode;
    private String status;
    private T data;

    public ApiResponse(int resultCode, String status, T data) {
        this.resultCode = resultCode;
        this.status = status;
        this.data = data;
    }

    // Getters and setters
    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}