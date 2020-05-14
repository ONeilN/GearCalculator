package com.nugumanov.gearcalculator.repos;

import com.nugumanov.gearcalculator.domain.Gear;
import org.springframework.data.repository.CrudRepository;

public interface GearRepo extends CrudRepository<Gear, Integer> {

}
