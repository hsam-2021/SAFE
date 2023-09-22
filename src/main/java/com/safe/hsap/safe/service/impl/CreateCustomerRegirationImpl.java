package com.safe.hsap.safe.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.safe.hsap.domainobjects.services.AddPassengerRequest;
import com.safe.hsap.domainobjects.services.CustomerRegiration;
import com.safe.hsap.domainobjects.services.CustomerRegirationStatus;
import com.safe.hsap.domainobjects.services.CustomerRegistrationUpdate;
import com.safe.hsap.domainobjects.services.CustomerRegistrationUpdateStatus;
import com.safe.hsap.domainobjects.services.DeletePassengerRequest;
import com.safe.hsap.domainobjects.services.PlanTransactionSaveRequest;
import com.safe.hsap.domainobjects.services.PlanTransactionSaveResponse;
import com.safe.hsap.domainobjects.services.UpdatePassengerRequest;
import com.safe.hsap.safe.model.BookingAgent;
import com.safe.hsap.safe.model.BookingAgentPK;
import com.safe.hsap.safe.model.CustPlanDetails;
import com.safe.hsap.safe.model.Customer;
import com.safe.hsap.safe.model.CustomerPassengerMapping;
import com.safe.hsap.safe.model.CustomerRegistrationRecord;
import com.safe.hsap.safe.model.InvoiceDetails;
import com.safe.hsap.safe.model.InvoicePayment;
import com.safe.hsap.safe.model.Itinerary;
import com.safe.hsap.safe.model.LoginUserDetailRecord;
import com.safe.hsap.safe.model.Membership;
import com.safe.hsap.safe.model.MembershipPK;
import com.safe.hsap.safe.model.Passenger;
import com.safe.hsap.safe.model.PassengerRecords;
import com.safe.hsap.safe.model.TransactionRecordsV;
import com.safe.hsap.safe.repository.BookingAgentRepository;
import com.safe.hsap.safe.repository.CustPlanDetailsRepository;
import com.safe.hsap.safe.repository.CustomerPassengerMapRepository;
import com.safe.hsap.safe.repository.CustomerRepository;
import com.safe.hsap.safe.repository.InvoiceDetailsRepository;
import com.safe.hsap.safe.repository.InvoicePaymentRepository;
import com.safe.hsap.safe.repository.ItineraryRepository;
import com.safe.hsap.safe.repository.MembershipRepository;
import com.safe.hsap.safe.repository.PassengerRepository;
import com.safe.hsap.safe.repository.UserRepository;
import com.safe.hsap.safe.service.ICreateCustomerRegiration;

@Component
public class CreateCustomerRegirationImpl implements ICreateCustomerRegiration {
	private static final Logger LOG = LoggerFactory.getLogger(CreateCustomerRegirationImpl.class);

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	MembershipRepository membershipRepository;

	@Autowired
	BookingAgentRepository bookingAgentRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CustomerPassengerMapRepository customerPassengerMapRepository;

	@Autowired
	CustPlanDetailsRepository custPlanDetailsRepository;

	@Autowired
	InvoiceDetailsRepository invoiceDetailsRepository;

	@Autowired
	InvoicePaymentRepository invoicePaymentRepository;

	@Autowired
	ItineraryRepository itineraryRepository;

	public int getCustomerRecordExist(String customerEmail) {
		return customerRepository.customerRecordExist(customerEmail);
	}

	public List<PassengerRecords> getPassengerRecords(String customerEmail) {
		int custId = customerRepository.getCustId(customerEmail);
		return passengerRepository.getPassengerRecords(custId);
	}

	public int purchasePlanCount(String customerEmail) {
		int custId = customerRepository.getCustId(customerEmail);
		return passengerRepository.purchasePlanCount(custId);
	}

	public LoginUserDetailRecord getLoginUserDetails(String customerEmail) {
		return userRepository.getLoginUserDetails(customerEmail);
	}

