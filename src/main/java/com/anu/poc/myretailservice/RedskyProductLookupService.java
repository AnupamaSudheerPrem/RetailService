package com.anu.poc.myretailservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anu.poc.exception.ResourceNotFoundException;
import com.anu.poc.myretail.dto.ProductInfo;

@Service
public class RedskyProductLookupService implements ProductLookupService {

	private String sourceURL = "https://redsky.target.com/v2/pdp/tcin/%d?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getSourceURL() {
		return sourceURL;
	}

	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public ProductInfo findByID(int id) throws ResourceNotFoundException {
		String modifiedURL = String.format(sourceURL,id);
		/*Map<String,Object> result = restTemplate.getForObject(modifiedURL,Map.class);
		for(Map.Entry<String, Object> resultEntry:result.entrySet()) {
			System.out.println("key:"+resultEntry.getKey()+", value:"+resultEntry.getValue());
		}*/
		ProductInfo productInfo =  Optional.of(restTemplate.getForObject(modifiedURL,ProductInfo.class))
				.orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + id));
		return productInfo;
	}
	
	public static void main(String[] args)  throws ResourceNotFoundException{
		RedskyProductLookupService productLookupService = new RedskyProductLookupService();
		RestTemplate restTemplate = new RestTemplate();
		productLookupService.setRestTemplate(restTemplate);
		productLookupService.findByID(17221235);
	}

}
