package com.safe.hsap.safe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.safe.hsap.safe.config.UserRegistrationDto;
import com.safe.hsap.safe.model.User;
import com.safe.hsap.safe.service.UserService;

@CrossOrigin
@Controller
@RequestMapping("/loginRegistration")
public class UserRegistrationController {
	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		return "loginRegistration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
			BindingResult result) {

		User existing = userService.findByEmail(userDto.getEmail());
		if (existing != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}

		if (result.hasErrors()) {
			return "loginRegistration";
		}

		userService.save(userDto);
		return "redirect:/loginRegistrationComplete";
	}
}
