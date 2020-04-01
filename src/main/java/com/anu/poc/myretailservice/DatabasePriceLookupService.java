package com.anu.poc.myretailservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu.poc.exception.ResourceNotFoundException;
import com.anu.poc.myretail.dto.Price;
import com.anu.poc.myretail.jpa.PriceDAO;
import com.anu.poc.myretail.jpa.PriceRepository;

@Service
public class DatabasePriceLookupService implements PriceLookupService {
	
	@Autowired
	private PriceRepository priceRepository = null;

	@Override
	public Price findByProductID(int productId) throws ResourceNotFoundException {
		
		//PriceDAO productPrice = priceRepository.findByProductID(productId);
		PriceDAO priceDAO = Optional.of(priceRepository.findByProductID(productId))
				.orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + productId));
		
		Price price = new Price();
		price.setId(priceDAO.getId());
		price.setPrice(priceDAO.getPrice());
		price.setProductId(priceDAO.getProductId());
		price.setCurrencyCode(priceDAO.getCurrencyCode());
		return price;
	}

	@Override
	public Price update(Price price) {
		
		PriceDAO priceDAO = new PriceDAO();
		priceDAO.setId(price.getId());
		priceDAO.setPrice(price.getPrice());
		priceDAO.setProductId(price.getProductId());
		priceDAO.setCurrencyCode(price.getCurrencyCode());
		priceRepository.save(priceDAO);
		return price;
	}

}
