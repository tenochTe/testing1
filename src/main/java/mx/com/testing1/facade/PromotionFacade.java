package mx.com.testing1.facade;

public interface PromotionFacade {
	
	boolean validatePromotion(String sku);
	
	Double getPromotion(String sku, Double price, Double discount);
	
}
