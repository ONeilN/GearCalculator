package com.nugumanov.gearcalculator.util;

import ru.itis.software.engineering.gear.library.GearLibrary;

public class CalcUtil {

    private String teeth1;
    private String teeth2;

    public String getTeeth1() {
        return teeth1;
    }

    public void setTeeth1(String teeth1) {
        this.teeth1 = teeth1;
    }

    public String getTeeth2() {
        return teeth2;
    }

    public void setTeeth2(String teeth2) {
        this.teeth2 = teeth2;
    }

    public String getGearRatio() {
        long lTeeth1 = Long.parseLong(teeth1);
        long lTeeth2 = Long.parseLong(teeth2);

        Double gearRatio = GearLibrary.GEAR_LIBRARY.getGearRatio(lTeeth1, lTeeth2);

        return gearRatio.toString();
    }
}
