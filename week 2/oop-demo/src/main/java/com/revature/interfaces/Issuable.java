package com.revature.interfaces;

public interface Issuable {

	default void doSomethingElse() {
		System.out.println("Default implementation from issuable");
	}
}
