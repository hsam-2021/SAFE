package com.safe.hsap.safe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.safe.hsap.safe.model.LoginUserDetailRecord;
import com.safe.hsap.safe.repository.CabinClassRepository;
import com.safe.hsap.safe.repository.FlightDetailsRepository;
import com.safe.hsap.safe.repository.MealPlanRepository;
import com.safe.hsap.safe.repository.PlanDetailsRepository;
import com.safe.hsap.safe.repository.SpecialRequestRepository;
import com.safe.hsap.safe.service.ICreateCustomerRegiration;

@CrossOrigin
@Controller
public class safeViewController {

	@Autowired
	ICreateCustomerRegiration createCustomerRegiration;

	@Autowired
	MealPlanRepository mealPlanRepository;

	@Autowired
	SpecialRequestRepository specialRequestRepository;

	@Autowired
	CabinClassRepository cabinClassRepository;

	@Autowired
	PlanDetailsRepository planDetailsRepository;

	@Autowired
	FlightDetailsRepository flightDetailsRepository;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String viewLoginPage() {
		return "login";
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView customerRegistrationPage(HttpServletRequest req) {
		ModelAndView model = null;
		int existingCust = createCustomerRegiration.getCustomerRecordExist(req.getRemoteUser());
		if (existingCust == 0) {
			model = new ModelAndView();
			model.setViewName("customerRegistration");
			LoginUserDetailRecord loginUserDetailRecord = createCustomerRegiration
					.getLoginUserDetails(req.getRemoteUser());
			model.addObject("firstname", loginUserDetailRecord.getFirstName());
			model.addObject("lastname", loginUserDetailRecord.getLastName());
			model.addObject("email", loginUserDetailRecord.getEmails());
		} else {
			model = new ModelAndView();
			model.setViewName("safeLandingPage");
		}
		return model;
	}

	@RequestMapping(path = "/safeLandingPage", method = RequestMethod.GET)
	public String safeLandingPage() {
		return "safeLandingPage";
	}

	@RequestMapping(path = "/customerDetails", method = RequestMethod.GET)
	public String customerDetails() {
		return "customerDetails";
	}

	@RequestMapping(path = "/loginRegistrationComplete", method = RequestMethod.GET)
	public String loginRegistrationCompletePage() {
		return "loginRegistrationComplete";
	}

	@RequestMapping(path = "/purchasePlan", method = RequestMethod.POST)
	public ModelAndView purchasePlan(HttpServletRequest req) {
		ModelAndView model = new ModelAndView();
		model.setViewName("purchasePlan");
		model.addObject("mealPlan", mealPlanRepository.findAll());
		model.addObject("cabin", cabinClassRepository.findAll());
		model.addObject("speicalRequest", specialRequestRepository.findAll());
		model.addObject("planDetails", planDetailsRepository.findAll());
		model.addObject("flightDetails", flightDetailsRepository.findAll());

		return model;
	}

	@RequestMapping(path = "/purchasePlanTransaction", method = RequestMethod.GET)
	public String purchasePlanTransaction() {
		return "purchasePlanTransaction";
	}
}
