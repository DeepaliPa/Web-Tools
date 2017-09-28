package com.neu.TutoringServices.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.TutoringServices.Dao.UserDAO;
import com.neu.TutoringServices.Pojo.User;

@Controller
public class ViewStudentDetailsController {
	
	@RequestMapping(value ="/viewStudent.htm",method = RequestMethod.GET)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request) throws Exception {
		

		UserDAO userDao = new UserDAO();
		List list = new ArrayList();
	    list=userDao.getList("Student");
		request.getSession().setAttribute("listValue",list);
		return "View";
		// DAO.close();

		
	}

}
