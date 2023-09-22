package com.safe.hsap.safe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.safe.hsap.safe.model.MealPlan;

@Repository
public interface MealPlanRepository extends JpaRepository < MealPlan, Long >{

}
