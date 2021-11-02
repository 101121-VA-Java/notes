package com.revature.models;

import com.revature.interfaces.Talkable;

/*
 * In order to have abstract methods in the class, the class needs to be abstract
 * the class doesn't need to have abstract methods to be abstract
 * Abstract classes are usually used to create templates for other classes to build from, but don't an instance of that template
 */
public abstract class Animal implements Talkable, Cloneable{

	/*
	 *  fields/ properties that describe an animal
	 *  
	 *  Encapulation refers to restricting the access of the members of the class using access modifiers
	 */
	protected String name;

	// because a parameterized constructor was provided, the default no-args constructor is not generated, forcing users to use the constructor defined
//	private Animal() {
//		super();
//	}
	/*
	 * In order to instantiate Animal, would need to override the abstract talk() method
	 * but implementing the method here wouldn't make sense
	 */
//	@Override
//	public void talk() {
//		System.out.println("Generic animal noise");
//	}
	public Animal(String name) {
		this.name = name;
	}

	// retrieve the value of a field
	public String getName() {
		return name;
	}

	// change/manipulate the value of that field
	public void setName(String name) {
		// can specify logic before the field is set, in this case make sure the name isn't empty and not null
		if(name == null || name.equals("")) {
			System.out.println("Invalid name.");
		}
		this.name = name;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Animal other = (Animal) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