	@Transactional
	public CustomerRegirationStatus CreateCustomerRegiration(CustomerRegiration customerRegiration) {
		CustomerRegirationStatus customerRegirationStatus = null;
		if (customerRegiration != null) {

			Passenger passenger = null;
			Customer customer = null;
			Membership membership = null;
			BookingAgent bookingAgent = null;
			try {
				/* save passenger record */
				passenger = new Passenger();
				passenger.setPassengerFirstName(customerRegiration.getPassengerFirstName());
				passenger.setPassengerLastName(customerRegiration.getPassengerLastName());
				passenger.setPassengerDob(customerRegiration.getPassengerDob());
				passenger.setPassengerGender(customerRegiration.getPassengerGender());
				passenger.setPassengerNationality(customerRegiration.getPassengerNationality());
				passenger.setPassengerPassportNo(customerRegiration.getPassengerPassportNo());
				passenger.setPassengerPassportExpiry(customerRegiration.getPassengerPassportExpiry());
				passenger.setPassengerType(customerRegiration.getPassengerType());
				// passengerRepository.save(passenger);

				/* save customer record */
				customer = new Customer();
				customer.setAptNo(customerRegiration.getAptno());
				customer.setCity(customerRegiration.getCity());
				customer.setContactNum(customerRegiration.getContactNum());
				customer.setCountry(customerRegiration.getCountry());
				customer.setCountryCodePhone(customerRegiration.getCountryCodePhone());
				customer.setCustEmail(customerRegiration.getCustEmail());
				customer.setCustomerType(customerRegiration.getCustomerType());
				customer.setCustState(customerRegiration.getCustState());
				customer.setEmergencyContactFirstName(customerRegiration.getEmergencyContactFirstName());
				customer.setEmergencyContactLasttName(customerRegiration.getEmergencyContactLastName());
				customer.setEmergencyContactNum(customerRegiration.getEmergencyContactNum());
				customer.setStreet(customerRegiration.getStreet());
				customer.setZip(customerRegiration.getZip());
				passenger.setCustomer(customer);
				customer.setPassenger(passenger);
				passenger = passengerRepository.save(passenger);
				passengerRepository.flush();

				/* save mapping record */
				CustomerPassengerMapping customerPassengerMapping = new CustomerPassengerMapping();
				customerPassengerMapping.setpId(passenger.getpId());
				customerPassengerMapping.setCustId(customerRepository.getCustId(customerRegiration.getCustEmail()));
				customerPassengerMapRepository.save(customerPassengerMapping);

				/* save membership record */
				if ((customerRegiration.getCustomerType()).equals("M")) {
					membership = new Membership();
					membership.setAssoicatedAirline(customerRegiration.getAssoicatedAirline());
					MembershipPK membershipPK = new MembershipPK();
					membershipPK.setPassenger(
							customerRepository.getPassengerRecordEmail(customerRegiration.getCustEmail()));
					membership.setMem_id(membershipPK);
					membership.setMembershipName(customerRegiration.getMembershipname());
					membership.setMembershipEndtDate(customerRegiration.getMembershipEndtDate());
					membership.setMembershipStartDate(customerRegiration.getMembershipEndtDate());
					membershipRepository.save(membership);
				}

				/* save booking agent record */
				if ((customerRegiration.getCustomerType()).equals("A")) {
					bookingAgent = new BookingAgent();
					BookingAgentPK bookingAgentPK = new BookingAgentPK();
					bookingAgentPK.setPassenger(
							customerRepository.getPassengerRecordEmail(customerRegiration.getCustEmail()));
					bookingAgent.setBa_id(bookingAgentPK);
					bookingAgent.setBookingAgentContactNo(customerRegiration.getBookingAgentContactNo());
					bookingAgent.setBookingAgentName(customerRegiration.getBookingAgentName());
					bookingAgent.setBookingAgentWebAdd(customerRegiration.getBookingAgentWebAdd());
					bookingAgentRepository.save(bookingAgent);
				}
				customerRegirationStatus = new CustomerRegirationStatus();
				customerRegirationStatus.setStatusCode(200);
				customerRegirationStatus.setStatusMessage("Customer account created successfully");
			} catch (Exception e) {
				customerRegirationStatus = new CustomerRegirationStatus();
				customerRegirationStatus.setStatusCode(400);
				customerRegirationStatus
						.setStatusMessage("Exception Occured while creating customer records " + e.getMessage());
				LOG.error("Exception Occured while creating customer records :" + e.getMessage());
			}
		} else {
			customerRegirationStatus = new CustomerRegirationStatus();
			customerRegirationStatus.setStatusCode(400);
			customerRegirationStatus.setStatusMessage("No records to create");
			LOG.error("No records to create");
		}

		return customerRegirationStatus;
	}

