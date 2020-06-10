package com.nugumanov.gearcalculator.domain;

import ru.itis.software.engineering.gear.library.belt.model.AbstractPulley;
import ru.itis.software.engineering.gear.library.belt.model.DrivenPulley;
import ru.itis.software.engineering.gear.library.pulleyExample.Pulley;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PulleyDomain {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private double diameter;
    private double width;
    private double shaftPower;
    private double shaftAngularVelocity;
    private double rotationSpeed;

    public PulleyDomain() {}

    public PulleyDomain(Integer id, double diameter, double width, double shaftPower, double shaftAngularVelocity, double rotationSpeed) {
        this.id = id;
        this.diameter = diameter;
        this.width = width;
        this.shaftPower = shaftPower;
        this.shaftAngularVelocity = shaftAngularVelocity;
        this.rotationSpeed = rotationSpeed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getShaftPower() {
        return shaftPower;
    }

    public void setShaftPower(double shaftPower) {
        this.shaftPower = shaftPower;
    }

    public double getShaftAngularVelocity() {
        return shaftAngularVelocity;
    }

    public void setShaftAngularVelocity(double shaftAngularVelocity) {
        this.shaftAngularVelocity = shaftAngularVelocity;
    }

    public double getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(double rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    public Pulley getPulley() {
        Pulley pulley = new Pulley(diameter, width, shaftPower, shaftAngularVelocity, rotationSpeed);
        return pulley;
    }

    @Override
    public String toString() {
        return "DrivenPulleyDomain{" +
                "id=" + id +
                ", diameter=" + diameter +
                ", width=" + width +
                ", shaftPower=" + shaftPower +
                ", shaftAngularVelocity=" + shaftAngularVelocity +
                ", rotationSpeed=" + rotationSpeed +
                '}';
    }
}
