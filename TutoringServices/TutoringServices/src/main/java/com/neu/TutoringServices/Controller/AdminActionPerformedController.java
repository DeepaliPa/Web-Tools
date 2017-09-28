package com.neu.TutoringServices.Controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.TutoringServices.Dao.UserDAO;
import com.neu.TutoringServices.Exception.AdException;
import com.neu.TutoringServices.Pojo.User;

@Controller
public class AdminActionPerformedController {
		
	@RequestMapping(value = "/actionPendingRequests.htm", method = RequestMethod.GET)
	 public String actionPendingRequest(HttpServletRequest request, HttpServletResponse response)
            throws ParseException, AdException
    {
        try
        {
            String action = request.getParameter("action");
            System.out.println("clicked action value is " + action);
            String username = String.valueOf(request.getParameter("username"));
            System.out.println("username from admin screen is " + username);
            if(action.equalsIgnoreCase("Approved"))
            {
                System.out.println("Inside Approved");
                String status = "Approved";
                User user = new User();
                UserDAO userDAO = new UserDAO();
                user = userDAO.getUserObject(username);
                user.setFlag(status);
                userDAO.updateUserStatus(user);
                return "AdminRequests";
               
            }
            else if(action.equalsIgnoreCase("Rejected"))
            {
            	System.out.println("Inside Rejected");
                String status = "Rejected";
                User user = new User();
                UserDAO userDAO = new UserDAO();
                user = userDAO.getUserObject(username);
                user.setFlag(status);
                userDAO.updateUserStatus(user);
                return "AdminRequests";
            }
        }
        catch (AdException e)
        {
           System.out.println("Exception: " + e.getMessage());
        }
        return "AdminRequests";
       
    }
}
