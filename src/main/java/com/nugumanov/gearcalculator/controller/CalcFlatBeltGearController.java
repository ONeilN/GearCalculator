/*
package com.nugumanov.gearcalculator.controller;

import com.nugumanov.gearcalculator.domain.BeltDomain;
import com.nugumanov.gearcalculator.domain.GearDomain;
import com.nugumanov.gearcalculator.domain.PulleyDomain;
import com.nugumanov.gearcalculator.repos.BeltRepo;
import com.nugumanov.gearcalculator.repos.GearRepo;
import com.nugumanov.gearcalculator.repos.PulleyRepo;
import com.nugumanov.gearcalculator.util.CalcBeltGearUtil;
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
import ru.itis.software.engineering.gear.library.belt.FlatBeltGear;
import ru.itis.software.engineering.gear.library.gearExample.Gear;
import ru.itis.software.engineering.gear.library.pulleyExample.Pulley;

import java.util.Optional;

@Controller
public class CalcFlatBeltGearController {

    @Autowired
    private PulleyRepo pulleyRepo;

    @Autowired
    private BeltRepo beltRepo;

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public String calcForm(Model model) {
        model.addAttribute("calcBeltGearUtil", new CalcUtil());

        Iterable<BeltDomain> belts = beltRepo.findAll();
        model.addAttribute("belts", belts);

        Iterable<PulleyDomain> pulleys = pulleyRepo.findAll();
        model.addAttribute("pulleys", pulleys);

        return "calcflatbeltgear";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, params = "calculateDrivenPulleyDiameter")
    public String getDiameter(
            @ModelAttribute CalcBeltGearUtil calcBeltGearUtil,
            @RequestParam(required = false, defaultValue = "") String drivenPulleyDiameter,
            Model model
    ) {
        if (calcBeltGearUtil.getId1() == null || calcBeltGearUtil.getId2() == null) {
            model.addAttribute("calcBeltGearUtil", calcBeltGearUtil);
            model.addAttribute("drivenPulleyDiameter", drivenPulleyDiameter);

            Iterable<BeltDomain> belts = beltRepo.findAll();
            model.addAttribute("belts", belts);

            Iterable<PulleyDomain> pulleys = pulleyRepo.findAll();
            model.addAttribute("pulleys", pulleys);

            return "calcbeltgear";
        }

        FlatBeltGear flatBeltGear = beltRepo.findById(calcBeltGearUtil.getId1()).get().getBelt();


        drivenPulleyDiameter = Double.toString(pulley.getDiameter());

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
        if (calcUtil.getId1() == null || calcUtil.getId2() == null) {
            model.addAttribute("calcUtil", calcUtil);
            model.addAttribute("result", result);

            Iterable<GearDomain> gears = gearRepo.findAll();
            model.addAttribute("gears", gears);
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
        if (calcUtil.getId1() == null || calcUtil.getId2() == null) {
            model.addAttribute("calcUtil", calcUtil);
            model.addAttribute("distance", distance);

            Iterable<GearDomain> gears = gearRepo.findAll();
            model.addAttribute("gears", gears);
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
        if (calcUtil.getId1() == null || calcUtil.getId2() == null) {
            model.addAttribute("calcUtil", calcUtil);
            model.addAttribute("dividing", dividing);

            Iterable<GearDomain> gears = gearRepo.findAll();
            model.addAttribute("gears", gears);
            return "calc";
        }

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
        if (calcUtil.getId1() == null || calcUtil.getId2() == null) {
            model.addAttribute("calcUtil", calcUtil);
            model.addAttribute("topdiameter", topdiameter);

            Iterable<GearDomain> gears = gearRepo.findAll();
            model.addAttribute("gears", gears);
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
        if (calcUtil.getId1() == null || calcUtil.getId2() == null) {
            model.addAttribute("calcUtil", calcUtil);
            model.addAttribute("bottomdiameter", bottomdiameter);

            Iterable<GearDomain> gears = gearRepo.findAll();
            model.addAttribute("gears", gears);
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
*/
