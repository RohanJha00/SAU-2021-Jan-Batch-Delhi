package com.au2021.controller;

import com.au2021.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;



    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String getResult(@RequestParam String result, ModelMap model){
        model.put("result", result);
        return "Result";
    }
    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculateResult(@RequestParam String inputA, @RequestParam String inputB, @RequestParam String symbol,ModelMap model) throws Exception{

        int result = calculatorService.calculate(inputA, inputB , symbol);

        if(result>1000)
        {
            throw new LargeNumberException();
        }
        model.put("result", result);
        return "result";
    }


    }
