package com.calculator.controllers;

import com.calculator.model.CalculatorModel;
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
        model.addAttribute("result", service.add(calculatorModel));
        return "simple";
    }

    @PostMapping(value="/simple", params="subtract")
    public String subtract(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", service.subtract(calculatorModel));
        return "simple";
    }

    @PostMapping(value="/simple", params="multiply")
    public String multiply(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", service.multiply(calculatorModel));
        return "simple";
    }

    @PostMapping(value="/simple", params="divide")
    public String divide(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", service.divide(calculatorModel));
        return "simple";
    }

    @GetMapping("/advanced")
    public String showAdvancedPage(Model model){
        model.addAttribute("calculatorModel",calculatorModel);
        return "advanced";
    }

    @PostMapping(value="/advanced", params="fibonacci")
    public String fibonacci(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", service.fibonacci(calculatorModel));
        return "advanced";
    }

    @PostMapping(value="/advanced", params="sqrt")
    public String sqrt(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", service.sqrt(calculatorModel));
        return "advanced";
    }

    @PostMapping(value="/advanced", params="power")
    public String power(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", service.power(calculatorModel));
        return "advanced";
    }

    @PostMapping(value="/advanced", params="factorial")
    public String factorial(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("result", service.factorial(calculatorModel));
        return "advanced";
    }

    @PostMapping(value="/simple", params="clearSimple")
    public String clearSimple(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("calculatorModel",  service.clearSimple(calculatorModel));
        model.addAttribute("result", 0);
        return "simple";
    }

    @PostMapping(value="/advanced", params="clearAdvanced")
    public String clearAdvanced(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("calculatorModel",  service.clearAdvanced(calculatorModel));
        model.addAttribute("result", 0);
        return "advanced";
    }

    @GetMapping("/compoundInterest")
    public String showCompoundInterestPage(Model model){
        model.addAttribute("calculatorModel",calculatorModel);
        return "compoundInterest";
    }

    @PostMapping(value="/compoundInterest")
    public String compoundInterest(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("totalBalance", service.compoundInterest(calculatorModel));
        model.addAttribute("totalDeposit", service.totalDeposit(calculatorModel));
        model.addAttribute("accruedInterest", service.accruedInterestCompound(calculatorModel));
        return "compoundInterest";
    }

    @GetMapping("/simpleInterest")
    public String showSimpleInterestPage(Model model){
        model.addAttribute("calculatorModel",calculatorModel);
        return "simpleInterest";
    }

    @PostMapping(value="/simpleInterest")
    public String simpleInterest(@ModelAttribute("calculatorModel")  CalculatorModel calculatorModel, Model model ){
        model.addAttribute("totalBalance", service.simpleInterest(calculatorModel));
        model.addAttribute("accruedInterest", service.accruedInterestSimple(calculatorModel));
        return "simpleInterest";
    }

}