	public List<CustomerRegistrationRecord> GetCustomerRegiration(String customerEmail) {
		if (customerEmail.equals("admin@safe.com")) {
			return customerRepository.GetCustomerRegirationAll();
		} else {
			return customerRepository.GetCustomerRegiration(customerEmail);
		}

	}

	@Transactional
	public CustomerRegistrationUpdateStatus UpdateCustomerRegiration(
			CustomerRegistrationUpdate customerRegirationUpdate) {
		CustomerRegistrationUpdateStatus customerRegirationUpdateStatus = null;

		if (customerRegirationUpdate != null) {

			try {
				/* Update Passenger */

				customerRepository.updatePassengerDetails(customerRegirationUpdate.getpId(),
						customerRegirationUpdate.getPassengerDob(), customerRegirationUpdate.getPassengerFirstName(),
						customerRegirationUpdate.getPassengerLastName(), customerRegirationUpdate.getPassengerGender(),
						customerRegirationUpdate.getPassengerNationality(),
						customerRegirationUpdate.getPassengerPassportExpiry(),
						customerRegirationUpdate.getPassengerPassportNo());
				/* Update Customer */
				customerRepository.updateCustomerDetails(customerRegirationUpdate.getCustId(),
						customerRegirationUpdate.getAptno(), customerRegirationUpdate.getCity(),
						customerRegirationUpdate.getContactNum(), customerRegirationUpdate.getCountryCodePhone(),
						customerRegirationUpdate.getCustEmail(), customerRegirationUpdate.getCustState(),
						customerRegirationUpdate.getCustomerType(),
						customerRegirationUpdate.getEmergencyContactFirstName(),
						customerRegirationUpdate.getEmergencyContactLastName(), customerRegirationUpdate.getStreet(),
						customerRegirationUpdate.getZip());
				/* Update Membership */

				MembershipPK membershipPK = new MembershipPK();
				membershipPK.setPassenger(passengerRepository.getPassenger(customerRegirationUpdate.getpId()));
				if (customerRepository.memershipRecordExist(membershipPK) > 0) {
					customerRepository.updateMembershipDetails(membershipPK,
							customerRegirationUpdate.getAssoicatedAirline(),
							customerRegirationUpdate.getMembershipname(),
							customerRegirationUpdate.getMembershipEndtDate(),
							customerRegirationUpdate.getMembershipEndtDate());
				}

				/* Update Booking Agent */
				BookingAgentPK bookingAgentPK = new BookingAgentPK();
				bookingAgentPK.setPassenger(passengerRepository.getPassenger(customerRegirationUpdate.getpId()));
				if (customerRepository.bookingAgentRecordExist(bookingAgentPK) > 0) {
					customerRepository.updateBookingAgentDetails(bookingAgentPK,
							customerRegirationUpdate.getBookingAgentContactNo(),
							customerRegirationUpdate.getBookingAgentName(),
							customerRegirationUpdate.getBookingAgentWebAdd());
				}

				customerRegirationUpdateStatus = new CustomerRegistrationUpdateStatus();
				customerRegirationUpdateStatus.setStatusCode(200);
				customerRegirationUpdateStatus.setStatusMessage("Customer account updated successfully");

			} catch (Exception e) {
				customerRegirationUpdateStatus = new CustomerRegistrationUpdateStatus();
				customerRegirationUpdateStatus.setStatusCode(400);
				customerRegirationUpdateStatus
						.setStatusMessage("Exception Occured while updating customer records " + e.getMessage());
				LOG.error("Exception Occured while updating customer records :" + e.getMessage());
			}

		} else {
			customerRegirationUpdateStatus = new CustomerRegistrationUpdateStatus();
			customerRegirationUpdateStatus.setStatusCode(400);
			customerRegirationUpdateStatus.setStatusMessage("No records to update");
			LOG.error("No records to update");
		}

		return customerRegirationUpdateStatus;
	}

