package com.nugumanov.gearcalculator;

import ru.itis.software.engineering.gear.library.Module;
import ru.itis.software.engineering.gear.library.gearExample.Gear;

public class Main {
    public static void main(String[] args) {
        Gear gear = new Gear(50L, 50L, (float) 20.0, Module.MODULE3, 20.0, 0.0);

        System.out.println("Диаметр: " + gear.getDiameter());
        System.out.println("Зубцы: " + gear.getGearTeeth());
        System.out.println("Модуль: " + gear.getGearModule().name());
    }
}
