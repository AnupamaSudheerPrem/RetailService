package com.anu.poc.myretail.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "product_price")
public class PriceDAO {
	
	
	@Id
	@Column(name = "id", nullable = false)
	Long id;
	
    @Column(name = "productid", nullable = false)
    int productId;
	
	@Column(name = "price", nullable = false)
	float price;
	
	
	@Column(name = "currency_code", nullable = false)
	String currencyCode;
	
	public PriceDAO() {
		super();
		
	}

	public PriceDAO(int productId, float price, String currencyCode) {
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
