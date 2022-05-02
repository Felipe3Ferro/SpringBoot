package com.example.springmvcmongogradle.task.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetail {
    private String title;
    private int status;
    private String detail;
    private long timestamp;
    private String developerMessage;

}
