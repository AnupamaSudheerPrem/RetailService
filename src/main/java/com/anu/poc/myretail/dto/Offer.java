package com.anu.poc.myretail.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"productId",
	"offerPercentage"
    
})
public class Offer {
	
	
	@JsonProperty("id")
	Long id;
	
	@JsonProperty("productId")
	int productId;
	
	@JsonProperty("offerPercentage")
	float offerPercentage;
	
		
		public Offer() {
			super();
			
		}

		public Offer(int productId, float offerPercentage) {
			super();
			this.productId = productId;
			this.offerPercentage = offerPercentage;
			
			
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		@JsonProperty("id")
		public Long getId() {
			return id;
		}
		
		@JsonProperty("id")
		public void setId(Long id) {
			this.id = id;
		}

		@JsonProperty("offerPercentage")
		public float getOfferPercentage() {
			return offerPercentage;
		}
		
		@JsonProperty("offerPercentage")
		public void setOfferPercentage(float offerPercentage) {
			this.offerPercentage = offerPercentage;
		}

		@Override
		public String toString() {
			return "Offer [id=" + id + ", productId=" + productId + ", offerPercentage=" + offerPercentage + "]";
		}

		
		
		

}
