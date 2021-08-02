package com.calc.calculation.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ErroneousResponse implements Serializable {
    private final String errorCode;
    private final String errorMessage;
}
