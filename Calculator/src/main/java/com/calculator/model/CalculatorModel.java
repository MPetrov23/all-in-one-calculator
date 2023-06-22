package com.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CalculatorModel {

    private float variableA;
    private float variableB;
    private float variableC;
    private float initialInvestment;
    private float interestRate;
    private float time;
    private float compoundPerYear;
    private float deposit;

}
