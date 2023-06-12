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

    private float a;
    private float b;
    private float c;

    //initial investment
    private float p;
    //interest rate
    private float r;
    //time
    private float t;
    //compound per year
    private float n;
    //deposit
    private float d;


}
