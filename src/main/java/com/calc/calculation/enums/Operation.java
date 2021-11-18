package com.calc.calculation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Operation {
    ADDITION('+'),
    MULTIPLICATION('*'),
    DIVISION('/'),
    SUBTRACTION('-');

    private final char operation;

    public static Operation getByValue(char value) {
        return Arrays.stream(values())
                .filter(op -> value == op.getOperation())
                .findFirst()
                .orElse(null);
    }
}