	@Transactional
	public ResponseEntity<String> addPassenger(AddPassengerRequest addPassengerRequest) {

		Passenger passenger = null;
		String message;
		if (addPassengerRequest != null) {
			try {
				passenger = new Passenger();
				passenger.setPassengerFirstName(addPassengerRequest.getFname());
				passenger.setPassengerLastName(addPassengerRequest.getLname());
				passenger.setPassengerDob(addPassengerRequest.getDob());
				passenger.setPassengerGender(addPassengerRequest.getGender());
				passenger.setPassengerNationality(addPassengerRequest.getNationality());
				passenger.setPassengerPassportNo(addPassengerRequest.getPassportNo());
				passenger.setPassengerPassportExpiry(addPassengerRequest.getPassExpiry());
				passenger.setPassengerType("P");
				passenger = passengerRepository.save(passenger);
				passengerRepository.flush();
				/* save mapping record */
				CustomerPassengerMapping customerPassengerMapping = new CustomerPassengerMapping();
				customerPassengerMapping.setpId(passenger.getpId());
				customerPassengerMapping.setCustId(customerRepository.getCustId(addPassengerRequest.getCustEmail()));
				customerPassengerMapRepository.save(customerPassengerMapping);
				message = "Passenger Added Successfully";
			} catch (Exception e) {
				message = "Error Adding Passenger " + e.getMessage();
			}
		} else {
			message = "No Passenger Records to add";
		}
		return ResponseEntity.ok().body(message);

	}

	@Transactional
	public ResponseEntity<String> deletePassenger(DeletePassengerRequest deletePassengerRequest) {
		String message;
		if (deletePassengerRequest != null) {
			try {

				passengerRepository.deletePassengerFromMapping(deletePassengerRequest.getpId());
				passengerRepository.deletePassengerRecord(deletePassengerRequest.getpId());
				message = "Passenger Deleted Successfully";
			} catch (Exception e) {
				message = "Error Deleting Passenger " + e.getMessage();
			}
		} else {
			message = "No Passenger Records to delete";
		}
		return ResponseEntity.ok().body(message);
	}

	@Transactional
	public ResponseEntity<String> updatePassengerRecord(UpdatePassengerRequest updatePassengerRequest) {
		String message;

		if (updatePassengerRequest != null) {
			try {

				passengerRepository.updatePassengerRecord(updatePassengerRequest.getpId(),
						updatePassengerRequest.getFname(), updatePassengerRequest.getLname(),
						updatePassengerRequest.getGender(), updatePassengerRequest.getNationality(),
						updatePassengerRequest.getPassportNo(), updatePassengerRequest.getDob(),
						updatePassengerRequest.getPassExpiry());
				message = "Passenger updated Successfully";
			} catch (Exception e) {
				message = "Error Updating Passenger " + e.getMessage();
			}

		} else {
			message = "No Passenger Records to update";
		}

		return ResponseEntity.ok().body(message);
	}

