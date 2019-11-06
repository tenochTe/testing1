package mx.com.testing1.facade;

public interface PromotionFacade {

	int getPromotion(String sku, Double price, Double discount);

	boolean validatePromotion(String sku);
	
	
}
