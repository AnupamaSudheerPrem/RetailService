
package com.anu.poc.myretail.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.beans.factory.annotation.Autowired;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "product",
    "price",
    "offer"
})
public class ProductInfo {

    @JsonProperty("product")
    private Product product;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    @JsonProperty("price")
    private Price price;
    
    @JsonProperty("offer")
    private Offer offer;

    @JsonProperty("product")
    public Product getProduct() {
        return product;
    }

    @JsonProperty("product")
    public void setProduct(Product product) {
        this.product = product;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("price")
	public Price getPrice() {
		return price;
	}
    
    @JsonProperty("price")
	public void setPrice(Price price) {
		this.price = price;
	}
    
    @JsonProperty("offer")
    	public Offer getOffer() {
		return offer;
	}
    
    @JsonProperty("offer")
    public void setOffer(Offer offer) {
		this.offer = offer;
	}
    
    
    

}
