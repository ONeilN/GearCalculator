package com.nugumanov.gearcalculator.controller;

import com.nugumanov.gearcalculator.util.GearUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GearController {

    @RequestMapping(value = "/gear", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("gearUtil", new GearUtil());
        return "gear";
    }

    @RequestMapping(value = "/gear",
            method = RequestMethod.POST,
            params = "gearRatio")
    public String greetingSubmit(
            @ModelAttribute GearUtil gearUtil,
            Model model
    ) {
        model.addAttribute("gearUtil", gearUtil);
        return "gearRatioResult";
    }
}
