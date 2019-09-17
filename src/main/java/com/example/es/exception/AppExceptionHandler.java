package com.example.es.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    private final String INCORRECT_REQUEST = "INCORRECT_REQUEST";

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleRecordNotFoundException
            (RecordNotFoundException ex, WebRequest request) {

        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        details.add(getPrintStackTrace(ex));
        ErrorDetails errorDetails = new ErrorDetails(INCORRECT_REQUEST, details);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    private String getPrintStackTrace(RuntimeException e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }

}
