package com.neu.TutoringServices.Pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="intermediate")
public class Intermediate{
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="requestId")
	    private int requestId;
		
	    @Column(name="category")
	    private String category;
	   
		@Column(name="subCategory")
		private String subCategory;
		
		@Column(name="requestInfo")
		private String requestInfo;
		
		@Column(name="additionalInfo")
		private String additionalInfo;
		
		@Column(name="name")
		private String name;

		@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	    @JoinColumn(name="username")
		private User user;

		public int getRequestId() {
			return requestId;
		}

		public void setRequestId(int requestId) {
			this.requestId = requestId;
		}


		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getSubCategory() {
			return subCategory;
		}

		public void setSubCategory(String subCategory) {
			this.subCategory = subCategory;
		}

		public String getRequestInfo() {
			return requestInfo;
		}

		public void setRequestInfo(String requestInfo) {
			this.requestInfo = requestInfo;
		}

		public String getAdditionalInfo() {
			return additionalInfo;
		}

		public void setAdditionalInfo(String additionalInfo) {
			this.additionalInfo = additionalInfo;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	
}
