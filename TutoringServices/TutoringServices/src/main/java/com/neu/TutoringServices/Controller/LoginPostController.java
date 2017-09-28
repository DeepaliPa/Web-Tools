package com.neu.TutoringServices.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.TutoringServices.Dao.UserDAO;
import com.neu.TutoringServices.Exception.AdException;
import com.neu.TutoringServices.Pojo.User;

@Controller
@RequestMapping("/loginPost.htm")
public class LoginPostController {
	
	String username;
	UserDAO userDao = new UserDAO();

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result
			,HttpServletRequest request) throws Exception {
		User u;

		try { 
			
			
				
					username =request.getParameter("username");
				
					u=(User)userDao.get(username);
					
					
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
			return "Redirect";
  }
		if(u==null){
			return "BackToHomePage";
		}
					String flagValue= u.getFlag();
					System.out.println("flagValue---->" + flagValue);
					
					if(flagValue.equals("InActive")){
						
						return "StatusPending";
					}else if(flagValue.equals("Rejected")){
						
						return "StatusPending";
					}
					
			
					else{
						HttpSession session = request.getSession();
					
					session.setAttribute("usernameVal", username);
					System.out.println("username------>" + username);
					
					session.setAttribute("designation", u.getType());
					System.out.println("designation------>" + u.getType());
				
				
					List<String> listVal= new ArrayList<String>();
					listVal= (List<String>) request.getSession().getAttribute("listVal");
				
						

					String action= (String) session.getAttribute("action");
					System.out.println("LoginPost------>" + action);
					if(action.equalsIgnoreCase("requestPage"))
					{
						
						
						System.out.println("Inside LoginPost for userDAO------>" );
							userDao.createRequest(username
									, user.getType()
									,user.getGender()
									,user.getAge()
									,listVal
									);
							
						}}

		return "Redirect";
	}
}
