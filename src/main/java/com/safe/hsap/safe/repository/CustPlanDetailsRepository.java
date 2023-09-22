package com.safe.hsap.safe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.safe.hsap.safe.model.CustPlanDetails;

@Repository
public interface CustPlanDetailsRepository extends JpaRepository<CustPlanDetails, Long> {
	
	@Query("Select a.cost from PlanDetails a where a.planId=:planId")
	public int getPlanCost(@Param("planId") int planId);

}
