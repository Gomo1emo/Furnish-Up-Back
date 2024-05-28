package com.GroupD.FurnishUp.exceptionConfig;

import com.GroupD.FurnishUp.errorData.ErrorData;
import com.GroupD.FurnishUp.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorData> handleException(AppException ex){
        return  ResponseEntity.status(ex.getStatus())
                .body(new ErrorData(ex.getMessage()));

    }

}
