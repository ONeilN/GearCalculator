package com.nugumanov.gearcalculator.repos;

import com.nugumanov.gearcalculator.domain.GearDomain;
import org.springframework.data.repository.CrudRepository;

public interface GearRepo extends CrudRepository<GearDomain, Integer> {

}
