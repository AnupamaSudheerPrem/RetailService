package com.anu.poc.myretailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu.poc.exception.ResourceNotFoundException;
import com.anu.poc.myretail.dto.Offer;
import com.anu.poc.myretail.dto.Price;
import com.anu.poc.myretail.dto.ProductInfo;

@Service
public class PricedProductService implements ProductService {
	private static final  Logger LOGGER = LoggerFactory.getLogger(PricedProductService.class);
	@Autowired
	private ProductLookupService productLookupService = null;
	@Autowired
	private PriceLookupService priceLookupService = null;
	
	@Autowired
	private OfferLookupService offerLookupService = null;

	@Override
	public ProductInfo findByProductId(int productId) throws ResourceNotFoundException {
		try {
		ProductInfo productInfo = productLookupService.findByID(productId);
		Price price = priceLookupService.findByProductID(productId);
		Offer offer = offerLookupService.findByProductID(productId);
		LOGGER.info("Updating the Price for product id: {}",productId);
		LOGGER.debug("Updated Price for product id: {} is :{}  and the product Info is: {}",productId,price,offer,productInfo);
		if(offer!=null) {
			float currentPrice = price.getPrice();
			float offerPercentage = offer.getOfferPercentage();
			if(offerPercentage>0) {
				float newPrice = currentPrice -(currentPrice*(offerPercentage/100));
				price.setPrice(newPrice);
				productInfo.setOffer(offer);
			}
		}
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

/*	@Override
	public Offer deleteOfferByProuctID(int productID) {
		
		Offer offer	= null;
	try {
		
		 offer	= offerLookupService.findByProductID(productID);
		if(offer.getId()>0) {
			offerLookupService.delete(offer);
		}
		
	} catch (ResourceNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		return offer;
	}*/
	
	@Override
	public Offer deleteOfferByProuctID(int productID) {
		
		return offerLookupService.deleteByProductID(productID);
	}

}
