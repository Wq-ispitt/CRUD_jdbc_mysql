package com.demo.crud;

public class Products {
	
	//table: products   
	//database: testdb
	//table fields: p_id(auto), p_name, p_price, category_id, model_year 
	
	int id;
	String name;
	double price;
	int categoryId;
	int modelYear;
	
	public Products() {
		
	}
	
	public Products(String name, double price, int categoryId, int modelYear) {
		super();
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.modelYear = modelYear;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	
	
	//for console application, printing each record, avoid 4 lines of sysout in main method
	@Override
	public String toString() {
		return id + " " +name+ " " + price + " " + categoryId + " " + modelYear;
	}
	

}
