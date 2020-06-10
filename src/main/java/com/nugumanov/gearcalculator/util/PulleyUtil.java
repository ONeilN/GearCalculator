package com.nugumanov.gearcalculator.util;

public class PulleyUtil {
    /**
     * Диаметр шкива
     */
    private String diameter;
    /**
     * Ширина шкива
     */
    private String width;
    /**
     * Мощность на валу
     */
    private String shaftPower;
    /**
     * Угловая скорость вала
     */
    private String shaftAngularVelocity;
    /**
     * Частота вращения
     */
    private String rotationSpeed;

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getShaftPower() {
        return shaftPower;
    }

    public void setShaftPower(String shaftPower) {
        this.shaftPower = shaftPower;
    }

    public String getShaftAngularVelocity() {
        return shaftAngularVelocity;
    }

    public void setShaftAngularVelocity(String shaftAngularVelocity) {
        this.shaftAngularVelocity = shaftAngularVelocity;
    }

    public String getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(String rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }
}
