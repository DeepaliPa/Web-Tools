package com.neu.TutoringServices.Controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.TutoringServices.Dao.UserDAO;
import com.neu.TutoringServices.Exception.AdException;
import com.neu.TutoringServices.Pojo.User;

@Controller
public class ViewUserDetailsController {

	@RequestMapping(value ="/getUserDetails.htm",method = RequestMethod.POST)
	public @ResponseBody ArrayList<User> sampleAjax(HttpServletRequest request) throws AdException {
		
		ArrayList<User> users = new ArrayList<User>();
		UserDAO userDao = new UserDAO();
		users=(ArrayList<User>) userDao.getListOfUser(String.valueOf(request.getSession().getAttribute("usernameVal")));
		
		
		return users;
	}
}
