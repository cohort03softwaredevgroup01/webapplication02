package com.tour.webapp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
	
	
	@Autowired
	private CustomerRepo repo;
	
	public List<Customers> getListCustomers(){
		return repo.findAll();
	}	
	
	
	public void save(Customers customer) {
		repo.save(customer);
	}
	
	public Customers getCustomer(String email) {
		return repo.findById(email).get();
		
		
	}
	
	public void delete(String email) {
		repo.deleteById(email);
	}

}
