package mx.com.testing1.facade.impl;

import mx.com.testing1.facade.PromotionFacade;
import mx.com.testing1.service.PromotionService;

public class PromotionFacadeImpl implements PromotionFacade {
	
	private PromotionService promotionService;
	
	public PromotionFacadeImpl(PromotionService promotionService){
		this.promotionService=promotionService;
	}
	
	@Override
	public Double getPromotion(String sku, Double price, Double discount) {
		Double b = discount/100;
		Double a = price * b;
		Double res = price - a;
		promotionService.create(sku.concat(" - ").concat(res.toString()));
		return res;
	}

	@Override
	public boolean validatePromotion(String sku) {
		return promotionService.isActive(sku);
	}
	

}
