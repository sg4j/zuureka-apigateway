package org.apache.restservicedemo.model;

public class Product {

	public Product(){
		
	}
	
	public Product(int productId, String name, int weight) {
		super();
		this.productId = productId;
		this.name = name;
		this.weight = weight;
	}

	private int productId;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	private String name;

    private int weight;
}
