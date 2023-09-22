package com.safe.hsap.safe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
import com.safe.hsap.safe.service.ICreateCustomerRegiration;

@CrossOrigin
@RestController
@RequestMapping("/safe/v1")
@ResponseBody
public class safeController {

	@Autowired
	ICreateCustomerRegiration createCustomerRegiration;

	@RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
	public ResponseEntity<String> getRtlsApiResponse() {
		return new ResponseEntity<>("I am Alive", HttpStatus.OK);
	}

	@RequestMapping(value = "/getLoginUserDetails", method = RequestMethod.GET)
	public LoginUserDetailRecord getLoginUserDetails(@RequestParam String customerEmail) {
		return createCustomerRegiration.getLoginUserDetails(customerEmail);
	}

	@RequestMapping(value = "/customerRecordExist", method = RequestMethod.GET)
	public int getCustomerRecordExist(@RequestParam String customerEmail) {
		return createCustomerRegiration.getCustomerRecordExist(customerEmail);
	}

	@RequestMapping(value = "/CreateCustomerRegistration", method = RequestMethod.POST)
	public CustomerRegirationStatus CreateCustomerRegiration(@RequestBody CustomerRegiration customerRegiration) {
		return createCustomerRegiration.CreateCustomerRegiration(customerRegiration);
	}

	@RequestMapping(value = "/GetCustomerRegistration", method = RequestMethod.GET)
	public List<CustomerRegistrationRecord> GetCustomerRegiration(
			@RequestParam(value = "userId") String customerEmail) {
		return createCustomerRegiration.GetCustomerRegiration(customerEmail);
	}

	@RequestMapping(value = "/UpdateCustomerRegistration", method = RequestMethod.POST)
	public CustomerRegistrationUpdateStatus UpdateCustomerRegiration(
			@RequestBody CustomerRegistrationUpdate customerRegirationUpdate) {
		return createCustomerRegiration.UpdateCustomerRegiration(customerRegirationUpdate);
	}

	@RequestMapping(value = "/getPassengerDetails", method = RequestMethod.GET)
	public List<PassengerRecords> getPassengerRecords(@RequestParam(value = "userId") String customerEmail) {
		return createCustomerRegiration.getPassengerRecords(customerEmail);
	}

	@RequestMapping(value = "/addPassenger", method = RequestMethod.POST)
	public ResponseEntity<String> addPassenger(@RequestBody AddPassengerRequest addPassengerRequest) {
		return createCustomerRegiration.addPassenger(addPassengerRequest);
	}

	@RequestMapping(value = "/deletePassenger", method = RequestMethod.POST)
	public ResponseEntity<String> deletePassenger(@RequestBody DeletePassengerRequest deletePassengerRequest) {
		return createCustomerRegiration.deletePassenger(deletePassengerRequest);
	}

	@RequestMapping(value = "/updatePassengerRecord", method = RequestMethod.POST)
	public ResponseEntity<String> updatePassengerRecord(@RequestBody UpdatePassengerRequest updatePassengerRequest) {
		return createCustomerRegiration.updatePassengerRecord(updatePassengerRequest);
	}

	@RequestMapping(value = "/createTransaction", method = RequestMethod.POST)
	public PlanTransactionSaveResponse createTransaction(
			@RequestBody PlanTransactionSaveRequest planTransactionSaveRequest) {
		return createCustomerRegiration.createTransaction(planTransactionSaveRequest);
	}

	@RequestMapping(value = "/getTransactionDetails", method = RequestMethod.GET)
	public List<TransactionRecordsV> getTransactionDetails(@RequestParam String custEmail) {
		return createCustomerRegiration.getTransactionDetails(custEmail);
	}
}
