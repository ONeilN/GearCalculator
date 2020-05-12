package com.nugumanov.gearcalculator.controller;

import com.nugumanov.gearcalculator.util.CalcUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalcController {

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public String calcForm(Model model) {
        model.addAttribute("calcUtil", new CalcUtil());
        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public String getGearRatio(
            @ModelAttribute CalcUtil calcUtil,
            Model model
    ) {
        model.addAttribute("calcUtil", calcUtil);
        return "gearRatioResult";
    }
}
