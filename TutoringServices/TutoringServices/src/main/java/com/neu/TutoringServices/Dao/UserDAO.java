package com.neu.TutoringServices.Dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.neu.TutoringServices.Exception.AdException;
import com.neu.TutoringServices.Pojo.Intermediate;
import com.neu.TutoringServices.Pojo.User;

public class UserDAO extends DAO {

    public UserDAO() {
    }

    public User get(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where username = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            
    		System.out.println("user Inside get------>" + user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
    
    public User addPicture(User user, String name) throws AdException{
    	try {
            begin();
            Query query = getSession().createQuery("update User set photoName = :photoName" +
    				" where username = :username");
            query.setParameter("photoName", "DIALOG1");
            query.setParameter("username", name);
            int result = query.executeUpdate();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user ", e);
        }
    }
            
            
    
    public List<User> getList(String type)throws AdException
    {
    	try {
            begin();

     Query q = getSession().createQuery("from User where type = :type");
     q.setString("type", type);
     List<User> list = q.list();
     System.out.println("deepali--->" +list);
     commit();
     return list;
     } 
    	catch (HibernateException e) {
         rollback();
         throw new AdException("Could not get tutor " +  e);
     }
    }
    
    public List<User> getListOfUser(String username)throws AdException
    {
    	try {
            begin();

     Query q = getSession().createQuery("from User where username = :username");
     q.setString("username", username);
     List<User> list = q.list();
     System.out.println("deepali--->" +list);
     commit();
     return list;
     } 
    	catch (HibernateException e) {
         rollback();
         throw new AdException("Could not get tutor " +  e);
     }
    }
    
    public List<Intermediate> getListOfStudentRequest(String username)throws AdException
    {
    	try {
            begin();
            	Query q = getSession().createQuery("from Intermediate where name = :username");
            	q.setString("username", username);
            	List<Intermediate> list = q.list();
            	System.out.println("Intermediate List--->" +list);
            	commit();
            return list;
    		} catch (HibernateException e) {
    			rollback();
    			throw new AdException("Could not get tutor " +  e);
    		}
    }

    public User create(String username,
    		String password,
    		String email,
    		String fullname)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");      
            User user=new User(username,password);
            
            user.setFullname(fullname);
            user.setEmail(email);
            if(username.equalsIgnoreCase("Admin")){
            	user.setFlag("Disabled");
            }else{
            	 user.setFlag("InActive");
            }
            
            getSession().save(user);
       
            
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
    
    public Intermediate createRequest(String username,
    		String type,
    		String gender,
    		String age,
    		List list)
            throws AdException {
        try {
            begin();
            System.out.println("inside Intermediate DAO");      
            Intermediate intermediate=new Intermediate();
            String a[] = new String[list.size()];
            
            for (int i=0;i < list.size();i++)
            {
              a[i]=(String) list.get(i);
            }
            
            intermediate.setCategory(a[0]);
            intermediate.setSubCategory(a[1]);
            intermediate.setAdditionalInfo(a[2]);
            intermediate.setRequestInfo(a[3]);
            intermediate.setName(username);
            
 
            getSession().save(intermediate);
       
            
            commit();
            return intermediate;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
    
    public User createFurtherDetails(String username,
    		String type,
    		String gender,
    		String subjectCategory,
    		String tutoringType,
    		String age,
    		String photoName
    		)throws AdException {
    	
    	 try {
             begin();
             
             Query q = getSession().createQuery("from User where username = :username");
             System.out.println("Query value is --->" + q);
             
             q.setString("username", username);
             User user = (User) q.uniqueResult();
             
             user.setType(type);
             user.setGender(gender);
             user.setSubjectCategory(subjectCategory);
             user.setTutoringType(tutoringType);
             user.setAge(age);
             user.setPhotoName(photoName);
         
             commit();
             return user;
           
         } catch (HibernateException e) {
             rollback();
             //throw new AdException("Could not create user " + username, e);
             throw new AdException("Exception while creating user: " + e.getMessage());
         }
    	
    	
    	
    }
    public Intermediate delete(Intermediate intermediate) throws AdException {
        try {
            begin();
            getSession().delete(intermediate);
            commit();
            return intermediate;
          
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " +  e);
        }
		
    }
    public User update(User user) throws AdException {
        try {
            begin();
            getSession().update(user);
            commit();
            return user;
          
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " +  e);
        }
		
    }
    public List<User> search(String status) throws AdException
    {
        try
        {
            begin();
            System.out.println("Inside search" +status);
            Criteria criteria = getSession().createCriteria(User.class);
            criteria.add(Restrictions.eq("flag",status));
            List<User> listUser = criteria.list();
            System.out.println("size of the list is " + listUser.size());
            commit();
            return listUser;
        }
        catch (HibernateException e)
        {
            rollback();
            throw new AdException("Could not get airlines for current selection", e);
        }
    }
    
    public Intermediate del(String userId)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Intermediate where requestId = :userId");
            q.setString("userId", userId);
            Intermediate intermediate = (Intermediate) q.uniqueResult();
            
    		System.out.println("user Inside get------>" + intermediate);
            commit();
            return intermediate;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user ", e);
        }
    }
    public User getUserObject(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where username = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            
    		System.out.println("user Inside get------>" + user);
            commit();
            return user; 
            
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user ", e);
        }
    }   
    public User updateUserStatus(User user) throws AdException {
        try {
            begin();
            getSession().update(user);
            commit();
            return user;
          
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " +  e);
        }
		
    }
 
}