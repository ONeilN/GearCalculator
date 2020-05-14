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

    private String teeth1;
    private String width;
    private String module;
    private String angle;
    private String x;

    public Gear() {

    }

    public Gear(Integer id, String teeth1, String teeth2,
                String width, String module, String angle, String x) {
        this.id = id;
        this.teeth1 = teeth1;
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

    public String getTeeth1() {
        return teeth1;
    }

    public void setTeeth1(String teeth1) {
        this.teeth1 = teeth1;
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
}
