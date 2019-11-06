package mx.com.testing1.facade.impl;

import mx.com.testing1.facade.PromotionFacade;
import mx.com.testing1.service.PromotionService;

public class PromotionFacadeImpl implements PromotionFacade {
	
	private PromotionService promotionService;
	
	public PromotionFacadeImpl(PromotionService promotionService){
		this.promotionService=promotionService;
	}
	
	@Override
	public int getPromotion(String sku, Double price, Double discount) {
		Double res = 0.0;
		if ( price > 0 ) {
			Double b = discount/100;
			Double a = price * b;
			res = price - a;
		}
		return promotionService.create(sku, res);
	}

	@Override
	public boolean validatePromotion(String sku) {
		return promotionService.isActive(sku);
	}
	

}
