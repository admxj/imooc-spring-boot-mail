package com.admxj.spring.boot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public String globalExceptionHandler(HttpServletRequest request, Exception e) throws Exception {

        logger.info(e.getClass().getName());
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", e.getMessage());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return e.getMessage();
    }

    @ExceptionHandler(value = {MultipartException.class, HttpMessageNotReadableException.class})
    public Map<String, String> jsonExceptionHandler(HttpServletRequest request, Exception exception) {

        String msg = null;
        if (exception instanceof MultipartException){
            msg = exception.getCause().getCause().getMessage();
        }else if (exception instanceof HttpMessageNotReadableException){
            msg = exception.getMessage();
        }

        Map<String, String> re = new HashMap<String, String>();
        re.put("error", "1");
        re.put("msg", msg);
        return re;
    }
}
