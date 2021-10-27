package com.revature.models;

public class Toy implements Comparable{

	private String brand;
	private String name;
	
	public Toy(String brand, String name) {
		super();
		this.brand = brand;
		this.name = name;
	}
	public Toy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Toy [brand=" + brand + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Object o) {
		Toy compare = (Toy) o;
		return brand.length() - compare.getBrand().length();
	}
	
}
