package com.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class ResultModel {

    float totalBalance;
    float totalDeposit;
    float accruedInterest;
    String discriminant;
    String rootOne;
    String rootTwo;
    String message;


    public ResultModel(float totalBalance, float totalDeposit, float accruedInterest) {
        this.totalBalance = totalBalance;
        this.totalDeposit = totalDeposit;
        this.accruedInterest = accruedInterest;
    }

    public ResultModel(float totalBalance, float accruedInterest) {
        this.totalBalance = totalBalance;
        this.accruedInterest = accruedInterest;
    }

    public ResultModel(String  discriminant, String rootOne, String rootTwo, String message) {
        this.discriminant = discriminant;
        this.rootOne = rootOne;
        this.rootTwo = rootTwo;
        this.message = message;
    }
}
