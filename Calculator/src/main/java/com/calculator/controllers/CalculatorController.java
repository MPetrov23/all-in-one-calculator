package com.calculator.controllers;

import com.calculator.model.CalculatorModel;
import com.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CalculatorController {
    CalculatorModel calculatorModel=new CalculatorModel();
    @Autowired
    private CalculatorService service;


    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/simple")
    public String showSimplePage(Model model){
        model.addAttribute("calculatorModel",calculatorModel);
        return "simple";
    }

    @PostMapping(value="/simple", params="add")
    public String add(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", "Result :" + service.add(calculatorModel));
        return "simple";
    }

    @PostMapping(value="/simple", params="subtract")
    public String subtract(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", "Result :" + service.subtract(calculatorModel));
        return "simple";
    }

    @PostMapping(value="/simple", params="multiply")
    public String multiply(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", "Result :" + service.multiply(calculatorModel));
        return "simple";
    }

    @PostMapping(value="/simple", params="divide")
    public String divide(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", "Result :" + service.divide(calculatorModel));
        return "simple";
    }

    @GetMapping("/advanced")
    public String showAdvancedPage(Model model){
        model.addAttribute("calculatorModel",calculatorModel);
        return "advanced";
    }

    @PostMapping(value="/advanced", params="fibonacci")
    public String fibonacci(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", "Result :" + service.fibonacci(calculatorModel));
        return "advanced";
    }

    @PostMapping(value="/advanced", params="sqrt")
    public String sqrt(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", "Result :" + service.sqrt(calculatorModel));
        return "advanced";
    }

    @PostMapping(value="/advanced", params="power")
    public String power(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", "Result :" + service.power(calculatorModel));
        return "advanced";
    }

    @PostMapping(value="/advanced", params="factorial")
    public String factorial(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", "Result :" + service.factorial(calculatorModel));
        return "advanced";
    }

    @PostMapping(value="/simple", params="clearSimple")
    public String clearSimple(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("calculatorModel",  service.clear(calculatorModel));
        return "simple";
    }

    @PostMapping(value="/advanced", params="clearAdvanced")
    public String clearAdvanced(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("calculatorModel",  service.clear(calculatorModel));
        return "advanced";
    }

    @GetMapping("/compoundInterest")
    public String showCompoundInterestPage(Model model){
        model.addAttribute("calculatorModel",calculatorModel);
        return "compoundInterest";
    }

    @PostMapping(value="/compoundInterest")
    public String compoundInterest(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        Map<String,Float> result=service.compoundInterest(calculatorModel);

        model.addAttribute("totalBalance", "Total balance: " + result.get("totalBalance"));
        model.addAttribute("totalDeposit", "Total deposit: " + result.get("totalDeposit"));
        model.addAttribute("accruedInterest","Accrued Interest: " + result.get("accruedInterest"));
        return "compoundInterest";
    }

    @PostMapping(value="/compoundInterest", params="clearCompoundInterest")
    public String clearCompoundInterest(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("calculatorModel",  service.clear(calculatorModel));
        return "compoundInterest";
    }

    @GetMapping("/simpleInterest")
    public String showSimpleInterestPage(Model model){
        model.addAttribute("calculatorModel",calculatorModel);
        return "simpleInterest";
    }

    @PostMapping(value="/simpleInterest")
    public String simpleInterest(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        Map<String,Float> result=service.simpleInterest(calculatorModel);

        model.addAttribute("totalBalance","Total balance: " +  result.get("totalBalance"));
        model.addAttribute("accruedInterest","Accrued Interest: " +  result.get("accruedInterest"));

        return "simpleInterest";
    }

    @PostMapping(value="/simpleInterest", params="clearSimpleInterest")
    public String clearSimpleInterest(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("calculatorModel",  service.clear(calculatorModel));
        return "simpleInterest";
    }

    @GetMapping("/quadraticEquation")
    public String showQuadraticEquation(Model model){
        model.addAttribute("calculatorModel",calculatorModel);
        return "quadraticEquation";
    }

    @PostMapping(value="/quadraticEquation")
    public String QuadraticEquation(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){

            Map<String,String> result=service.quadraticEquation(calculatorModel);

            model.addAttribute("message",result.get("message"));
            model.addAttribute("D","D= " + result.get("D"));
            model.addAttribute("x1","x1= " + result.get("x1"));
            model.addAttribute("x2","x2= " + result.get("x2"));

        return "quadraticEquation";
    }

    @PostMapping(value="/quadraticEquation", params="clearQuadraticEquation")
    public String clearQuadraticEquation(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("calculatorModel",  service.clear(calculatorModel));
        return "quadraticEquation";
    }

}
