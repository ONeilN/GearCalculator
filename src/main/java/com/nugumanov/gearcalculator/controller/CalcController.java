package com.nugumanov.gearcalculator.controller;

import com.nugumanov.gearcalculator.domain.Gear;
import com.nugumanov.gearcalculator.repos.GearRepo;
import com.nugumanov.gearcalculator.util.CalcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.software.engineering.gear.library.GearLibrary;
import ru.itis.software.engineering.gear.library.Module;

import java.util.Optional;

@Controller
public class CalcController {

    @Autowired
    private GearRepo gearRepo;

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public String calcForm(Model model) {
        model.addAttribute("calcUtil", new CalcUtil());
        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, params = "getGearRatio")
    public String getGearRatio(
            @ModelAttribute CalcUtil calcUtil,
            @RequestParam(required = false, defaultValue = "") String result,
            Model model
    ) {
        Optional<Gear> gear1 = gearRepo.findById(calcUtil.getId1());
        Optional<Gear> gear2 = gearRepo.findById(calcUtil.getId2());
        double ratio = GearLibrary.GEAR_LIBRARY.getGearRatio(gear1.get().getTeeth(), gear2.get().getTeeth());
        result = Double.toString(ratio);

        model.addAttribute("calcUtil", calcUtil);
        model.addAttribute("result", result);
        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, params = "getGearCenterDistance")
    public String getGearCenterDistance(
            @ModelAttribute CalcUtil calcUtil,
            @RequestParam(required = false, defaultValue = "") String distance,
            Model model
    ) {
        Optional<Gear> gear1 = gearRepo.findById(calcUtil.getId1());
        Optional<Gear> gear2 = gearRepo.findById(calcUtil.getId2());
        double ratio = GearLibrary.GEAR_LIBRARY.getGearCenterDistance(gear1.get().getTeeth(), gear2.get().getTeeth(), calcUtil.getTeethAngle(), Module.valueOf(gear1.get().getModule()));

        distance = Double.toString(ratio);

        model.addAttribute("calcUtil", calcUtil);
        model.addAttribute("distance", distance);
        return "calc";
    }
}
