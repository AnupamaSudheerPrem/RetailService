package com.anu.poc.myretail.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PriceRepository extends  JpaRepository<PriceDAO,Long> {
	
	@Query("select p from PriceDAO p where p.productId = ?1")
	public PriceDAO findByProductID(int productId);
	
	
	
	

}
