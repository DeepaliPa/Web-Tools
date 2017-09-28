package com.neu.TutoringServices.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.TutoringServices.Dao.UserDAO;
import com.neu.TutoringServices.Exception.AdException;
import com.neu.TutoringServices.Pojo.Intermediate;

@Controller
public class DeleteUserRequestController {

		
	@RequestMapping(value ="/deleteUserDetails.htm",method = RequestMethod.POST)
	public @ResponseBody Intermediate sampleAjax(HttpServletRequest request) throws AdException {
		//ArrayList<Intermediate> interm = new ArrayList<Intermediate>();
		UserDAO userDao = new UserDAO();
		String val = request.getParameter("userID");
		
		Intermediate i =userDao.del(val);
		System.out.println("DeleteUserRequestController.sampleAjax()------>" +val);
		Intermediate interm= userDao.delete(i);
		System.out.println("interm is --->" + interm);
		return interm;
	}
}
