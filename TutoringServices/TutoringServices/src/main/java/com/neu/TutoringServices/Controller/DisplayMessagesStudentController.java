package com.neu.TutoringServices.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.TutoringServices.Dao.MessageDAO;
import com.neu.TutoringServices.Pojo.Messages;


@Controller
public class DisplayMessagesStudentController {
	
	@RequestMapping(value ="/messagesStudents.htm",method = RequestMethod.GET)
	protected String  doSubmitAction(@ModelAttribute("messages") Messages messages, HttpServletRequest request) throws Exception {
		
		MessageDAO messageDAO = new MessageDAO();
		List list = new ArrayList();

	    list=messageDAO.getList(String.valueOf(request.getSession().getAttribute("usernameVal")));
		request.getSession().setAttribute("listValue",list);

		
	return "MessagesDisplay";
		
	}
	

}
