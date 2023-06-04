package com.calculator.service;

import com.calculator.model.CalculatorModel;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int add(CalculatorModel model){
        return model.getA() + model.getB();
    }

    public int subtract(CalculatorModel model){
        return model.getA() - model.getB();
    }

    public int multiply(CalculatorModel model){
        return model.getA() * model.getB();
    }

    public double divide(CalculatorModel model){
        if(model.getA() == 0) return 0;
        if(model.getB() == 0) return 0;
        return (double) model.getA() / model.getB();
    }

    public CalculatorModel clearSimple(CalculatorModel model){
        model.setA(0);
        model.setB(0);
        return model;
    }

    public int factorial(CalculatorModel model) {
        return factorial(model.getC());
    }

    private int factorial(int n){
        return n < 2 ? n : n * factorial(n-1);
    }

    public int fibonacci(CalculatorModel model){
        return fibonacci(model.getC());
    }

    private int fibonacci(int n){
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public double sqrt(CalculatorModel model){
        return Math.sqrt(model.getC());
    }

    public int power(CalculatorModel model){
        return model.getC() * model.getC();
    }



    public CalculatorModel clearAdvanced(CalculatorModel model){
        model.setC(0);
        return model;
    }

    public double compoundInterest(CalculatorModel model){

            double total= model.getP();

            for(int x = 1; x<=model.getT()*model.getN();x++) {
                total=total+((total*model.getR())/100);
                total=total+model.getD();

            }
       return total;
    }

    public double totalDeposit(CalculatorModel model){
        return model.getP() + model.getD()*model.getN()*model.getT();
    }
    public double accruedInterestCompound(CalculatorModel model){
       return compoundInterest(model)-totalDeposit(model);
    }


    public double simpleInterest(CalculatorModel model){
        return model.getP()+(model.getP()*model.getR()/100)*model.getT();
    }

    public double accruedInterestSimple(CalculatorModel model){
        return simpleInterest(model)-model.getP();

    }


}
