package com.calc.calculation.service;

import com.calc.calculation.entity.Value;
import com.calc.calculation.enums.Operation;
import com.calc.calculation.operations.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private final List<Calculate> calculates;

    @Autowired
    public CalculatorServiceImpl(List<Calculate> calculates) {
        this.calculates = calculates;
    }

    @Override
    public long calculate(Value value, Operation operation) {
        return calculates.stream().filter(c -> c.isValid(operation))
                .map(c -> c.doAction(value, c.getLambda(value)))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Operation is not supported"));
    }
}
