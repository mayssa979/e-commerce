package org.example;

public class ReportObject {
    private String status;
    private String errorMessage;

    public ReportObject(String status, String errorMessage, String methodName) {
        this.status = status;
        this.errorMessage = errorMessage;
        this.methodName = methodName;
    }
    public ReportObject() {
        this.status = status;
        this.errorMessage = errorMessage;
        this.methodName = methodName;
    }

    public String getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    private String methodName;
    public ReportObject(int status,String errorMessage,String methodName){
        this.status=(status==500?"ko":"ok");
        this.errorMessage=errorMessage;
        this.methodName=methodName;
    }

}
