package com.calculator.vbaisa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CalculatorApplication.class, args);
	}

}
