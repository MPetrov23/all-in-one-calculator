package com.calculator.controllers;

import com.calculator.model.CalculatorModel;
import com.calculator.model.ResultModel;
import com.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/simpleInterest")
    public String showSimpleInterestPage(Model model){
        model.addAttribute("calculatorModel",calculatorModel);
        return "simpleInterest";
    }

    @PostMapping(value="/simpleInterest")
    public String simpleInterest(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        ResultModel result=service.simpleInterest(calculatorModel);

        model.addAttribute("totalBalance","Total balance: " +  result.getTotalBalance());
        model.addAttribute("accruedInterest","Accrued Interest: " +  result.getAccruedInterest());

        return "simpleInterest";
    }

    @PostMapping(value="/simpleInterest", params="clearSimpleInterest")
    public String clearSimpleInterest(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("calculatorModel",  service.clear(calculatorModel));
        return "simpleInterest";
    }

    @GetMapping("/compoundInterest")
    public String showCompoundInterestPage(Model model){
        model.addAttribute("calculatorModel",calculatorModel);
        return "compoundInterest";
    }

    @PostMapping(value="/compoundInterest")
    public String compoundInterest(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        ResultModel result=service.compoundInterest(calculatorModel);

        model.addAttribute("totalBalance", "Total balance: " + result.getTotalBalance());
        model.addAttribute("totalDeposit", "Total deposit: " + result.getTotalDeposit());
        model.addAttribute("accruedInterest","Accrued Interest: " + result.getAccruedInterest());
        return "compoundInterest";
    }

    @PostMapping(value="/compoundInterest", params="clearCompoundInterest")
    public String clearCompoundInterest(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("calculatorModel",  service.clear(calculatorModel));
        return "compoundInterest";
    }

    @GetMapping("/quadraticEquation")
    public String showQuadraticEquation(Model model){
        model.addAttribute("calculatorModel",calculatorModel);
        return "quadraticEquation";
    }

    @PostMapping(value="/quadraticEquation")
    public String QuadraticEquation(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){

            ResultModel result=service.quadraticEquation(calculatorModel);

            model.addAttribute("Discriminant","D= " + result.getDiscriminant());
            model.addAttribute("RootOne","x1= " + result.getRootOne());
            model.addAttribute("RootTwo","x2= " + result.getRootTwo());
            model.addAttribute("message",result.getMessage());

        return "quadraticEquation";
    }

    @PostMapping(value="/quadraticEquation", params="clearQuadraticEquation")
    public String clearQuadraticEquation(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("calculatorModel",  service.clear(calculatorModel));
        return "quadraticEquation";
    }

}
