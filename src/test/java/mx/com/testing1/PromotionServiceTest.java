package mx.com.testing1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeNoException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import mx.com.testing1.error.PromotionNotFoundException;
import mx.com.testing1.service.PromotionService;
import mx.com.testing1.service.impl.PromotionServiceImpl;

@ContextConfiguration("spring/app-context.xml")
@RunWith(MockitoJUnitRunner.class)
public class PromotionServiceTest {
	
	@Mock
	private PromotionService promotionServiceMock;
	
	@InjectMocks
	private PromotionServiceImpl promotionServiceImpl;
	
	
	@Test
	public void injectedTest() {
				
		/** Test with expected interface behavior */
		Integer create = this.promotionServiceImpl.create("PROMOTION", 0.0);
			assertEquals(new Integer(0), create);
			
		create = this.promotionServiceImpl.create("PROMOTION", 25.50);
			assertEquals(new Integer(1), create);
		
		assertFalse(this.promotionServiceImpl.isActive(""));
		
		assertTrue(this.promotionServiceImpl.isActive("1234567890"));
		
		try {
			this.promotionServiceImpl.update("SKU");
			this.promotionServiceImpl.update("");
		} catch (PromotionNotFoundException e) {
			assumeNoException(e);
		}
		
	}
	
	@Test(expected = PromotionNotFoundException.class )
	public void exceptionUpdate() throws PromotionNotFoundException {
		assertFalse( promotionNotFoundException() );
	}
	
	private boolean promotionNotFoundException() throws PromotionNotFoundException {
		throw new PromotionNotFoundException();
	}
	
}
