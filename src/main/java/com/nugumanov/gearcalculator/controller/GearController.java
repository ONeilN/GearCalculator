package com.nugumanov.gearcalculator.controller;

import com.nugumanov.gearcalculator.domain.GearDomain;
import com.nugumanov.gearcalculator.repos.GearRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class GearController {

    @Autowired
    private GearRepo gearRepo;

    @RequestMapping(value = "/addgear", method = RequestMethod.GET)
    public String gearControllerMain(@ModelAttribute GearDomain gearDomain,
                               Model model
    ) {
        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);
        model.addAttribute("gearDomain", new GearDomain());

        return "addgear";
    }

    @RequestMapping(value = "/addgear",
            method = RequestMethod.POST,
            params = "add")
    public String add(
            @ModelAttribute GearDomain gearDomain,
            BindingResult result,
            Model model
    ) {
        gearRepo.save(gearDomain);
        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);
        model.addAttribute("gearDomain", gearDomain);

        return "addgear";
    }

    @RequestMapping(value = "/addgear",
            method = RequestMethod.POST,
            params = "cleardb")
    public String clearDB(
            @ModelAttribute GearDomain gearDomain,
            BindingResult result,
            Model model
    ) {
        gearRepo.deleteAll();
        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);
        model.addAttribute("gearDomain", gearDomain);

        return "addgear";
    }
}