	@Transactional
	public PlanTransactionSaveResponse createTransaction(PlanTransactionSaveRequest planTransactionSaveRequest) {
		PlanTransactionSaveResponse planTransactionSaveResponse = null;
		CustPlanDetails custPlanDetails = null;
		InvoiceDetails invoiceDetails = null;
		InvoicePayment invoicePayment = null;
		Itinerary itinerary = null;
		int totalPlanCost = 0;

		if (planTransactionSaveRequest != null) {

			try {
				int custId = customerRepository.getCustId(planTransactionSaveRequest.getCustEmail());
				if (planTransactionSaveRequest.getPlanid().size() > 0) {
					for (int planId : planTransactionSaveRequest.getPlanid()) {
						custPlanDetails = new CustPlanDetails();
						custPlanDetails.setCustId(custId);
						custPlanDetails.setPlanId(planId);
						custPlanDetails.setSelectDate(new Date());
						totalPlanCost = totalPlanCost + custPlanDetailsRepository.getPlanCost(planId);
						custPlanDetailsRepository.save(custPlanDetails);
					}

					invoiceDetails = new InvoiceDetails();
					invoiceDetails.setInvAmt(totalPlanCost);
					invoiceDetails.setCustId(custId);
					invoiceDetails.setInvDate(new Date());
					invoiceDetails = invoiceDetailsRepository.save(invoiceDetails);
					invoiceDetailsRepository.flush();

					invoicePayment = new InvoicePayment();
					invoicePayment.setCardExpiry(planTransactionSaveRequest.getCardExpiry());
					invoicePayment.setCardFname(planTransactionSaveRequest.getCfname());
					invoicePayment.setCardLname(planTransactionSaveRequest.getClname());
					invoicePayment.setCardMname(planTransactionSaveRequest.getCmname());
					invoicePayment.setCardNo(planTransactionSaveRequest.getCardnum());
					invoicePayment.setInvNum(invoiceDetails.getInvNum());
					invoicePayment.setPayType(planTransactionSaveRequest.getCardtype());
					invoicePayment.setPmtAmt(totalPlanCost);
					invoicePayment.setPmtDate(new Date());
					invoicePaymentRepository.save(invoicePayment);
				}

				if (passengerRepository.getPassengerId(custId).size() > 0) {
					for (int pId : passengerRepository.getPassengerId(custId)) {
						itinerary = new Itinerary();
						itinerary.setCabinId(planTransactionSaveRequest.getCabinid());
						itinerary.setFlId(planTransactionSaveRequest.getFlDetailid());
						itinerary.setMealId(planTransactionSaveRequest.getMealid());
						itinerary.setpId(pId);
						itinerary.setpType("P");
						itinerary.setReqId(planTransactionSaveRequest.getSpeRequestid());
						itineraryRepository.save(itinerary);
					}
				}

				planTransactionSaveResponse = new PlanTransactionSaveResponse();
				planTransactionSaveResponse.setStatusCode(200);
				planTransactionSaveResponse.setStatusMessage("Transaction Completed Successfully.Total Cost $"
						+ totalPlanCost + " charges from your account");

			} catch (Exception e) {
				planTransactionSaveResponse = new PlanTransactionSaveResponse();
				planTransactionSaveResponse.setStatusCode(400);
				planTransactionSaveResponse.setStatusMessage("Exception Occured while transaction " + e.getMessage());
				LOG.error("Exception Occured while transaction :" + e.getMessage());
			}

		} else {
			planTransactionSaveResponse = new PlanTransactionSaveResponse();
			planTransactionSaveResponse.setStatusCode(200);
			planTransactionSaveResponse.setStatusMessage("No transaction record to update");
		}

		return planTransactionSaveResponse;
	}

	public List<TransactionRecordsV> getTransactionDetails(String custEmail) {
		if (custEmail.equals("admin@safe.com")) {
			return passengerRepository.getAllTransactionDetails();
		} else {
			return passengerRepository.getTransactionDetails(customerRepository.getCustId(custEmail));
		}
	}

}
