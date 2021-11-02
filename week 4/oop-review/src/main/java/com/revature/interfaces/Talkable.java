package com.revature.interfaces;

// An interface is NOT a class
public interface Talkable {

	// implicitely public static final
	double speedOfLight = 300000000;
	
	// by default, methods declared in an interface are public and abstract
	void talk();
	
	// The only way to provide an implementation to a method in an interface is to use the 'default' keyword
	public default void eat(String food) {
		System.out.println("eating " + food + " at " + speedOfLight);
	}
}
