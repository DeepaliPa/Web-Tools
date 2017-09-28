package com.neu.TutoringServices.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.TutoringServices.Dao.MessageDAO;
import com.neu.TutoringServices.Exception.AdException;
import com.neu.TutoringServices.Pojo.Messages;

@Controller
public class ReceiveReplyController {
	
	
	@RequestMapping(value ="/sendMessage.htm",  method= RequestMethod.POST)
	public String initializeForm(@ModelAttribute("messages") Messages messages, BindingResult result
			,HttpServletRequest request) throws AdException {
		
		 String toUser = request.getParameter("to");
		 String from = request.getParameter("from");
		 String message = request.getParameter("message");
		 
		 MessageDAO messageDAO= new MessageDAO();
		 messageDAO.create(toUser, from, message);
		 

		return "Redirect";
	}

}
