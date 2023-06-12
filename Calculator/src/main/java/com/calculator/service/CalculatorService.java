package com.calculator.service;

import com.calculator.model.CalculatorModel;
import org.springframework.stereotype.Service;

import javax.swing.text.LabelView;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

@Service
public class CalculatorService {

    public float add(CalculatorModel model){
        return model.getA() + model.getB();
    }

    public float subtract(CalculatorModel model){
        return model.getA() - model.getB();
    }

    public float multiply(CalculatorModel model){
        return model.getA() * model.getB();
    }

    public float divide(CalculatorModel model){
        if(model.getA() == 0) return 0;
        if(model.getB() == 0) return 0;
        return (float) model.getA() / model.getB();
    }

    public float factorial(CalculatorModel model) {
        return  factorial(model.getC());
    }

    private float factorial(float n){
        return  n < 2 ? n : n * factorial(n-1);
    }

    public float fibonacci(CalculatorModel model){
        return fibonacci(model.getC());
    }

    private float fibonacci(float n){
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public float sqrt(CalculatorModel model){
        return (float) Math.sqrt(model.getC());
    }

    public float power(CalculatorModel model){
        return model.getC() * model.getC();
    }

    public Map<String,Float> simpleInterest(CalculatorModel model){

        Map<String, Float> result = new HashMap<>();

        result.put("totalBalance", model.getP()+(model.getP()*model.getR()/100)*model.getT());
        result.put("accruedInterest", result.get("totalBalance")-model.getP());

        return result;
    }

    public Map<String,Float> compoundInterest(CalculatorModel model){

        Map<String, Float> result = new HashMap<>();
            float total= model.getP();

            for(int x = 1; x<=model.getT()*model.getN();x++) {
                total=total+((total*model.getR())/100);
                total=total+model.getD();

            }

            result.put("totalBalance",total);
            result.put("totalDeposit",   model.getP() + model.getD()*model.getN()*model.getT());
            result.put("accruedInterest",   result.get("totalBalance")-result.get("totalDeposit"));

       return result;
    }

   public Map<String,String> quadraticEquation(CalculatorModel model){
       Map<String, String> result = new HashMap<>();

       if(model.getA()==0){
           result.put("D", "0");
           result.put("x1", "0");
           result.put("x2", "0");
           result.put("message", "A cannot be 0");

           return result;
       }
       else {
           double d = (model.getB() * model.getB() - 4.0 * model.getA() * model.getC());
           double sqrtD = Math.sqrt(abs(d));

           if (d > 0) {
               double x1 = (-model.getB() + sqrtD) / (2.0 * model.getA());
               double x2 = (-model.getB() - sqrtD) / (2.0 * model.getA());

               result.put("D", String.valueOf(d));
               result.put("x1", String.valueOf(x1));
               result.put("x2", String.valueOf(x2));
               result.put("message", "The roots of the equation are real and different.");

               return result;

           } else if (d == 0) {

               double x = -model.getB() / (2.0 * model.getA());

               result.put("D", String.valueOf(d));
               result.put("x1", String.valueOf(x));
               result.put("x2", String.valueOf(x));
               result.put("message", "The roots of the equation are real and same. ");

               return result;

           } else {

               double x = -model.getB() / (2.0 * model.getA());

               result.put("D", String.valueOf(d));
               result.put("x1", String.valueOf(x) + " +i" + String.valueOf(sqrtD));
               result.put("x2", String.valueOf(x) + " -i" + String.valueOf(sqrtD));
               result.put("message", "The roots of the equation are complex and different.");

               return result;
           }
       }

   }


    public CalculatorModel clear(CalculatorModel model){
        CalculatorModel clearModel = new CalculatorModel(0,0,0,0,0,0,0,0);

        return clearModel;
    }

}
