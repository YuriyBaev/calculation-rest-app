package com.calc.calculation.controller;

import com.calc.calculation.dto.CalculationResponse;
import com.calc.calculation.dto.OperationRequest;
import com.calc.calculation.entity.Value;
import com.calc.calculation.enums.Operation;
import com.calc.calculation.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
public class CalcController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalcController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping(path = "calc",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalculationResponse> calculateValues(@RequestBody OperationRequest operationRequest) {
        Value value = new Value();
        value.setValueA(Long.parseLong(operationRequest.getValue1()));
        value.setValueB(Long.parseLong(operationRequest.getValue2()));
        long res = calculatorService.calculate(value, Operation.getByValue(operationRequest.getOperation()));
        CalculationResponse calculationResponse = new CalculationResponse();
        calculationResponse.setExpression(operationRequest.getValue1(), operationRequest.getValue2(), operationRequest.getOperation());
        calculationResponse.setResult(res);
        return new ResponseEntity<>(calculationResponse, HttpStatus.OK);

    }

}
