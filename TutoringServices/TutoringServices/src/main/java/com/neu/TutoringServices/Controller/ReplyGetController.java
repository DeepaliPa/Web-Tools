package com.neu.TutoringServices.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.TutoringServices.Pojo.Messages;
import com.neu.TutoringServices.Pojo.User;

@Controller
public class ReplyGetController {
	
	@RequestMapping(value ="/reply.htm",  method= RequestMethod.GET)
	public String initializeForm(@ModelAttribute("messages") Messages messages, BindingResult result
			,HttpServletRequest request) {
		
		 String toUser = request.getParameter("toUser");
		 
		 HttpSession session = request.getSession();
		 session.setAttribute("toUser", toUser);

		return "Reply";
	}

}
