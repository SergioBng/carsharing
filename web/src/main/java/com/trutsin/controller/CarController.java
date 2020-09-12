package com.trutsin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showHome");
        return modelAndView;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ModelAndView showCars() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showCars");
        return modelAndView;
    }
}
