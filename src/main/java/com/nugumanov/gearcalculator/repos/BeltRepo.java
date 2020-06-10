package com.nugumanov.gearcalculator.repos;

import com.nugumanov.gearcalculator.domain.BeltDomain;
import org.springframework.data.repository.CrudRepository;

public interface BeltRepo extends CrudRepository<BeltDomain, Integer> {

}
