package com.calc.calculation.operations;

import com.calc.calculation.entity.Value;
import com.calc.calculation.enums.Operation;
import org.springframework.stereotype.Component;

import java.util.function.LongBinaryOperator;

@Component
public class Division implements Calculate {
    @Override
    public boolean isValid(Operation operation) {
        return Operation.DIVISION.equals(operation);
    }

    @Override
    public LongBinaryOperator getLambda(Value value) {
        return (x, y) -> value.getValueA() / value.getValueB();
    }
}
