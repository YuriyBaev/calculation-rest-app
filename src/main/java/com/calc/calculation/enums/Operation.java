package com.calc.calculation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Operation {
    ADDITION('+'),
    MULTIPLICATION('*'),
    DIVISION('/'),
    SUBTRACTION('-');

    private final char operation;

    public static Operation getByValue(char value) {
        for(Operation operation : values()) {
            if (value == operation.getOperation()) {
                return operation;
            }
        }
        return null;
    }
}
