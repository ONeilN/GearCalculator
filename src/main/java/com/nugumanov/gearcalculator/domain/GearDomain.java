package com.nugumanov.gearcalculator.domain;

import ru.itis.software.engineering.gear.library.Module;
import ru.itis.software.engineering.gear.library.gearExample.Gear;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GearDomain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Long teeth1;
    private Long teeth2;
    private Float width;
    private String module;
    private Double angle;
    private Double x;

    public GearDomain() {

    }

    public GearDomain(Integer id, Long teeth1, Long teeth2, Float width, String module, Double angle, Double x) {
        this.id = id;
        this.teeth1 = teeth1;
        this.teeth2 = teeth2;
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

    public Long getTeeth1() {
        return teeth1;
    }

    public void setTeeth1(Long teeth1) {
        this.teeth1 = teeth1;
    }

    public Long getTeeth2() {
        return teeth2;
    }

    public void setTeeth2(Long teeth2) {
        this.teeth2 = teeth2;
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

    public Gear getGear() {
        Gear gear = new Gear(teeth1, teeth2, width, Module.valueOf(module), angle, x);

        return gear;
    }

    @Override
    public String toString() {
        return "GearDomain{" +
                "id=" + id +
                ", teeth1=" + teeth1 +
                ", teeth2=" + teeth2 +
                ", width=" + width +
                ", module='" + module + '\'' +
                ", angle=" + angle +
                ", x=" + x +
                '}';
    }
}
