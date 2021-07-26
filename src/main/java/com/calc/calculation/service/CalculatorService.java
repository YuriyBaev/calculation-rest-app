package com.calc.calculation.service;

import com.calc.calculation.entity.Value;
import com.calc.calculation.enums.Operation;

public interface CalculatorService {
    long calculate(Value value, Operation operation);
}
