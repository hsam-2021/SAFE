package com.safe.hsap.safe.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.safe.hsap.safe.model.BookingAgentPK;
import com.safe.hsap.safe.model.Customer;
import com.safe.hsap.safe.model.CustomerRegistrationRecord;
import com.safe.hsap.safe.model.MembershipPK;
import com.safe.hsap.safe.model.Passenger;

@Repository
public interface CustomerRepository extends JpaRepository < Customer, Long > {
	@Query("select count(*) from Customer a where a.custEmail =:custEmail")
	public int customerRecordExist(@Param("custEmail") String custEmail);
	
	@Query("select custId from Customer a where a.custEmail =:custEmail")
	public int getCustId(@Param("custEmail") String custEmail);
	
	@Query("select b.passenger from Customer b where b.custEmail =:custEmail")
	public Passenger getPassengerRecordEmail(@Param("custEmail") String custEmail);
	
	@Query("select count(*) from Membership a where a.mem_id =:mem_id")
	public int memershipRecordExist(@Param("mem_id") MembershipPK mem_id);
	
	@Query("select count(*) from BookingAgent a where a.ba_id =:ba_id")
	public int bookingAgentRecordExist(@Param("ba_id") BookingAgentPK ba_id);
	
	@Query("Select new com.safe.hsap.safe.model.CustomerRegistrationRecord("+
            "a.pId,"+
			"a.pType,"+
			"a.pDob,"+
			"a.pFname,"+
			"a.pLname,"+
			"a.pGender,"+
			"a.pNationality,"+
			"a.pPassExpiry,"+
			"a.pPassportNo,"+
			"a.custId,"+
			"a.aptNo,"+
			"a.city,"+
			"a.contactNum,"+
			"a.countryCode,"+
			"a.custEmail,"+
			"a.cstState,"+
			"a.cType,"+
			"a.emerContactFname,"+
			"a.emerContactLname,"+
			"a.street,"+
			"a.zip,"+
			"a.assoAirline,"+
			"a.memName,"+
			"a.memStdate,"+
			"a.memEnddate,"+
			"a.baContNo,"+
			"a.baName,"+
			"a.baWebadd)"+ 
			"from CustomerRegistrationV a where a.custEmail =:custEmail")
	public List<CustomerRegistrationRecord> GetCustomerRegiration(@Param("custEmail") String custEmail);
	
	@Query("Select new com.safe.hsap.safe.model.CustomerRegistrationRecord("+
            "a.pId,"+
			"a.pType,"+
			"a.pDob,"+
			"a.pFname,"+
			"a.pLname,"+
			"a.pGender,"+
			"a.pNationality,"+
			"a.pPassExpiry,"+
			"a.pPassportNo,"+
			"a.custId,"+
			"a.aptNo,"+
			"a.city,"+
			"a.contactNum,"+
			"a.countryCode,"+
			"a.custEmail,"+
			"a.cstState,"+
			"a.cType,"+
			"a.emerContactFname,"+
			"a.emerContactLname,"+
			"a.street,"+
			"a.zip,"+
			"a.assoAirline,"+
			"a.memName,"+
			"a.memStdate,"+
			"a.memEnddate,"+
			"a.baContNo,"+
			"a.baName,"+
			"a.baWebadd)"+ 
			"from CustomerRegistrationV a")
	public List<CustomerRegistrationRecord> GetCustomerRegirationAll();
	
	@Modifying
	@Transactional
	@Query("update Passenger a set a.passengerDob =:pDob, a.passengerFirstName =:pFname, a.passengerLastName = :pLname, a.passengerGender=:pGender,a.passengerNationality =:pNationality, a.passengerPassportExpiry =:pPassExpiry, a.passengerPassportNo = :pPassportNo where a.pId =:pId")
	public void updatePassengerDetails(@Param("pId") int pId,@Param("pDob") Date pDob,@Param("pFname") String pFname,@Param("pLname") String pLname,@Param("pGender") String pGender,@Param("pNationality") String pNationality,@Param("pPassExpiry") Date pPassExpiry,@Param("pPassportNo") String pPassportNo);
	
	@Modifying
	@Transactional
	@Query("update  Customer a set a.aptNo =:aptNo, a.city =:city, a.contactNum = :contactNum, a.countryCodePhone=:countryCode,a.custEmail =:custEmail, a.custState =:cstState, a.customerType = :cType, a.emergencyContactFirstName=:emerContactFname,a.emergencyContactLasttName =:emerContactLname, a.street =:street, a.zip = :zip where a.custId =:custId")
	public void updateCustomerDetails(@Param("custId") int custId,@Param("aptNo") String aptNo,@Param("city") String city,@Param("contactNum") String contactNum,@Param("countryCode") int countryCode,@Param("custEmail") String custEmail,@Param("cstState") String cstState,@Param("cType") String cType,@Param("emerContactFname") String emerContactFname,@Param("emerContactLname") String emerContactLname,@Param("street") String street,@Param("zip") int zip);
	
	@Modifying
	@Transactional
	@Query("update BookingAgent a set a.bookingAgentContactNo =:baContNo, a.bookingAgentName =:baName, a.bookingAgentWebAdd = :baWebadd where a.ba_id =:ba_id")
	public void updateBookingAgentDetails(@Param("ba_id") BookingAgentPK ba_id,@Param("baContNo") String baContNo,@Param("baName") String baName,@Param("baWebadd") String baWebadd);
	
	@Modifying
	@Transactional
	@Query("update Membership a set a.assoicatedAirline =:assoAirline, a.membershipName =:memName, a.membershipStartDate=:memStdate, a.membershipEndtDate=:memEnddate where a.mem_id =:mem_id")
	public void updateMembershipDetails(@Param("mem_id") MembershipPK mem_id,@Param("assoAirline") String assoAirline,@Param("memName") String memName,@Param("memStdate") Date memStdate,@Param("memEnddate") Date memEnddate);

}
