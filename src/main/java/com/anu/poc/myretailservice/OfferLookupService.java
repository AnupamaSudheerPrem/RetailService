package com.anu.poc.myretailservice;

import org.springframework.stereotype.Service;

import com.anu.poc.exception.ResourceNotFoundException;
import com.anu.poc.myretail.dto.Offer;
import com.anu.poc.myretail.dto.Price;
import com.anu.poc.myretail.dto.ProductInfo;

@Service
public interface OfferLookupService  {
	
	public Offer findByProductID(int productId) throws ResourceNotFoundException; 
	public Offer delete(Offer offer);
	public Offer update(Offer offer);
	public Offer deleteByProductID(int productID);
	
}
