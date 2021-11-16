package com.calculator.vbaisa.global.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


@Controller
public class ApplicationErrorController implements ErrorController {
    @Autowired
    private com.calculator.vbaisa.common.Error.Builder error;

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public @ResponseBody String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                error.setErrorCode("BAD_REQUEST")
                        .setMessage("Error 404 recourse can't be found")
                        .setPath(request.getRequestURI())
                        .setTimeStamp(LocalDateTime.now())
                        .setStatus(HttpStatus.NOT_FOUND);
                return error.build().toString();
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                error.setErrorCode("BAD_REQUEST")
                        .setMessage("Error 500 server error")
                        .setPath(request.getRequestURI())
                        .setTimeStamp(LocalDateTime.now())
                        .setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                return error.build().toString();
            }

            error.setPath(request.getRequestURI())
                    .setTimeStamp(LocalDateTime.now())
                    .setMessage("Server error " + statusCode);
            return error.build().toString();
        }

        error.setPath(request.getRequestURI())
                .setTimeStamp(LocalDateTime.now())
                .setMessage("error");
        return error.build().toString();
    }
}
