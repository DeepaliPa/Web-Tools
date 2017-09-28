package com.neu.TutoringServices.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.TutoringServices.Pojo.User;

@Controller
//@RequestMapping("/registrationGet.htm")
public class RegistrationGetController {
	String category;
	String subCategory;
	String requestInfo;
	String additionalInfo;

	@RequestMapping(value ="/registrationGet.htm",  method= RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result
			,HttpServletRequest request) {
		
		
			String action = request.getParameter("action");
			System.out.println("action------>" + action);
			HttpSession session = request.getSession();
			session.setAttribute("action", action);
		 
			 if(action.equalsIgnoreCase("requestPage")){
				 
			category= request.getParameter("category");
			subCategory=request.getParameter("subCategory");
			requestInfo=request.getParameter("requestInfo");
			additionalInfo=request.getParameter("additionalInfo");
			System.out.println("---------------------------------------------" + category + " " + subCategory + " " + requestInfo + " " + additionalInfo);
			List<String> listVal= new ArrayList<String>();
			listVal.add(category);
			listVal.add(subCategory);
			listVal.add(requestInfo);
			listVal.add(additionalInfo);
			session.setAttribute("listVal", listVal);
			
			 }

		return "registration";
	}

	
}
