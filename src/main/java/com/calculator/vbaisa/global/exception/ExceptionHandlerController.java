package com.calculator.vbaisa.global.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerController {

    @Autowired
    private com.calculator.vbaisa.common.Error.Builder error;

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<String> handleAllUncaughtException(
            Throwable exception,
            WebRequest request) {
        HttpServletRequest servletRequest = ((ServletWebRequest) request).getRequest();

        error.setErrorCode("BAD_REQUEST")
                .setMessage(exception.getMessage())
                .setPath(servletRequest.getRequestURI())
                .setTimeStamp(LocalDateTime.now())
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        return ResponseEntity.accepted().body(error.build().toString());
    }
}

