package edu.javacourse.studentorder.exception;

public class CityRegisterException extends Exception {
    private String code;

    public CityRegisterException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CityRegisterException(String code, String message, Throwable cause) {
        super(message, cause);
    }

    public CityRegisterException(String message) {
        super(message);
    }

    public String getCode() {
        return code;
    }
}
