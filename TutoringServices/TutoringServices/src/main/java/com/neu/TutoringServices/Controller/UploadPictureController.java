package com.neu.TutoringServices.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.TutoringServices.Dao.UserDAO;
import com.neu.TutoringServices.Pojo.User;

@Controller
public class UploadPictureController {

	@RequestMapping(value ="/uploadPhoto.htm",method = RequestMethod.GET)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request) throws Exception {
		
		String name= (String) request.getSession().getAttribute("usernameVal");
		
		UserDAO userDao = new UserDAO();
		File file;
	       String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
	       String path = null;
	       if(check.equalsIgnoreCase("\\")) {
	        path =request.getRealPath("").replace("build\\",""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
	    }
	    
	        if(check.equalsIgnoreCase("/")) {
	       path = request.getRealPath("").replace("build/","");
	       path += "/"; //Adding trailing slash for Mac systems.

	    }
	        if(user.getPhoto()!=null){
	            String fileNameWithExt = System.currentTimeMillis() + user.getPhoto().getOriginalFilename();
	            file = new File(path +fileNameWithExt);
	            String context= request.getContextPath();
	            
	            user.getPhoto().transferTo(file);
	            user.setPhotoName(context + "/" + fileNameWithExt);
	            userDao.addPicture(user,name);
	        }

		return "View";
		// DAO.close();

		
	}
}
