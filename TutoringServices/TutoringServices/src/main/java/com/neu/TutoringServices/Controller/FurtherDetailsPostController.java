package com.neu.TutoringServices.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.neu.TutoringServices.Dao.UserDAO;
import com.neu.TutoringServices.Exception.AdException;
import com.neu.TutoringServices.Pojo.User;

@Controller
public class FurtherDetailsPostController extends SimpleFormController {
	Object x;
	@RequestMapping(value ="/furtherDetailsPost.htm",method = RequestMethod.POST)
	protected String  doSubmitAction(@ModelAttribute("user") User user, HttpServletRequest request) throws Exception {
		x=request.getSession().getAttribute("usernameVal");
		try {
		
				UserDAO userDao = new UserDAO();
				File file;
			       String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
			      
			       
			       String path= "D:\\2nd_Semester\\Workspace\\TutoringServices\\src\\main\\webapp\\resources\\images\\"; //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
			    	
			    System.out.println("user" + user);
			    System.out.println("user.getPhoto()" + user.getPhoto());
			        if(user.getPhoto()!=null){
			        	System.out.println("HElllllo");
			            String fileNameWithExt = System.currentTimeMillis() + user.getPhoto().getOriginalFilename();
			            file = new File(path +fileNameWithExt);
			         

			            String context= getServletContext().getContextPath();
			            
			            System.out.println("---context---"+context);
			            
			            user.getPhoto().transferTo(file);
			            user.setPhotoName(context + "/resources/images/" + fileNameWithExt);
			        }
			        userDao.createFurtherDetails(String.valueOf(x)
							, user.getType()
							,user.getGender()
							, user.getSubjectCategory()
							,user.getTutoringType()
							,user.getAge()
							,user.getPhotoName()
							);
				
			
		
			
				HttpSession session = request.getSession();
				String action= (String) session.getAttribute("action");
				String designation = user.getType();
				request.getSession().setAttribute("designation", designation);
				System.out.println("Hello----action-->" + action);
			   
				List<String> listVal= new ArrayList<String>();
				listVal= (List<String>) request.getSession().getAttribute("listVal");
		            
				if(action.equalsIgnoreCase("requestPage"))
					{
						System.out.println("Hello1------>" );
						userDao.createRequest(String.valueOf(x)
							, user.getType()
							,user.getGender()
							,user.getAge()
							,listVal
							);
				 
				 
					}

				 return "Redirect";

		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
			 return "Error";
			
			
		}
	
		
	}
}
