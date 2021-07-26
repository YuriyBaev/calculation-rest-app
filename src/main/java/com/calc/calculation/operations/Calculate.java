package com.calc.calculation.operations;

import com.calc.calculation.entity.Value;
import com.calc.calculation.enums.Operation;

import java.util.function.LongBinaryOperator;

public interface Calculate {
    boolean isValid(Operation operation);

    LongBinaryOperator getLambda(Value value);

    default long doAction(Value value, LongBinaryOperator longBinaryOperator) {
        return longBinaryOperator.applyAsLong(value.getValueA(), value.getValueB());
    }
}
