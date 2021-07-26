package com.calc.calculation.dto;

import lombok.Data;

@Data
public class CalculationResponse {
    private String expression;
    private long result;

    public void setExpression(String val1, String val2, char op) {
        StringBuilder stringBuilder = new StringBuilder();
        this.expression = stringBuilder.append(val1).append(op).append(val2).toString();
    }
}
