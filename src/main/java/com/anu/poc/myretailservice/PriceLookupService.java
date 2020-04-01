package com.anu.poc.myretailservice;

import org.springframework.stereotype.Service;

import com.anu.poc.exception.ResourceNotFoundException;
import com.anu.poc.myretail.dto.Price;
import com.anu.poc.myretail.dto.ProductInfo;

@Service
public interface PriceLookupService  {
	
	public Price findByProductID(int productId) throws ResourceNotFoundException; 
	public Price update(Price price); 
	
}
