package com.anu.poc.myretail.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_offers")

public class OfferDAO {
	
	
		@Id
		@Column(name = "id", nullable = false)
		Long id;
		
	    @Column(name = "product_id", nullable = false)
	    int productId;
	    
	    @Column(name = "offer_percentage", nullable = false)
	    float offerPercentage;
		
		
		
		public OfferDAO() {
			super();
			
		}

		public OfferDAO(int productId, float offerPercentage) {
			super();
			this.productId = productId;
			this.offerPercentage = offerPercentage;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public float getOfferPercentage() {
			return offerPercentage;
		}

		public void setOfferPercentage(float offerPercentage) {
			this.offerPercentage = offerPercentage;
		}
		
		

}
