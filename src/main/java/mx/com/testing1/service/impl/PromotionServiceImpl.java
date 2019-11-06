package mx.com.testing1.service.impl;

import mx.com.testing1.service.PromotionService;

public class PromotionServiceImpl implements PromotionService {
	
	@Override
	public int create(String promotion) {
		int isCreated = promotion.length();
		if ( isCreated > 0 )
			System.out.println("CREATED: ".concat( promotion ));
		else
			System.out.println("NO CREATED");
		
		return ( isCreated > 0 ) ? 1 : 0;
	}

	@Override
	public boolean isActive(String sku) {
		int isCreated = sku.length();
		if ( isCreated > 0 )
			System.out.println("IS ACTIVE: ".concat( sku ));
		else
			System.out.println("NO ACTIVE");
		
		return ( isCreated > 0 );
	}

	@Override
	public int update(String sku) {
		int isCreated = sku.length();
		if ( isCreated > 0 )
			System.out.println("UPDATED: ".concat( sku ));
		else
			System.out.println("NO UPDATED");
		
		return ( isCreated > 0 ) ? 1 : 0;
	}

}
