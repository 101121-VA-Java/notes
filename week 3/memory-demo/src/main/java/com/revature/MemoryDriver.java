package com.revature;

import com.revature.models.MyObject;

public class MemoryDriver {

	public static void main(String... args) {
		int a = 5;
		
		System.out.println("The value of a: " + a);
		
		System.out.println("The method returns: " +addOne(a));
		
		System.out.println("The value of a: " + a);
		
		MyObject me = new MyObject(5);
		
		System.out.println("The value of my number is " + me.getMyNumber());
		
		System.out.println("The method returns " + addOneToObj(me));
		
		System.out.println("The value of my number is " + me.getMyNumber());
		
		MemoryDriver.garbageMyObject();
	}
	
	public static int addOne(int i) {
		i = i + 1;
		return i;
	}
	
	public static MyObject addOneToObj(MyObject mo) {
		
		// set mynumber to mynumber + 1
		mo.setMyNumber(mo.getMyNumber() + 1);
		
		return mo;
	}
	
	public static void garbageMyObject() {
		MyObject o = new MyObject(-1);
		
		/*
		 * For every iteration of the loop, o is reassigned to a new Instance of MyObject. 
		 * As a result all of the previously created objects are no longer referenced and therefore eligible for
		 * gc.
		 */
		for(int i = 0; i < 100; i++) {
			o = new MyObject(i);
			System.out.println("in loop " + i);
			System.gc();
		}
	}
	
	public static void wrapperClasses() {
		int i = 0;
		Integer in = 0; // wrapper class for int
		
		Integer wrap = i; // Autoboxing int -> Integer wrapper class
		int basic =  in; // AutoUnboxing Integer -> int, don't need an explicit cast
		
		String myNum = "5";
		int number = Integer.parseInt(myNum);// converts an string to an int 
		
	}
}
