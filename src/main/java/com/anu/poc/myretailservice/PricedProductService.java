package com.anu.poc.myretailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu.poc.exception.ResourceNotFoundException;
import com.anu.poc.myretail.dto.Price;
import com.anu.poc.myretail.dto.ProductInfo;

@Service
public class PricedProductService implements ProductService {
	
	@Autowired
	private ProductLookupService productLookupService = null;
	@Autowired
	private PriceLookupService priceLookupService = null;

	@Override
	public ProductInfo findByProductId(int productId) throws ResourceNotFoundException {
		try {
		ProductInfo productInfo = productLookupService.findByID(productId);
		Price price = priceLookupService.findByProductID(productId);
		productInfo.setPrice(price);
		return productInfo;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public ProductInfo update(ProductInfo productInfo) {
		Price price = productInfo.getPrice();
		price = priceLookupService.update(price);
		productInfo.setPrice(price);
		return productInfo;
	}

}
