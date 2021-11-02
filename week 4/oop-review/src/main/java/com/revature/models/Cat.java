package com.revature.models;
// unable to extend because dog is final

//public class Cat extends Dog{

public class Cat extends Animal {
	public Cat(String name) {
		super(name);

	}

	@Override
	public void talk() {
		System.out.println("Meow");
	}

	/*
	 * Overloading refers to having a method of the same name taking in a different number and/or type of parameters to 
	 * execute a similar behavior
	 */
	public void talk(int i) {
		for (int j = 0; j < i; j++) {
			System.out.println("Meow");
		}
	}

	public void eat(String food) {
		System.out.println("Cat doesn't like your food.");
	}
}
