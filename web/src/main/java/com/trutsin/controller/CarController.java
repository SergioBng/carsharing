package com.trutsin.controller;

import com.trutsin.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {
    private CarServiceImpl carService;

    @Autowired
    public void setCarService(CarServiceImpl carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ModelAndView showCars() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cars");
        return modelAndView;
    }
}
