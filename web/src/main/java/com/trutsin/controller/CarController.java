package com.trutsin.controller;

import com.trutsin.dal.entity.Car;
import com.trutsin.service.services.CarService;
import com.trutsin.service.services.CarServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarController {
    private CarService carService = new CarServiceImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ModelAndView showCars() {
        List<Car> cars = carService.readAllCars();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cars");
        modelAndView.addObject("carsList", cars);
        return modelAndView;
    }
}
