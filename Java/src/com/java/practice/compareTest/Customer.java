package com.java.practice.compareTest;

public class Customer implements Comparable<Customer> {

	private String name;
	private int age;
	private int price;
	
	
	public Customer(String name, int age, int price) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int compareTo(Customer arg0) {
		
		return this.getAge() > arg0.getAge() ? 1 : 
					( this.getAge() < arg0.getAge() ? -1 : 0);
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", price=" + price + "]";
	}
	
}
