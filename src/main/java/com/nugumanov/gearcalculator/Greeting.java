package com.nugumanov.gearcalculator;

import ru.itis.software.engineering.gear.library.Module;
import ru.itis.software.engineering.gear.library.gearExample.Gear;

public class Greeting {

    private String teeth1;
    private String teeth2;
    private String width;
    private String module;
    private String angle;
    private String x;

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

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getDiameter() {
        long longTeeth1 = Long.parseLong(teeth1);
        long longTeeth2 = Long.parseLong(teeth2);
        float floatWidth = Float.parseFloat(width);
        Module mModule = Module.valueOf(module);
        double doubleAngle = Double.parseDouble(angle);
        double doubleX = Double.parseDouble(x);
        Gear gear = new Gear(longTeeth1, longTeeth2, floatWidth, mModule, doubleAngle, doubleX);

        System.out.println(mModule.toString());
        return gear.getDiameter().toString();
    }
}
