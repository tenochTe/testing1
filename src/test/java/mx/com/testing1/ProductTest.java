package mx.com.testing1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

import mx.com.testing1.model.Product;

public class ProductTest {
	
	@Test
	public void spyRealTest() {
		
		/** Define real object to Spy ( Map, Array, StringBuilder ) */
		Product product =new Product.Builder()
				.withSku(null)
				.withPrice(0.0)
				.withDescription(null)
				.build();
		
		assertNull( product.getSku() );
		assertNotNull( product.getPrice() );
		assertFalse( product.getPrice() > 0.0 );
		assertNull( product.getDescription() );
				
		/** Spy Object with real behavior*/
		Product spyProduct = Mockito.spy(product);
		
			assertNull( spyProduct.getSku() );
			assertNotNull( spyProduct.getPrice() );
			assertFalse( spyProduct.getPrice() > 0.0 );
			assertNull( spyProduct.getDescription() );
			
		/** Define behavior to Spy Object */
		Mockito.when( spyProduct.getSku()).thenReturn("1234567890");
		Mockito.when( spyProduct.getPrice()).thenReturn(50.00);
		Mockito.when( spyProduct.getDescription()).thenReturn("-");
		
			assertTrue( spyProduct.getSku().length() > 0 );
			assertNotNull( spyProduct.getPrice() );
			assertTrue( spyProduct.getPrice() >= 50.00 );
			assertTrue( spyProduct.getDescription().contains("-") );

	}

}
