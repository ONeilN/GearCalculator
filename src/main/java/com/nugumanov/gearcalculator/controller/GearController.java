package com.nugumanov.gearcalculator.controller;

import com.nugumanov.gearcalculator.domain.GearDomain;
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
        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);
        model.addAttribute("gear", new GearDomain());
        return "addGear";
    }

    @RequestMapping(value = "/addGear",
            method = RequestMethod.POST,
            params = "add")
    public String add(
            @ModelAttribute GearDomain gearDomain,
            Model model
    ) {
        gearRepo.save(gearDomain);

        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);
        model.addAttribute("gearDomain", gearDomain);
        return "addGear";
    }
}
