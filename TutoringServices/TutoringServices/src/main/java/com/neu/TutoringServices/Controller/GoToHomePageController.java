package com.neu.TutoringServices.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neu.TutoringServices.Pojo.User;

@Controller
public class GoToHomePageController {

	@RequestMapping(value ="/redirect.htm",  method= RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result
			,HttpServletRequest request) {
		
		return "Redirect";
	}
}
