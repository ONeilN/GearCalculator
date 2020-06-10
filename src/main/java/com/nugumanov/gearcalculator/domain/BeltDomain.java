package com.nugumanov.gearcalculator.domain;

import ru.itis.software.engineering.gear.library.belt.model.Belt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BeltDomain {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Double length;

    public BeltDomain(Integer id, Double length) {
        this.id = id;
        this.length = length;
    }

    public BeltDomain() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Belt getBelt() {
        // Не хватает конструктора
        Belt belt = new Belt(length);
        return belt;
    }

    @Override
    public String toString() {
        return "BeltDomain{" +
                "id=" + id +
                ", length=" + length +
                '}';
    }
}
