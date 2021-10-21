package com.revature.interfaces;

// interface declaration
public interface Doable extends DoesNothingable, Cloneable {

	// public static final int napLength = 8;
	int napLength = 8;
	
	void doSomething();
	
	default void doSomethingElse() {
		System.out.println("Default implementation");
	}
}
