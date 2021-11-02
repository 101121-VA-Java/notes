package com.revature.models;

/*
 * Inheritance allows subclasses/children classes to use the parents states and behaviors.
 * final on a class indicates that it cannot be extended
 */
public final class Dog extends Animal{

	private boolean isDrooling;
	
	public Dog(String name) {
		super(name);
		// if the name field which has been defined in the Animal class is as private and it will not be visible in child classes
//		this.setName("NewName");
//		this.name = "myDog";
		
		// super is a reference to the parent's implementations and methods
		// this is a reference to the current class' implementation
		System.out.println("this.toString(): + " + this.toString());
		System.out.println("super.toString(): + " + super.toString());
	}

	public boolean isDrooling() {
		return isDrooling;
	}

	public void setDrooling(boolean isDrooling) {
		this.isDrooling = isDrooling;
	}

	
	//Overriding the parent's implementation of toString to be more relevant to the child class (ie: including isDrooling field)
	@Override
	public String toString() {
		return "Dog [isDrooling=" + isDrooling + ", name=" + name + "]";
	}

	@Override
	public void talk() {
		System.out.println("Woof");
	}

//	@Override
//	public String toString() {
//		return "Dog [name = " + this.getName() + ", isDrooling=" + isDrooling + "]";
//	}

	
	
}
