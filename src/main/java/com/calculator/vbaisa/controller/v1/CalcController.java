package com.calculator.vbaisa.controller.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/")
public class CalcController {

    @GetMapping("calculate/{exp}")
    public @ResponseBody String calculateResult(@PathVariable String exp) {
        return "";
    }
}
