package com.example.es.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ErrorDetails {

    private String errorTitle = null;
    private String date = null;
    private List<String> errorDetails = null;

    public ErrorDetails(String errorTitle, List<String> errorDetails) {
        this.errorTitle = errorTitle;
        this.errorDetails = errorDetails;
        date = new Date().toString();
    }

}
