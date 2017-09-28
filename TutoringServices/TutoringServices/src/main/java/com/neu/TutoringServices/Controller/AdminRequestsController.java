package com.neu.TutoringServices.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.TutoringServices.Dao.UserDAO;
import com.neu.TutoringServices.Exception.AdException;

@Controller
public class AdminRequestsController {
	
	@RequestMapping(value = "/searchPendingRequests.htm", method = RequestMethod.GET)
	protected String searchPendingRequest(HttpServletRequest request, HttpServletResponse response)
            throws ParseException, AdException
    {
        
        try
        {
            List listUsers = new ArrayList();
            String status = "InActive";
            UserDAO userDAO = new UserDAO();
            listUsers = (List) userDAO.search(status);
            //request.getSession().setAttribute("listOfStatus", listUsers);
            request.setAttribute("listUsers", listUsers);
          
        }
        catch (AdException e)
        {
           System.out.println("Exception: " + e.getMessage());
        }
        return "AdminRequests";
    }
	
	@RequestMapping(value = "/searchRejectedRequests.htm", method = RequestMethod.GET)
	protected String searchRejectedRequest(HttpServletRequest request, HttpServletResponse response)
            throws ParseException, AdException
    {
	        try
	        {
	            List listUsers = new ArrayList();
	            String status = "Rejected";
	            UserDAO userDAO = new UserDAO();
	            listUsers = (List) userDAO.search(status);
	            //mv.addObject("listOfStatus", list);
	            request.setAttribute("listUsers", listUsers);
	           
	        }
	        catch (AdException e)
	        {
	           System.out.println("Exception: " + e.getMessage());
	        }
	        return "AdminRequestsRejected";
    }
	 @RequestMapping(value = "/searchAcceptedRequests.htm", method = RequestMethod.GET)
	    public String searchAcceptedRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ParseException, AdException
	    { 
        try
        {
            List listUsers = new ArrayList();
            String status = "Approved";
            UserDAO userDAO = new UserDAO();
            listUsers = (List) userDAO.search(status);
            //mv.addObject("listOfStatus", list);
           // request.getSession().setAttribute("listOfStatus", listUsers);
            request.setAttribute("listUsers", listUsers);
            
        }
        catch (AdException e)
        {
           System.out.println("Exception: " + e.getMessage());
        }
        return "AdminRequestsApproved";
        
	    }

}
