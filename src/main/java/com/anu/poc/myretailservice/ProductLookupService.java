package com.anu.poc.myretailservice;

import org.springframework.stereotype.Service;

import com.anu.poc.exception.ResourceNotFoundException;
import com.anu.poc.myretail.dto.ProductInfo;

@Service
public interface ProductLookupService {
		public ProductInfo findByID(int id) throws ResourceNotFoundException;
		

}
