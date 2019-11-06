package mx.com.testing1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

import mx.com.testing1.facade.PromotionFacade;
import mx.com.testing1.facade.impl.PromotionFacadeImpl;
import mx.com.testing1.service.PromotionService;

public class PromotionFacadeTest {
	
	@Test
	public void addingBehaviorTest() {
				
		/** Declare & Inject Mock*/
		PromotionService promotionServiceMock = Mockito.mock(PromotionService.class);
		PromotionFacade promotionFacade =new PromotionFacadeImpl(promotionServiceMock);
		
		/** Mock implementation of methods from service interface (behavior)  */
		Mockito.when(promotionServiceMock.create("NAME", 0.0)).thenReturn(400);
		Mockito.when(promotionServiceMock.create("NAME", 25.0)).thenReturn(200);
		
		Mockito.when(promotionServiceMock.isActive("")).thenReturn(false);
		Mockito.when(promotionServiceMock.isActive("SKU")).thenReturn(true);
		

		/** Test with expected behavior */
		Integer response1 = promotionFacade.getPromotion("NAME", 0.0, 0.0);
			assertEquals( new Integer(400), response1);
			
		Integer response2 = promotionFacade.getPromotion("NAME", 25.0, 0.0);
			assertEquals( new Integer(200), response2);

		assertFalse( promotionFacade.validatePromotion("") );
		
		assertTrue( promotionFacade.validatePromotion("SKU") );

	}
	

}
