package com.neu.TutoringServices.Pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="user")
@PrimaryKeyJoinColumn(name="personID")

public class User extends Person {

	
	@Column(name="username", unique=true, nullable = false)
	private String username;
	
	
	@Column(name="passowrd")
	private String password;
	
	
	@Column(name="email")
	private String email;
	
	
	@Column(name="type")
    private String type;
   
	@Column(name="gender")
	private String gender;
	
	@Column(name="subjectCategory")
	private String subjectCategory;
	
	@Column(name="tutoringType")
	private String tutoringType;
	
	@Column(name="age")
	private String age;
	
	@Column(name="flag")
	private String flag;
	
	@Column(name="photoName")
    private String photoName;
	
	@Transient
    private MultipartFile photo;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="user")
    private Set<Intermediate> intermediateList = new HashSet<Intermediate>();
	
	public User(String username, String password){
		this.username= username;
		this.password= password;
	}
	
	public User(){
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSubjectCategory() {
		return subjectCategory;
	}

	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}
	
	public String getTutoringType() {
		return tutoringType;
	}

	public void setTutoringType(String tutoringType) {
		this.tutoringType = tutoringType;
	}
	

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Set<Intermediate> getIntermediateList() {
		return intermediateList;
	}

	public void setIntermediateList(Set<Intermediate> intermediateList) {
		this.intermediateList = intermediateList;
	}

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
    
    
	

}
