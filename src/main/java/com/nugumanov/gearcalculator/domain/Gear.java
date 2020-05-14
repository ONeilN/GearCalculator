package com.nugumanov.gearcalculator.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gear {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Long teeth;
    private Float width;
    private String module;
    private Double angle;
    private Double x;

    public Gear() {

    }

    public Gear(Integer id, Long teeth, Float width, String module, Double angle, Double x) {
        this.id = id;
        this.teeth = teeth;
        this.width = width;
        this.module = module;
        this.angle = angle;
        this.x = x;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTeeth() {
        return teeth;
    }

    public void setTeeth(Long teeth) {
        this.teeth = teeth;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }
}
