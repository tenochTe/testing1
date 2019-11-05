package mx.com.testing1.model;

public class Product {

	private String sku;
	private String description;
	private Double price;

	public static class Builder {
		private String sku;
		private String description;
		private Double price;

		public Builder withSku(String sku) {
			this.sku = sku;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder withPrice(Double price) {
			this.price = price;
			return this;
		}

		public Product build() {
			Product product = new Product();
			product.sku = this.sku;
			product.description = this.description;
			product.price = this.price;
			return product;
		}
	}

	private Product() {
	}

	public String getSku() {
		return sku;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

}
