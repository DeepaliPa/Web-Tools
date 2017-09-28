package com.neu.TutoringServices.Controller;

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
public class MyAccountController {

	
	@RequestMapping(value ="/myaccount.htm",  method= RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result
			,HttpServletRequest request) throws AdException {

		try{
		UserDAO userDao = new UserDAO();
		String username= (String) request.getSession().getAttribute("usernameVal");
		User u= userDao.get(username);
		String pictureName = u.getPhotoName();
		
		
		request.setAttribute("pictureName", pictureName);
		return "MyAccount";
		}
		catch(AdException ae){
			return "Redirect";
		}
	}
}
