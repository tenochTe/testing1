package mx.com.testing1.service.impl;

import mx.com.testing1.service.PromotionService;

public class PromotionServiceImpl implements PromotionService {
	
	@Override
	public void create(String promotion) {
		System.out.println("*----------"+promotion+"----------*");

	}

}
