package mx.com.testing1.error;

public class PromotionNotFoundException extends Exception {

	private static final long serialVersionUID = -3935928420682969412L;
	
	public PromotionNotFoundException() {
		super("¡ NO PROMOTION FOUND !");
	}

}
