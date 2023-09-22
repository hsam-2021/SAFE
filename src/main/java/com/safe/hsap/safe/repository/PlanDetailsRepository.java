package com.safe.hsap.safe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.safe.hsap.safe.model.PlanDetails;

@Repository
public interface PlanDetailsRepository extends JpaRepository < PlanDetails, Long >{

}
