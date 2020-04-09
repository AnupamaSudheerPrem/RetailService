package com.anu.poc.myretail.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OfferRepository extends  JpaRepository<OfferDAO,Long> {
	
	@Query("select p from OfferDAO p where p.productId = ?1")
	public OfferDAO findByProductID(int productId);

}
