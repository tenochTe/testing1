package mx.com.testing1.service;

public interface PromotionService {
	
	int create(String promotion);
	
	boolean isActive(String sku);
	
	int update(String sku);

}
