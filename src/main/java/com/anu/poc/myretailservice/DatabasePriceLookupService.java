package com.anu.poc.myretailservice;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu.poc.exception.ResourceNotFoundException;
import com.anu.poc.myretail.dto.Price;
import com.anu.poc.myretail.jpa.PriceDAO;
import com.anu.poc.myretail.jpa.PriceRepository;

@Service
public class DatabasePriceLookupService implements PriceLookupService {
	
	private static final  Logger LOGGER = LoggerFactory.getLogger(DatabasePriceLookupService.class);
	@Autowired
	private PriceRepository priceRepository = null;

	@Override
	public Price findByProductID(int productId) throws ResourceNotFoundException {
		
		LOGGER.debug("Getting the product ID from database: {}",productId);
		//PriceDAO productPrice = priceRepository.findByProductID(productId);
		PriceDAO priceDAO = Optional.of(priceRepository.findByProductID(productId))
				.orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + productId));
		
		Price price = new Price();
		price.setId(priceDAO.getId());
		price.setPrice(priceDAO.getPrice());
		price.setProductId(priceDAO.getProductId());
		price.setCurrencyCode(priceDAO.getCurrencyCode());
		LOGGER.info("Returning the Price for product id: {}",productId);
		LOGGER.debug("Price for product id: {} is :{}",productId,price);
		return price;
	}

	@Override
	public Price update(Price price) {
		
		PriceDAO priceDAO = new PriceDAO();
		priceDAO.setId(price.getId());
		priceDAO.setPrice(price.getPrice());
		priceDAO.setProductId(price.getProductId());
		priceDAO.setCurrencyCode(price.getCurrencyCode());
		LOGGER.debug("price DAO Value is:{}",priceDAO);
		priceRepository.save(priceDAO);
		LOGGER.info("Successfully saved the data for product id: {}",price.getProductId());
		return price;
	}

}
