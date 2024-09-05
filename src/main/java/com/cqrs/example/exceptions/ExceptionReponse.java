package com.cqrs.example.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Data
@Builder
public class ExceptionReponse implements Serializable {

    private Date timestamp;
    private String message;
    private String details;

}
