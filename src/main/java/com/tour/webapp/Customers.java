package com.tour.webapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Customers {
	
	
	
	private String name;
	private String email;
	private String address;
	
	
	
	public Customers() {
		
	}
	
	
	public Customers( String name, String email ,String address) {
       
        this.name = name;
        this.email= email;
        this.address = address;
    }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	

}
