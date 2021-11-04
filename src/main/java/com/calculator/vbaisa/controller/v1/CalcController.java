package com.calculator.vbaisa.controller.v1;

import com.calculator.vbaisa.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/")
public class CalcController {

    @Autowired
    private CalcService calcService;

    @GetMapping("calculate/{exp}")
    public @ResponseBody String calculateResult(@PathVariable String exp) {
        return calcService.CalculateValue(exp);
    }
}
