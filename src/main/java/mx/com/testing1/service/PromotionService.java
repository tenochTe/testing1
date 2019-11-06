package mx.com.testing1.service;

import mx.com.testing1.error.PromotionNotFoundException;

public interface PromotionService {
	
	int create(String promotion, Double price);
	
	boolean isActive(String sku);
	
	void update(String sku) throws PromotionNotFoundException;

}
