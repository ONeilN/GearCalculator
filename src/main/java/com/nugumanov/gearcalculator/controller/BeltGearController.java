package com.nugumanov.gearcalculator.controller;

import com.nugumanov.gearcalculator.domain.BeltGearDomain;
import com.nugumanov.gearcalculator.domain.GearDomain;
import com.nugumanov.gearcalculator.repos.BeltGearRepo;
import com.nugumanov.gearcalculator.repos.BeltRepo;
import com.nugumanov.gearcalculator.repos.GearRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BeltGearController {

    @Autowired
    private BeltGearRepo beltGearRepo;

    @RequestMapping(value = "/addbeltgear", method = RequestMethod.GET)
    public String gearControllerMain(@ModelAttribute BeltGearDomain beltGearDomain,
                                     Model model
    ) {
        Iterable<BeltGearDomain> beltgears = beltGearRepo.findAll();
        model.addAttribute("beltgears", beltgears);
        model.addAttribute("beltGearDomain", new BeltGearDomain());

        return "addbeltgear";
    }

    @RequestMapping(value = "/addbeltgear",
            method = RequestMethod.POST,
            params = "add")
    public String add(
            @ModelAttribute BeltGearDomain beltGearDomain,
            BindingResult result,
            Model model
    ) {
        beltGearRepo.save(beltGearDomain);
        Iterable<BeltGearDomain> beltgears = beltGearRepo.findAll();
        model.addAttribute("beltgears", beltgears);
        model.addAttribute("beltGearDomain", beltGearDomain);

        return "addbeltgear";
    }

    @RequestMapping(value = "/addbeltgear",
            method = RequestMethod.POST,
            params = "cleardb")
    public String clearDB(
            @ModelAttribute BeltGearDomain beltGearDomain,
            BindingResult result,
            Model model
    ) {
        beltGearRepo.deleteAll();
        Iterable<BeltGearDomain> beltgears = beltGearRepo.findAll();
        model.addAttribute("beltgears", beltgears);
        model.addAttribute("beltGearDomain", beltGearDomain);

        return "addbeltgear";
    }
}
