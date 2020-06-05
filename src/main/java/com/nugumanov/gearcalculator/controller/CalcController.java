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
        if (calcUtil.getId1() == null) {
            System.out.println("Условие сработало!");
            return "calc";
        }

        Gear gear = gearRepo.findById(calcUtil.getId1()).get().getGear();

        diameter = Double.toString(gear.getDiameter());

        model.addAttribute("calcUtil", calcUtil);
        model.addAttribute("diameter", diameter);

        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);

        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, params = "getGearRatio")
    public String getGearRatio(
            @ModelAttribute CalcUtil calcUtil,
            @RequestParam(required = false, defaultValue = "") String result,
            Model model
    ) {
        if (calcUtil.getId1() == null) {
            System.out.println("Условие сработало!");
            return "calc";
        }

        Gear gear1 = gearRepo.findById(calcUtil.getId1()).get().getGear();
        Gear gear2 = gearRepo.findById(calcUtil.getId2()).get().getGear();

        double ratio = GearLibrary.GEAR_LIBRARY.getGearRatio(gear1.getGearTeeth(), gear2.getGearTeeth());
        result = Double.toString(ratio);

        model.addAttribute("calcUtil", calcUtil);
        model.addAttribute("result", result);

        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);
        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, params = "getGearCenterDistance")
    public String getGearCenterDistance(
            @ModelAttribute CalcUtil calcUtil,
            @RequestParam(required = false, defaultValue = "") String distance,
            Model model
    ) {
        if (calcUtil.getId1() == null) {
            System.out.println("Условие сработало!");
            return "calc";
        }

        Gear gear1 = gearRepo.findById(calcUtil.getId1()).get().getGear();
        Gear gear2 = gearRepo.findById(calcUtil.getId2()).get().getGear();

        double ratio = GearLibrary.GEAR_LIBRARY.getGearCenterDistance(gear1.getGearTeeth(), gear2.getGearTeeth(), calcUtil.getTeethAngle(), gear1.getGearModule());

        distance = Double.toString(ratio);

        model.addAttribute("calcUtil", calcUtil);
        model.addAttribute("distance", distance);

        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);

        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, params = "getGearDividingDiameter")
    public String getGearDividingDiameter(
            @ModelAttribute CalcUtil calcUtil,
            @RequestParam(required = false, defaultValue = "") String dividing,
            Model model
    ) {
        if (calcUtil.getId1() == null) {
            System.out.println("Условие сработало!");
            return "calc";
        }
//        Optional<GearDomain> gearDomain = gearRepo.findById(calcUtil.getId1());

        Gear gear = gearRepo.findById(calcUtil.getId1()).get().getGear();

        double result = GearLibrary.GEAR_LIBRARY.getGearDividingDiameter(gear.getGearTeeth(), gear.getTeethAngle(), gear.getGearModule());

        dividing = Double.toString(result);

        model.addAttribute("calcUtil", calcUtil);
        model.addAttribute("dividing", dividing);

        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);

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

        Gear gear1 = gearRepo.findById(calcUtil.getId1()).get().getGear();
        Gear gear2 = gearRepo.findById(calcUtil.getId2()).get().getGear();

        double deltaY = GearLibrary.GEAR_LIBRARY.getDeltaY(gear1.getGearTeeth(), gear2.getGearTeeth(), gear1.getTeethAngle(), gear1.getGearModule());

        double result = GearLibrary.GEAR_LIBRARY.getGearToothTopDiameter(gear1.getGearTeeth(), gear2.getTeethAngle(), gear1.getGearModule(), gearDomain.get().getX(), deltaY);

        topdiameter = Double.toString(result);

        model.addAttribute("calcUtil", calcUtil);
        model.addAttribute("topdiameter", topdiameter);

        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);

        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, params = "getGearToothBottomDiameter")
    public String getGearToothBottomDiameter(
            @ModelAttribute CalcUtil calcUtil,
            @RequestParam(required = false, defaultValue = "") String bottomdiameter,
            Model model
    ) {
        if (calcUtil.getId1() == null) {
            System.out.println("Условие сработало!");
            return "calc";
        }
        Optional<GearDomain> gearDomain = gearRepo.findById(calcUtil.getId1());

        Gear gear1 = gearRepo.findById(calcUtil.getId1()).get().getGear();
        Gear gear2 = gearRepo.findById(calcUtil.getId2()).get().getGear();

        double deltaY = GearLibrary.GEAR_LIBRARY.getDeltaY(gear1.getGearTeeth(), gear2.getGearTeeth(), gear1.getTeethAngle(), gear1.getGearModule());

        double result = GearLibrary.GEAR_LIBRARY.getGearToothBottomDiameter(gear1.getGearTeeth(), gear2.getTeethAngle(), gear1.getGearModule(), Double.valueOf(gearDomain.get().getX()).longValue(), deltaY);

        bottomdiameter = Double.toString(result);

        model.addAttribute("calcUtil", calcUtil);
        model.addAttribute("bottomdiameter", bottomdiameter);

        Iterable<GearDomain> gears = gearRepo.findAll();
        model.addAttribute("gears", gears);

        return "calc";
    }
}
