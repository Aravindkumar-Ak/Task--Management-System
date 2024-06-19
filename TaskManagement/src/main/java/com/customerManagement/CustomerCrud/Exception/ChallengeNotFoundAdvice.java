package com.customerManagement.CustomerCrud.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class ChallengeNotFoundAdvice {
@ResponseBody
@ExceptionHandler(ChallengeNotFound.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exception(ChallengeNotFound e){

        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("Error Message",e.getMessage());
        return errorMap;
    }
}
