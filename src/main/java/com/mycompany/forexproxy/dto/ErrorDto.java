
package com.mycompany.forexproxy.dto;

/**
 *
 * @author daniel.forziat
 */
public class ErrorDto {
    
    /**
     * Error Code
     */
    private String errorCode;
    
    /**
     * Error Message
     */
    private String errorMessage;
    
    /**
     * Default Constructor
     */
    public ErrorDto(){
    }
    
    /*
     * Constructor
     * @param errorCode
     * @param errorMessage 
     */
    public ErrorDto(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ErrorDto{" + "errorCode=" + errorCode + ", errorMessage=" + errorMessage + '}';
    }
    
    
}
