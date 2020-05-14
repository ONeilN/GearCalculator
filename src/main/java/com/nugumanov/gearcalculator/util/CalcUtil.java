package com.nugumanov.gearcalculator.util;

import com.nugumanov.gearcalculator.repos.GearRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class CalcUtil {

    @Autowired
    private GearRepo gearRepo;

    private Integer id1;
    private Integer id2;

    private String result;


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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
