package com.example.es.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    private final String INCORRECT_REQUEST = "INCORRECT_REQUEST";

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<AppErrorResponse> handleRecordNotFoundException
            (RecordNotFoundException ex, WebRequest request) {

        Map<String, Object> moreDetails = new HashMap<>();
        moreDetails.put("path", request.getDescription(false));

        AppErrorResponse errorResponse = constructErrorResponse(HttpStatus.NOT_FOUND
                , ex, moreDetails);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    private AppErrorResponse constructErrorResponse(HttpStatus httpStatus
            , Exception exception
            , Map<String, Object> errorDetails) {
        return new AppErrorResponse(httpStatus, exception, errorDetails);
    }
}
