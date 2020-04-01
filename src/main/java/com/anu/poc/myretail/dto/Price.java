package com.anu.poc.myretail.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"productId",
	"price",
    "country_code"
   
})
public class Price {
	
	
	@JsonProperty("id")
	Long id;
	
	@JsonProperty("productId")
	int productId;
	
	@JsonProperty("price")
	float price;
	
	@JsonProperty("country_code")
	String currencyCode;
	
	public Price() {
		super();
		
	}

	public Price(int productId, float price, String currencyCode) {
		super();
		this.productId = productId;
		this.price = price;
		this.currencyCode = currencyCode;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@JsonProperty("price")
	public float getPrice() {
		return price;
	}
	
	@JsonProperty("price")
	public void setPrice(float price) {
		this.price = price;
	}
	
	@JsonProperty("country_code")
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	@JsonProperty("country_code")
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	@JsonProperty("id")
	public Long getId() {
		return id;
	}
	
	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
