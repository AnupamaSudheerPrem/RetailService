package com.anu.poc.myretail.controllers;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anu.poc.exception.ResourceNotFoundException;
import com.anu.poc.myretail.dto.ProductInfo;
import com.anu.poc.myretail.jpa.PriceRepository;
import com.anu.poc.myretailservice.ProductService;


@RestController
@RequestMapping("/myretail/v1")
public class ProductController {
	
			
		@Autowired
		private PriceRepository priceRepository;
		  
		@Autowired
		 private ProductService productService;
		  /**
		   * Get all users list.
		   *
		   * @return the list
		   */
		  
		
		/*  @GetMapping("/products/{id}")
		  public ResponseEntity<ProductInfo> getProductById(@PathVariable(value = "id") int productId)
				  throws ResourceNotFoundException {
			  ProductInfo productInfo = productService.findByProductId(productId);
			  Optional.of(productInfo).orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + productId));
			 return ResponseEntity.ok().body(productInfo); 
			 
	       }*/
		  
		
	  
		  
		  @GetMapping("/products/{id}")
		  public ResponseEntity<ProductInfo> getProductById(@PathVariable(value = "id") int productId) throws ResourceNotFoundException {
			  
			  ProductInfo productInfo = productService.findByProductId(productId);
			  return ResponseEntity.ok().body(productInfo); 
			  
		  }
		  
		  
		  @PutMapping("/products/{id}")
		  public ResponseEntity<ProductInfo> updatePrice(
		      @PathVariable(value = "id") int productId, @Valid @RequestBody ProductInfo productDetails)
		      throws ResourceNotFoundException {
			  ProductInfo productInfo = productService.findByProductId(productId);
		            Optional.of(productInfo).orElseThrow(() -> new ResourceNotFoundException("Price not found on :: " + productId));
		            
		            productInfo.setProduct(productDetails.getProduct());
		            productInfo.setPrice(productDetails.getPrice());
		           //productInfo.setAdditionalProperty(name, value);
		            final ProductInfo updatedPrice = productService.update(productInfo);
		            return ResponseEntity.ok().body(updatedPrice);
		  }
		  

}
