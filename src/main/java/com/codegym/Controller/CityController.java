package com.codegym.Controller;

import com.codegym.Model.City;
import com.codegym.Model.Nation;
import com.codegym.Service.ICityService;
import com.codegym.Service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class CityController {
    @Autowired
    ICityService cityService;
    @Autowired
    INationService nationService;

    @ModelAttribute("nationList")
    public List<Nation> nationList(){
        return nationService.getAllNation();
    }

    @GetMapping(value = "/cityList", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView listCategory(){
        ModelAndView modelAndView = new ModelAndView("City/CityList");
        List<City> cityList = cityService.getAllCity();
        modelAndView.addObject("cityList",cityList);
        return modelAndView;
    }

    @GetMapping(value = "/cityAdd", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView cityAddForm(){
        ModelAndView modelAndView = new ModelAndView("City/addCity");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }

    @PostMapping(value = "/cityAdd", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView cityAdd(@ModelAttribute("city") City city, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("City/addCity");
        City newCity = cityService.addCity(city);
        if(newCity!=null)
            modelAndView.addObject("message","Add successfully");
        modelAndView.addObject("city",newCity);
        return modelAndView;
    }

    @GetMapping(value = "/editCity/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView nationEditForm(@PathVariable("id") Long cityId){
        ModelAndView modelAndView = new ModelAndView("City/editCity");
        City city = cityService.findCityById(cityId);
        if(city==null){
            modelAndView.addObject("message","Not found");
        }
        modelAndView.addObject("city",city);
        return modelAndView;
    }

    @PostMapping(value = "/editCity", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView nationEdit(@Valid @ModelAttribute("city") City city, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("City/editCity");
        City editedCity = cityService.updateCity(city);
        if (editedCity != null) {
            modelAndView.addObject("message", "Update Successfully");
            modelAndView.addObject("city", editedCity);
            return modelAndView;
        } else {
            modelAndView.addObject("message", "Update Successfully");
            return modelAndView;
        }
    }

    @GetMapping(value = "/deleteCity/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView nationDeleteForm(@PathVariable("id") Long cityId){
        ModelAndView modelAndView = new ModelAndView("City/deleteCity");
        City city = cityService.findCityById(cityId);
        if(city==null){
            modelAndView.addObject("message","Not found");
        }
        modelAndView.addObject("city",city);
        return modelAndView;
    }

    @PostMapping(value = "/deleteCity", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String nationDelete(@ModelAttribute("city") City city) {
        ModelAndView modelAndView = new ModelAndView("City/CityList");
        cityService.removeCity(city);
        return "redirect:/cityList";
    }

}
