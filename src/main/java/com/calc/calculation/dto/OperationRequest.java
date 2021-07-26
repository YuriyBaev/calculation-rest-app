package com.calc.calculation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperationRequest {
    @JsonProperty("value1")
    private String value1;
    @JsonProperty("value2")
    private String value2;
    @JsonProperty("operation")
    private char operation;
}
