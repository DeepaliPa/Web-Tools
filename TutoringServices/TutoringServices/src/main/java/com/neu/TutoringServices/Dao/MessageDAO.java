package com.neu.TutoringServices.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.TutoringServices.Exception.AdException;
import com.neu.TutoringServices.Pojo.Messages;
import com.neu.TutoringServices.Pojo.User;


public class MessageDAO extends DAO {

    public MessageDAO() {
    }
    
    
    public Messages create(String toUser,
    		String from,
    		String message)
            throws AdException {
        try {
            begin();
            System.out.println("inside Message DAO");      
            Messages messages=new Messages();
            
            messages.setUserName(toUser);
            messages.setFromUser(from);
            messages.setMessage(message);
            getSession().save(messages);
            commit();
            return messages;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while inserting into Messages: " + e);
        }
    }
    
    
    
    public List<Messages> getList(String username)throws AdException
    {
    	try {
            begin();

     Query q = getSession().createQuery("from Messages where userName = :username");
     q.setString("username", username);
     List<Messages> list = q.list();
     System.out.println("Messages--->" +list);
     commit();
     return list;
     } 
    	catch (HibernateException e) {
         rollback();
         throw new AdException("Could not get tutor " +  e);
     }
    }

}
