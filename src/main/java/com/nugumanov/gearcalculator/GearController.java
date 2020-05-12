package com.nugumanov.gearcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.software.engineering.gear.library.Module;
import ru.itis.software.engineering.gear.library.gearExample.Gear;

@Controller
public class GearController {

    @RequestMapping(value = "/gear", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "gear";
    }

    @RequestMapping(value = "/gear", method = RequestMethod.POST)
    public String greetingSubmit(
            @ModelAttribute Greeting greeting,
            Model model
    ) {
        model.addAttribute("greeting", greeting);
        return "gearResult";
    }
}
