package com.codegym.Controller;

import com.codegym.Model.Nation;

import com.codegym.Service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NationController {

    @Autowired
    INationService nationService;

    @GetMapping(value = "/")
    public ModelAndView getNationList(){
        ModelAndView modelAndView = new ModelAndView("Nation/NationList");
        List<Nation> nationList = nationService.getAllNation();
        modelAndView.addObject("nationList",nationList);
        return modelAndView;
    }
    @GetMapping(value = "/addNation")
    public ModelAndView nationAddForm(){
        ModelAndView modelAndView = new ModelAndView("Nation/AddNation");
        modelAndView.addObject("nation",new Nation());
        return modelAndView;
    }
    @PostMapping(value = "/addNation")
    public ModelAndView nationAddForm(@ModelAttribute("nation") Nation nation){
        ModelAndView modelAndView = new ModelAndView("Nation/AddNation");
        Nation newNation = nationService.addNation(nation);
        if(newNation!=null){
            modelAndView.addObject("message","Add successful");
            modelAndView.addObject("nation",newNation);
        }
        return modelAndView;
    }

    @GetMapping(value = "/editNation/{id}")
    public ModelAndView nationEditForm(@PathVariable("id") Long nationId){
        ModelAndView modelAndView = new ModelAndView("Nation/editNation");
        Nation nation = nationService.findNationById(nationId);
        if(nation==null){
            modelAndView.addObject("message","Not found");
        }
        modelAndView.addObject("nation",nation);
        return modelAndView;
    }

    @PostMapping(value = "/editNation")
    public ModelAndView nationEdit(@ModelAttribute("nation") Nation nation) {
        ModelAndView modelAndView = new ModelAndView("Nation/editNation");
        Nation editedNation = nationService.updateNation(nation);
        if (editedNation != null) {
            modelAndView.addObject("message", "Update Successfully");
            modelAndView.addObject("nation", editedNation);
            return modelAndView;
        } else {
            modelAndView.addObject("message", "Update Successfully");
            return modelAndView;
        }
    }

    @GetMapping(value = "/deleteNation/{id}")
    public ModelAndView nationDeleteForm(@PathVariable("id") Long nationId){
        ModelAndView modelAndView = new ModelAndView("Nation/deleteNation");
        Nation nation = nationService.findNationById(nationId);
        if(nation==null){
            modelAndView.addObject("message","Not found");
        }
        modelAndView.addObject("nation",nation);
        return modelAndView;
    }

    @PostMapping(value = "/deleteNation")
    public ModelAndView nationDelete(@ModelAttribute("nation") Nation nation) {
        ModelAndView modelAndView = new ModelAndView("Nation/NationList");
        nationService.removeNation(nation);
        List<Nation> nationList = nationService.getAllNation();
        modelAndView.addObject("message", "Removed Successfully");
        modelAndView.addObject("nationList", nationList);
        return modelAndView;
    }


}

