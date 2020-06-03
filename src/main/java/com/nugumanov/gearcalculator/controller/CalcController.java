package com.nugumanov.gearcalculator.controller;

import com.nugumanov.gearcalculator.domain.GearDomain;
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
import ru.itis.software.engineering.gear.library.gearExample.Gear;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CalcController {

    @Autowired
    private GearRepo gearRepo;

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public String calcForm(Model model) {
        model.addAttribute("calcUtil", new CalcUtil());

        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);

        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, params = "getDiameter")
    public String getDiameter(
            @ModelAttribute CalcUtil calcUtil,
            @RequestParam(required = false, defaultValue = "") String diameter,
            Model model
    ) {
        Optional<GearDomain> gearDomain = gearRepo.findById(calcUtil.getId1());

        Gear gear = gearDomain.get().getGear();

        diameter = Double.toString(gear.getDiameter());

        model.addAttribute("calcUtil", calcUtil);
        model.addAttribute("diameter", diameter);

        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, params = "getGearRatio")
    public String getGearRatio(
            @ModelAttribute CalcUtil calcUtil,
            @RequestParam(required = false, defaultValue = "") String result,
            Model model
    ) {
        Optional<GearDomain> gear1 = gearRepo.findById(calcUtil.getId1());
        Optional<GearDomain> gear2 = gearRepo.findById(calcUtil.getId2());
        double ratio = GearLibrary.GEAR_LIBRARY.getGearRatio(gear1.get().getTeeth1(), gear2.get().getTeeth1());
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
        Optional<GearDomain> gear1 = gearRepo.findById(calcUtil.getId1());
        Optional<GearDomain> gear2 = gearRepo.findById(calcUtil.getId2());
        double ratio = GearLibrary.GEAR_LIBRARY.getGearCenterDistance(gear1.get().getTeeth1(), gear2.get().getTeeth1(), calcUtil.getTeethAngle(), Module.valueOf(gear1.get().getModule()));

        distance = Double.toString(ratio);

        model.addAttribute("calcUtil", calcUtil);
        model.addAttribute("distance", distance);

        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, params = "getGearDividingDiameter")
    public String getGearDividingDiameter(
            @ModelAttribute CalcUtil calcUtil,
            @RequestParam(required = false, defaultValue = "") String dividing,
            Model model
    ) {
        Optional<GearDomain> gearDomain = gearRepo.findById(calcUtil.getId1());

        double result = GearLibrary.GEAR_LIBRARY.getGearDividingDiameter(gearDomain.get().getTeeth1(), gearDomain.get().getAngle(), Module.valueOf(gearDomain.get().getModule()));

        dividing = Double.toString(result);

        model.addAttribute("calcUtil", calcUtil);
        model.addAttribute("dividing", dividing);

        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, params = "getGearToothTopDiameter")
    public String getGearToothTopDiameter(
            @ModelAttribute CalcUtil calcUtil,
            @RequestParam(required = false, defaultValue = "") String topdiameter,
            Model model
    ) {
        if (calcUtil.getId1() == null) {
            System.out.println("Условие сработало!");
            return "calc";
        }
        Optional<GearDomain> gearDomain = gearRepo.findById(calcUtil.getId1());

        Gear gear = gearDomain.get().getGear();
        double deltaY = GearLibrary.GEAR_LIBRARY.getDeltaY(gearDomain.get().getTeeth1(), gearDomain.get().getTeeth2(), gearDomain.get().getAngle(), Module.valueOf(gearDomain.get().getModule()));

        double result = GearLibrary.GEAR_LIBRARY.getGearToothTopDiameter(gear.getGearTeeth(), gear.getTeethAngle(), gear.getGearModule(), gearDomain.get().getX(), deltaY);
        System.out.println(result);
        topdiameter = Double.toString(result);



        model.addAttribute("calcUtil", calcUtil);
        model.addAttribute("topdiameter", topdiameter);

        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);

        return "calc";
    }
}
