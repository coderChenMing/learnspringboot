package com.learnspringboot.exception.handler;/*
 * Project: springboot03
 * File Created at 2021-07-04 13:45:13:45
 * @Type GlobalExceptionHandler.java
 * @Desc
 * @author <a href="mailto: ">chenming</a>
 * @date 2021/7/4 0004 13:45
 * @version
 */

import com.learnspringboot.response.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 异常处理
     */
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView handArithmeticException(Exception e) {
        ModelAndView view = new ModelAndView();
        view.addObject("error", e.toString());
        view.setViewName("arithmetic");
        return view;
    }

    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView handNullPointerException(Exception e) {
        ModelAndView view = new ModelAndView();
        view.addObject("error", e.toString());
        view.setViewName("nullPointer");
        return view;
    }
    @ExceptionHandler(value = {javax.validation.ConstraintViolationException.class})
    @ResponseBody
    public String handValidationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> collect = constraintViolations.stream()
                .map(o -> o.getMessage())
                .collect(Collectors.toList());
        Response respons = new Response(collect);
        return respons.getJsonBody();
    }
    @ResponseBody
    @ExceptionHandler(value = javax.validation.ValidationException.class)
    public String validationExceptionHandler(ValidationException ex){
        Response respons = new Response(ex.getMessage());
        return respons.getJsonBody();
    }
}
