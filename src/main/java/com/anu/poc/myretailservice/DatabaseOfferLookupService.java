package com.anu.poc.myretailservice;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu.poc.exception.ResourceNotFoundException;
import com.anu.poc.myretail.dto.Offer;
import com.anu.poc.myretail.dto.Price;
import com.anu.poc.myretail.jpa.OfferDAO;
import com.anu.poc.myretail.jpa.OfferRepository;
import com.anu.poc.myretail.jpa.PriceDAO;
import com.anu.poc.myretail.jpa.PriceRepository;

@Service
public class DatabaseOfferLookupService implements OfferLookupService {
	
	private static final  Logger LOGGER = LoggerFactory.getLogger(DatabaseOfferLookupService.class);
	
	@Autowired
	private OfferRepository offerRepository = null;
	
	@Autowired
	private PriceRepository priceRepository = null;

	@Override
	public Offer findByProductID(int productId) throws ResourceNotFoundException {
		
		LOGGER.debug("Getting the Offer from database: {}",productId);
		//PriceDAO productPrice = priceRepository.findByProductID(productId);
		OfferDAO offerDAO = Optional.ofNullable(offerRepository.findByProductID(productId))
				.orElse(new OfferDAO(productId,0.0f));
		
		Offer offer = new Offer();
		offer.setId(offerDAO.getId());
		offer.setProductId(offerDAO.getProductId());
		offer.setOfferPercentage(offerDAO.getOfferPercentage());
		
		LOGGER.info("Returning the Offer price for product id: {}",productId);
		LOGGER.debug("Offer price for product id: {} is :{}",productId,offer);
		return offer;
		
	}
	
	@Override
	public Offer delete(Offer offer) {
		
		OfferDAO offerDAO = new OfferDAO();
		offerDAO.setId(offer.getId());
		offerDAO.setOfferPercentage(offer.getOfferPercentage());
		offerDAO.setProductId(offer.getProductId());
		LOGGER.debug("offer DAO Value is:{}",offerDAO);
		offerRepository.delete(offerDAO);
		LOGGER.info("Successfully deleted the data for product id: {}",offer.getProductId());
		return offer;
		
		
	}

	@Override
	public Offer update(Offer offer) {
		
		OfferDAO offerDAO = new OfferDAO();
		offerDAO.setId(offer.getId());
		offerDAO.setOfferPercentage(offer.getOfferPercentage());
		offerDAO.setProductId(offer.getProductId());
		LOGGER.debug("Offer DAO Value is:{}",offerDAO);
		offerRepository.save(offerDAO);
		LOGGER.info("Successfully saved the data for product id: {}",offer.getProductId());
		return offer;
	}

	@Override
	public Offer deleteByProductID(int productID) {
		
		Offer offer = null;
		try {
			 offer = findByProductID(productID);
			 if(offer.getId()>0) {
				 offer =  delete(offer);
			 }
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return offer;
	}

}
