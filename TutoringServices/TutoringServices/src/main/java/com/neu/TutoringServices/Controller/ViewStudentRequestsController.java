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
import com.neu.TutoringServices.Pojo.User;

@Controller
public class ViewStudentRequestsController {

	@RequestMapping(value ="/getStudentRequestDetails.htm",method = RequestMethod.POST)
	public @ResponseBody ArrayList<Intermediate> sampleAjax(HttpServletRequest request) throws AdException {
		ArrayList<Intermediate> intermediate = new ArrayList<Intermediate>();
		UserDAO userDao = new UserDAO();
		intermediate=(ArrayList<Intermediate>) userDao.getListOfStudentRequest(String.valueOf(request.getSession().getAttribute("usernameVal")));
		return intermediate;
	}
}
