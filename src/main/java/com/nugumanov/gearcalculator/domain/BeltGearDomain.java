package com.nugumanov.gearcalculator.domain;

import ru.itis.software.engineering.gear.library.belt.FlatBeltGear;
import ru.itis.software.engineering.gear.library.belt.VBeltGear;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BeltGearDomain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private double ratio;
    private double slipRatio;
    private double centerDistance;
    private double rotationSpeedIdling;
    private double rotationSpeedLoad;

    public BeltGearDomain() {

    }

    public BeltGearDomain(Integer id, double ratio, double slipRatio, double centerDistance, double rotationSpeedIdling, double rotationSpeedLoad) {
        this.id = id;
        this.ratio = ratio;
        this.slipRatio = slipRatio;
        this.centerDistance = centerDistance;
        this.rotationSpeedIdling = rotationSpeedIdling;
        this.rotationSpeedLoad = rotationSpeedLoad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public double getSlipRatio() {
        return slipRatio;
    }

    public void setSlipRatio(double slipRatio) {
        this.slipRatio = slipRatio;
    }

    public double getCenterDistance() {
        return centerDistance;
    }

    public void setCenterDistance(double centerDistance) {
        this.centerDistance = centerDistance;
    }

    public double getRotationSpeedIdling() {
        return rotationSpeedIdling;
    }

    public void setRotationSpeedIdling(double rotationSpeedIdling) {
        this.rotationSpeedIdling = rotationSpeedIdling;
    }

    public double getRotationSpeedLoad() {
        return rotationSpeedLoad;
    }

    public void setRotationSpeedLoad(double rotationSpeedLoad) {
        this.rotationSpeedLoad = rotationSpeedLoad;
    }

    public FlatBeltGear getFlatBeltGear() {
        FlatBeltGear flatBeltGear = new FlatBeltGear(ratio,  slipRatio,  centerDistance,  rotationSpeedIdling,  rotationSpeedLoad);

        return flatBeltGear;
    }

    public VBeltGear getVBeltGear() {
        VBeltGear vBeltGear = new VBeltGear(ratio,  slipRatio,  centerDistance,  rotationSpeedIdling,  rotationSpeedLoad);

        return vBeltGear;
    }

    @Override
    public String toString() {
        return "BeltGearDomain{" +
                "id=" + id +
                ", ratio=" + ratio +
                ", slipRatio=" + slipRatio +
                ", centerDistance=" + centerDistance +
                ", rotationSpeedIdling=" + rotationSpeedIdling +
                ", rotationSpeedLoad=" + rotationSpeedLoad +
                '}';
    }
}
