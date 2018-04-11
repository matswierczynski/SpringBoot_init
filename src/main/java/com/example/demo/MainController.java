package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path="/form", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("form", new UserFormDTO());
		return "form";
	}
	
	@RequestMapping(path="/form", method=RequestMethod.POST)
	public String handleForm(@ModelAttribute("form") @Valid UserFormDTO form, BindingResult result) {
		if(result.hasErrors())
			return "form";
		else { 
			User n = new User();
		n.setName(form.getName());
		n.setEmail(form.getEmail());
		userRepository.save(n);
			return "afterForm";
		}
	}
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}

}
