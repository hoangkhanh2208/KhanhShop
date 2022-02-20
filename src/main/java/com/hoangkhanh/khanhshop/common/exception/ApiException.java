package com.hoangkhanh.blogweb.common.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ApiException extends RuntimeException{

    private static final long serialVersionUID = -4642753456084299295L;
    private String exceptionCode;
    private HttpStatus httpStatus;


    public ApiException(Throwable couse, HttpStatus httpStatus){
        super(couse);
        setHttpStatus(httpStatus);
    }

    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        setHttpStatus(httpStatus);
    }

    public ApiException(String message) {
        super(message);
        setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
