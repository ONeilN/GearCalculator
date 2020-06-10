package com.nugumanov.gearcalculator.controller;

import com.nugumanov.gearcalculator.domain.BeltDomain;
import com.nugumanov.gearcalculator.repos.BeltRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BeltController {

    @Autowired
    private BeltRepo beltRepo;

    @RequestMapping(value = "/addbelt", method = RequestMethod.GET)
    public String beltControllerMain(@ModelAttribute BeltDomain beltDomain,
                                     Model model
    ) {
        Iterable<BeltDomain> belts = beltRepo.findAll();
        model.addAttribute("belts", belts);
        model.addAttribute("beltDomain", new BeltDomain());

        return "addbelt";
    }

    @RequestMapping(value = "/addbelt",
            method = RequestMethod.POST,
            params = "add")
    public String add(
            @ModelAttribute BeltDomain beltDomain,
            BindingResult result,
            Model model
    ) {
        beltRepo.save(beltDomain);
        Iterable<BeltDomain> belts = beltRepo.findAll();
        model.addAttribute("belts", belts);
        model.addAttribute("beltDomain", beltDomain);

        return "addbelt";
    }

    @RequestMapping(value = "/addbelt",
            method = RequestMethod.POST,
            params = "cleardb")
    public String clearDB(
            @ModelAttribute BeltDomain beltDomain,
            BindingResult result,
            Model model
    ) {
        beltRepo.deleteAll();
        Iterable<BeltDomain> belts = beltRepo.findAll();
        model.addAttribute("belts", belts);
        model.addAttribute("beltDomain", beltDomain);

        return "addbelt";
    }
}
