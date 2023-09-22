package com.safe.hsap.safe.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.safe.hsap.domainobjects.services.AddPassengerRequest;
import com.safe.hsap.domainobjects.services.CustomerRegiration;
import com.safe.hsap.domainobjects.services.CustomerRegirationStatus;
import com.safe.hsap.domainobjects.services.CustomerRegistrationUpdate;
import com.safe.hsap.domainobjects.services.CustomerRegistrationUpdateStatus;
import com.safe.hsap.domainobjects.services.DeletePassengerRequest;
import com.safe.hsap.domainobjects.services.PlanTransactionSaveRequest;
import com.safe.hsap.domainobjects.services.PlanTransactionSaveResponse;
import com.safe.hsap.domainobjects.services.UpdatePassengerRequest;
import com.safe.hsap.safe.model.CustomerRegistrationRecord;
import com.safe.hsap.safe.model.LoginUserDetailRecord;
import com.safe.hsap.safe.model.PassengerRecords;
import com.safe.hsap.safe.model.TransactionRecordsV;

public interface ICreateCustomerRegiration {

	public int getCustomerRecordExist(String customerEmail);

	public List<PassengerRecords> getPassengerRecords(String customerEmail);

	public LoginUserDetailRecord getLoginUserDetails(String customerEmail);

	public CustomerRegirationStatus CreateCustomerRegiration(CustomerRegiration customerRegiration);

	public List<CustomerRegistrationRecord> GetCustomerRegiration(String customerEmail);

	public CustomerRegistrationUpdateStatus UpdateCustomerRegiration(
			CustomerRegistrationUpdate customerRegirationUpdate);

	public ResponseEntity<String> addPassenger(AddPassengerRequest addPassengerRequest);

	public ResponseEntity<String> deletePassenger(DeletePassengerRequest deletePassengerRequest);

	public ResponseEntity<String> updatePassengerRecord(UpdatePassengerRequest updatePassengerRequest);

	public int purchasePlanCount(String customerEmail);

	public PlanTransactionSaveResponse createTransaction(PlanTransactionSaveRequest planTransactionSaveRequest);

	public List<TransactionRecordsV> getTransactionDetails(String custEmail);
}
