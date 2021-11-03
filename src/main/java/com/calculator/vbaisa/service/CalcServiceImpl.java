package com.calculator.vbaisa.service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.slf4j.Logger;
import org.springframework.util.StringUtils;

@Service
public class CalcServiceImpl implements CalcService{
    private static final Logger log = LoggerFactory.getLogger(CalcServiceImpl.class);

    @Override
    public String CalculateValue(String exp) {
        if(!StringUtils.hasLength(exp)) return "";

        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
            String val = engine.eval(exp).toString();
            log.trace("Eval value is: " + val);
            return val;
        } catch (ScriptException se) {
            return "Calculation error";
        }
    }
}
