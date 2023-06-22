package com.calculator.service;

import com.calculator.model.CalculatorModel;
import com.calculator.model.ResultModel;
import org.springframework.stereotype.Service;

import static java.lang.Math.abs;

@Service
public class CalculatorService {

    public float add(CalculatorModel model){
        return model.getVariableA() + model.getVariableB();
    }

    public float subtract(CalculatorModel model){
        return model.getVariableA() - model.getVariableB();
    }

    public float multiply(CalculatorModel model){
        return model.getVariableA() * model.getVariableB();
    }

    public float divide(CalculatorModel model){
        if(model.getVariableA() == 0) return 0;
        if(model.getVariableB() == 0) return 0;
        return (float) model.getVariableA() / model.getVariableB();
    }

    public float factorial(CalculatorModel model) {
        return  factorial(model.getVariableC());
    }

    private float factorial(float n){
        return  n < 2 ? n : n * factorial(n-1);
    }

    public float fibonacci(CalculatorModel model){
        return fibonacci(model.getVariableC());
    }

    private float fibonacci(float n){
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public float sqrt(CalculatorModel model){
        return (float) Math.sqrt(model.getVariableC());
    }

    public float power(CalculatorModel model){
        return model.getVariableC() * model.getVariableC();
    }

    public ResultModel simpleInterest(CalculatorModel model){

        float totalBalance = model.getInitialInvestment()+(model.getInitialInvestment()*model.getInterestRate()/100)*model.getTime();
        float accruedInterest = totalBalance-model.getInitialInvestment();

        ResultModel result = new ResultModel(totalBalance,accruedInterest);

        return result;
    }

    public ResultModel compoundInterest(CalculatorModel model){

            float totalBalance = model.getInitialInvestment();

            for(int x = 1; x<=model.getTime()*model.getCompoundPerYear(); x++) {
                totalBalance=totalBalance+((totalBalance*model.getInterestRate())/100);
                totalBalance=totalBalance+model.getDeposit();

            }
            float totalDeposit = model.getInitialInvestment() + model.getDeposit()*model.getCompoundPerYear()*model.getTime();
            float accruedInterest = totalBalance-totalDeposit;

            ResultModel result=new ResultModel(totalBalance,totalDeposit,accruedInterest);

       return result;
    }

   public ResultModel quadraticEquation(CalculatorModel model){


       if(model.getVariableA()==0){

           String message="A cannot be 0";
           ResultModel result = new ResultModel("0","0","0",message);

           return result;
       }
       else {
           double discriminant = (model.getVariableB() * model.getVariableB() - 4.0 * model.getVariableA() * model.getVariableC());
           double sqrtDiscriminant  = Math.sqrt(abs(discriminant ));

           if (discriminant  > 0) {

               double rootOne = (-model.getVariableB() + sqrtDiscriminant ) / (2.0 * model.getVariableA());
               double rootTwo = (-model.getVariableB() - sqrtDiscriminant ) / (2.0 * model.getVariableA());
               String message="The roots of the equation are real and different.";

               ResultModel result = new ResultModel(String.valueOf(discriminant),String.valueOf(rootOne),String.valueOf(rootTwo),message);

               return result;

           } else if (discriminant  == 0) {

               double root = -model.getVariableB() / (2.0 * model.getVariableA());
               String message="The roots of the equation are real and same.";

               ResultModel result = new ResultModel(String.valueOf(discriminant),String.valueOf(root),String.valueOf(root),message);

               return result;

           } else {

               double root = -model.getVariableB() / (2.0 * model.getVariableA());

               String complexRootOne = root + " +i" + sqrtDiscriminant ;
               String complexRootTwo = root + " -i" + sqrtDiscriminant ;
               String message="The roots of the equation are complex and different.";

               ResultModel result = new ResultModel(String.valueOf(discriminant),complexRootOne,complexRootTwo,message);

               return result;
           }
       }

   }


    public CalculatorModel clear(CalculatorModel model){
        CalculatorModel clearModel = new CalculatorModel(0,0,0,0,0,0,0,0);

        return clearModel;
    }

}
