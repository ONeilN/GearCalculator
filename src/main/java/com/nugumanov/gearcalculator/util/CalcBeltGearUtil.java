package com.nugumanov.gearcalculator.util;

import ru.itis.software.engineering.gear.library.belt.AbstractBeltGear;
import ru.itis.software.engineering.gear.library.belt.FlatBeltGear;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcBeltGearUtil {
    private Integer id1;
    private Integer id2;
    private String ratio;
    private String centerDistance;
    private String rotationSpeedIdling;
    private String rotationSpeedLoad;

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public Integer getId2() {
        return id2;
    }

    public void setId2(Integer id2) {
        this.id2 = id2;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getCenterDistance() {
        return centerDistance;
    }

    public void setCenterDistance(String centerDistance) {
        this.centerDistance = centerDistance;
    }

    public String getRotationSpeedIdling() {
        return rotationSpeedIdling;
    }

    public void setRotationSpeedIdling(String rotationSpeedIdling) {
        this.rotationSpeedIdling = rotationSpeedIdling;
    }

    public String getRotationSpeedLoad() {
        return rotationSpeedLoad;
    }

    public void setRotationSpeedLoad(String rotationSpeedLoad) {
        this.rotationSpeedLoad = rotationSpeedLoad;
    }

    public String getSlipRatio() {
        double rotationSpeedIdling = Double.parseDouble(this.rotationSpeedIdling);
        double rotationSpeedLoad = Double.parseDouble(this.rotationSpeedLoad);

        FlatBeltGear flatBeltGear = new FlatBeltGear();
        double result =  flatBeltGear.calculateSlipRatio(rotationSpeedIdling, rotationSpeedLoad);
        return String.valueOf(result);
    }

}
