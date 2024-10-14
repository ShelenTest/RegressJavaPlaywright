package org.utils.objectsSerialization;

public class BodyResponse {
    private boolean success;
    private String errorMessage;
    private String errorCode;
    private Object data;

    public BodyResponse(boolean success, String errorMessage, String errorCode, Object data) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.data = data;
    }
    // Геттеры и сеттеры
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
