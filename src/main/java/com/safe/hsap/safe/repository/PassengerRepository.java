package com.safe.hsap.safe.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.safe.hsap.safe.model.Passenger;
import com.safe.hsap.safe.model.PassengerRecords;
import com.safe.hsap.safe.model.TransactionRecordsV;

@Repository
public interface PassengerRepository  extends JpaRepository < Passenger, Long > {
	
	@Query("select a from Passenger a where a.pId =:pId")
	public Passenger getPassenger(@Param("pId") int pId);
	
	@Modifying
	@Transactional
	@Query("delete from Passenger a where a.pId =:pId")
	public void  deletePassengerRecord(@Param("pId") int pId);

	@Modifying
	@Transactional
	@Query("update  Passenger a set a.passengerFirstName=:fname, a.passengerLastName=:lname,a.passengerGender=:gender,a.passengerNationality=:nationality,a.passengerPassportNo=:passportNo,a.passengerDob=:dob,a.passengerPassportExpiry=:passExpiry where a.pId =:pId")
	public void updatePassengerRecord(@Param("pId") int pId,@Param("fname") String fname,@Param("lname") String lname,@Param("gender") String gender,@Param("nationality") String nationality,@Param("passportNo") String passportNo,@Param("dob") Date dob,@Param("passExpiry") Date passExpiry);
	
	@Modifying
	@Transactional
	@Query("delete from CustomerPassengerMapping a where a.pId =:pId")
	public void  deletePassengerFromMapping(@Param("pId") int pId);
	

	@Query("Select new com.safe.hsap.safe.model.PassengerRecords("+
            "a.custId,"+
			"a.pId,"+
			"a.fname,"+
			"a.lname,"+
			"a.gender,"+
			"a.nationality,"+
			"a.passportNo,"+
			"a.dob,"+
			"a.passExpiry,"+
			"a.custEmail)"+ 
			"from CustomerPassengerMappingV a where a.custId =:custId")
	public List<PassengerRecords> getPassengerRecords(@Param("custId") int custId);
	
	@Query("select count(*) from CustPlanDetails a where a.custId =:custId")
	public int purchasePlanCount(@Param("custId") int custId);
	
	@Query("select pId from CustomerPassengerMappingV a where a.custId =:custId")
	public List<Integer> getPassengerId(@Param("custId") int custId);
	
	@Query("select a from TransactionRecordsV a where a.custId =:custId")
	public List<TransactionRecordsV> getTransactionDetails(@Param("custId") int custId);
	
	@Query("select a from TransactionRecordsV a")
	public List<TransactionRecordsV> getAllTransactionDetails();
	
}
