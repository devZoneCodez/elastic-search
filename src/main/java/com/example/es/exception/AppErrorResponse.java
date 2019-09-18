package com.example.es.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Getter
@Setter
public class AppErrorResponse {

    @JsonIgnore
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private String localDateTime = null;
    private int errorCode = -1;
    private String errorTitle = null;
    @JsonIgnore
    private Exception exception = null;
    private String errorMessage = null;
    private String errorTrace = null;
    private Map<String, Object> moreDetails = null;

    public AppErrorResponse(HttpStatus httpStatus
            , Exception exception
            , Map<String, Object> moreDetails) {

        if (httpStatus != null) {
            this.errorCode = httpStatus.value();
            this.errorTitle = httpStatus.getReasonPhrase();
        }

        this.localDateTime = LocalDateTime.now().format(dateFormatter);

        if (exception != null) {
            this.exception = exception;
            this.errorMessage = exception.getLocalizedMessage();
            this.errorTrace = getErrorTraceDetails();
        }
        this.moreDetails = moreDetails;
    }

    private String getErrorTraceDetails() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        this.exception.printStackTrace(pw);
        return sw.toString();
    }
}
