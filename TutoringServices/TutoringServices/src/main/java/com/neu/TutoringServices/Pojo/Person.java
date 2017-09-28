package com.neu.TutoringServices.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="person")
@Inheritance(strategy=InheritanceType.JOINED) //table per subclass
public class Person {
	
	@Id
	@GeneratedValue
	@Column(name = "personID", unique=true, nullable = false)
	private long personID;

	@Column(name= "fullname")
	private String fullname;
	
    public Person(){
    }

	public long getPersonID() { 
		return personID;
	}

	public void setPersonID(long personID) {
		this.personID = personID;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
}
