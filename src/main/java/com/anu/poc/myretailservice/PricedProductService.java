package com.anu.poc.myretailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu.poc.exception.ResourceNotFoundException;
import com.anu.poc.myretail.dto.Price;
import com.anu.poc.myretail.dto.ProductInfo;

@Service
public class PricedProductService implements ProductService {
	private static final  Logger LOGGER = LoggerFactory.getLogger(PricedProductService.class);
	@Autowired
	private ProductLookupService productLookupService = null;
	@Autowired
	private PriceLookupService priceLookupService = null;

	@Override
	public ProductInfo findByProductId(int productId) throws ResourceNotFoundException {
		try {
		ProductInfo productInfo = productLookupService.findByID(productId);
		Price price = priceLookupService.findByProductID(productId);
		LOGGER.info("Updating the Price for product id: {}",productId);
		LOGGER.debug("Updated Price for product id: {} is :{}  and the product Info is: {}",productId,price,productInfo);
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
