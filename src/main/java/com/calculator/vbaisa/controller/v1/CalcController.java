package com.calculator.vbaisa.controller.v1;

import com.calculator.vbaisa.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/")
public class CalcController {

    @Autowired
    private CalcService calcService;

    @PostMapping("calculate")
    public @ResponseBody String calculateResult(@RequestBody String exp) {
        return calcService.CalculateValue(exp);
    }
}
