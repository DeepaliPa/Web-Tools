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
import com.neu.TutoringServices.Exception.AdException;
import com.neu.TutoringServices.Pojo.User;

@Controller
public class ViewGetController {
	
	
	
	@RequestMapping(value ="/viewTutors.htm",method = RequestMethod.GET)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request) throws Exception {
		

		UserDAO userDao = new UserDAO();
		List list = new ArrayList();
	    list=userDao.getList("Tutor");
		request.getSession().setAttribute("listValue",list);
		return "ViewStudent";
		// DAO.close();

		
	}

}
