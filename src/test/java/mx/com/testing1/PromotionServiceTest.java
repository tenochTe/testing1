package mx.com.testing1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import mx.com.testing1.facade.PromotionFacade;
import mx.com.testing1.service.PromotionService;

@ContextConfiguration("spring/app-context.xml")
@RunWith(MockitoJUnitRunner.class)
public class PromotionServiceTest {
	
	private final ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("spring/app-context.xml");
	private final PromotionService promotionService = (PromotionService) context.getBean("promotionService");
	
	@Before
	public void beforeTest() {
		
	}

	@Test
	public void addingBehaviorTest() {
		PromotionService promotionServiceMock = Mockito.mock(PromotionService.class);
		
		/** Mock implementation of methods from service interface  */
		Mockito.when(promotionServiceMock.create("")).thenReturn(0);
		Mockito.when(promotionServiceMock.create("PROMOTION")).thenReturn(1);
		Mockito.when(promotionServiceMock.isActive("")).thenReturn(false);
		Mockito.when(promotionServiceMock.isActive("1234567890")).thenReturn(true);
		
		/** Test with expected behavior */
		Integer create = promotionServiceMock.create("");
			assertEquals(new Integer(0), create);
		create = promotionServiceMock.create("PROMOTION");
			assertEquals(new Integer(1), create);
		
		assertFalse("No Active", promotionServiceMock.isActive(""));
		assertTrue("Is Active",promotionServiceMock.isActive("1234567890"));
		
		
	}
}
