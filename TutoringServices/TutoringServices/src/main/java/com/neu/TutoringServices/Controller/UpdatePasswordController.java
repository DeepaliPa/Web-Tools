package com.neu.TutoringServices.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.TutoringServices.Dao.UserDAO;
import com.neu.TutoringServices.Exception.AdException;
import com.neu.TutoringServices.Pojo.Intermediate;
import com.neu.TutoringServices.Pojo.User;

@Controller
public class UpdatePasswordController {

	@RequestMapping(value ="/updatePassword.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request) throws Exception
	{
			String username= (String) request.getSession().getAttribute("usernameVal");
		UserDAO userDao = new UserDAO();
		String newPassword=request.getParameter("newPassword");
		String oldPassword=request.getParameter("oldPassword");
		System.out.println("newPassword Before updating------>" +newPassword);
		User u =userDao.getUserObject(username);
		System.out.println("newPassword Before updating------>" +u.getPassword());
		u.setPassword(newPassword);
		User u1= userDao.update(u);
		System.out.println("newPassword After updating --->" + u1.getPassword());
		
		return "successful";
	}
}
