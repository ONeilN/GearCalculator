package com.nugumanov.gearcalculator.controller;

import com.nugumanov.gearcalculator.domain.Gear;
import com.nugumanov.gearcalculator.repos.GearRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GearController {

    @Autowired
    private GearRepo gearRepo;

    @RequestMapping(value = "/addgear", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        Iterable<Gear> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);
        model.addAttribute("gear", new Gear());
        return "addGear";
    }

    @RequestMapping(value = "/addGear",
            method = RequestMethod.POST,
            params = "add")
    public String add(
            @ModelAttribute Gear gear,
            Model model
    ) {
        gearRepo.save(gear);

        Iterable<Gear> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);
        return "addGear";
    }
}
