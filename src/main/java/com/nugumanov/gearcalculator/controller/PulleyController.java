package com.nugumanov.gearcalculator.controller;

import com.nugumanov.gearcalculator.domain.GearDomain;
import com.nugumanov.gearcalculator.domain.PulleyDomain;
import com.nugumanov.gearcalculator.repos.GearRepo;
import com.nugumanov.gearcalculator.repos.PulleyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PulleyController {

    @Autowired
    private PulleyRepo pulleyRepo;

    @RequestMapping(value = "/addpulley", method = RequestMethod.GET)
    public String pulleyControllerMain(@ModelAttribute PulleyDomain pulleyDomain,
                                     Model model
    ) {
        Iterable<PulleyDomain> pulleys = pulleyRepo.findAll();
        model.addAttribute("pulleys", pulleys);
        model.addAttribute("pulleyDomain", new PulleyDomain());

        return "addpulley";
    }

    @RequestMapping(value = "/addpulley",
            method = RequestMethod.POST,
            params = "add")
    public String add(
            @ModelAttribute PulleyDomain pulleyDomain,
            BindingResult result,
            Model model
    ) {
        pulleyRepo.save(pulleyDomain);
        Iterable<PulleyDomain> pulleys = pulleyRepo.findAll();
        model.addAttribute("pulleys", pulleys);
        model.addAttribute("pulleyDomain", pulleyDomain);

        return "addpulley";
    }

    @RequestMapping(value = "/addpulley",
            method = RequestMethod.POST,
            params = "cleardb")
    public String clearDB(
            @ModelAttribute PulleyDomain pulleyDomain,
            BindingResult result,
            Model model
    ) {
        pulleyRepo.deleteAll();
        Iterable<PulleyDomain> pulleys = pulleyRepo.findAll();
        model.addAttribute("pulleys", pulleys);
        model.addAttribute("pulleyDomain", pulleyDomain);

        return "addpulley";
    }
}
