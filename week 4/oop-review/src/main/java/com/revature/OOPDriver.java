package com.revature;

import com.revature.interfaces.Talkable;
import com.revature.models.Animal;
import com.revature.models.Cat;
import com.revature.models.Dog;

public class OOPDriver {

	public static void main(String[] args) {
		
		/*
		 *  Classes are used as blue print to instantiate objects, or instances of these classes. 
		 *  The objects may have different values for their fields/properties
		 *  
		 *  To create an instance a Constructor is called.
		 *  if NO constructor(no args or otherwise) is defined, java will provide a default no-args constructor.
		 *  Animal is an abstract class
		 */
//		Animal a1 = new Animal("Kevin");
		
		Animal a1 = new Dog("Kevin");
		
		// cannot access the name property directly because the field is private
//		a1.name = "Kevin";
		
		a1.setName(null);
		
		// Upcasting to parent class or interface
		Animal d = new Dog("Fluffy");
		Cat c = new Cat("Kitty");
		Talkable c1 = new Cat("Kitty");
		/*
		 * Because Dog inherited from Animal, dog is able to call the methods defined in Animal such as .getName()
		 */
		System.out.println("Dog name: " + d.getName());
		System.out.println(d);
		d.eat("Potatoes");
		c.eat("Mushrooms");
		
		c.talk(5);
		
		// only methods/fields declared in the parent class/ interface are available to an instance when upcasting.
		c1.talk();
	}

}
