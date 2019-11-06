package mx.com.testing1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.com.testing1.facade.PromotionFacade;
import mx.com.testing1.model.Product;

public class App {
	
    private static ClassPathXmlApplicationContext context;

	public static void main( String[] args ) {
    	
        context =new ClassPathXmlApplicationContext("spring/app-context.xml");
        PromotionFacade promotionFacade = (PromotionFacade) context.getBean("promotionFacade");
    	
    	Product p1 =new Product.Builder()
    			.withSku("131234324")
    			.withDescription("Zapatos ABC")
    			.withPrice(2566.60)
    			.build();
    	
        System.out.println( "FINAL: "+promotionFacade.getPromotion(p1.getSku(), p1.getPrice(), 22.00) );
        
    }
    
}
