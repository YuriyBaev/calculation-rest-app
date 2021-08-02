package com.calc.calculation.exceptions;

import com.calc.calculation.dto.ErroneousResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"com.calc.calculation.controller"})
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErroneousResponse> handleArithmeticException(ArithmeticException arithmeticException) {
        ErroneousResponse erroneousResponse = new ErroneousResponse("001", arithmeticException.getMessage());
        return new ResponseEntity<>(erroneousResponse, HttpStatus.BAD_REQUEST);
    }

}
