package com.trutsin.controller;

import com.trutsin.dal.entity.Car;
import com.trutsin.model.Film;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {
    private static Car car;

    static {
        car = new Car();
        car.setModel("Ford Mondeo");
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
        modelAndView.addObject("car", car);
        return modelAndView;
    }
}
