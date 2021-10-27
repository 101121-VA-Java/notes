package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import com.revature.models.Toy;
import com.revature.models.ToyComparator;

public class Driver {

	public static void main(String[] args) {
		Toy toy1 = new Toy("Mattel", "Doll");
		Toy toy2 = new Toy("Hasbro1", "Board game");
		Toy toy3 = new Toy("Lego", "Star wars");
		Toy toy4 = new Toy("Lego", "Star wars");
		
		// Used to enforce type safety
		ArrayList<Toy> toyArrList = new ArrayList<>();
		toyArrList.add(toy1);
		toyArrList.add(toy2);
		toyArrList.add(toy3);
		toyArrList.add(toy4);
//		toyArrList.add("Random String"); use generics to prevent other types to be added
		
		for(int i = 0; i < toyArrList.size(); i++) {
			System.out.println(toyArrList.get(i).getBrand());
		}
		
		for(Toy toy : toyArrList) {
			System.out.println(toy.getBrand());
		}
		
		Iterator<Toy> i = toyArrList.iterator();
		while(i.hasNext()) {
			System.out.println(i.next()); // returns the element and moves the iterator past it
		}
		
		// Better practice to upcast to the interface
		List<Toy> toyList = new ArrayList<>(toyArrList);
		
		System.out.println();
		System.out.println("SET:");
		System.out.println();
		
		Set<Toy> toySet = new HashSet<>(toyList);
		Iterator<Toy> s = toySet.iterator();
		while(s.hasNext()) {
			System.out.println(s.next());
		}
		
		System.out.println();
		
		Set<Toy> treeToy = new TreeSet<>(toySet);
		Iterator<Toy> ts = treeToy.iterator();
		while(ts.hasNext()) {
			System.out.println(ts.next());
		}
		
		System.out.println();
		
		Set<Integer> tree = new TreeSet<>();
		tree.add(2);
		tree.add(5);
		tree.add(3);
		tree.add(2);
		
		Iterator<Integer> t = tree.iterator();
		while(t.hasNext()) {
			System.out.println(t.next());
		}
		
		int[] intArr = new int[4]; // Arrays do not implement Collection, and as such do not have access to Collection methods
		
		Queue<Toy> qToy = new LinkedList<>(toySet);
		System.out.println(qToy.peek());
		System.out.println(qToy.poll());
		System.out.println(qToy.poll());
		
		System.out.println();
		System.out.println("Maps");
		System.out.println();
		
		Map<Integer, Toy> hm = new HashMap<>();
		hm.put(1, toy1);
		hm.put(2, toy2);
		hm.put(3, toy3);
		hm.put(3, toy4);
		
		/*
		 *  Cannot iterate over maps the traditional way
		 *  	- retrieve a set of key which is iterable
		 *  	- get the value of the element at a key in the map
		 */
		for(Integer key : hm.keySet()) {
			System.out.println(hm.get(key));
		}
		
		System.out.println("Comparator sorting:");
		
		Collections.sort(toyArrList, new ToyComparator());
		
		for(Toy toy : toyArrList) {
			System.out.println(toy.getName());
		}
		int[] intArr1 = {1 , 2 };
		String[] stringArr = {"Hello", "world"};
	}

//	public static void printAll(String[] arr) {
//		for(String s : arr) {
//			System.out.println(s);
//		}
//	}
//	
//	public static void printAll(int[] arr) {
//		for(int s : arr) {
//			System.out.println(s);
//		}
//	}
	
	public static <T> void printAll(T[] arr) {
		for(T t : arr) {
			System.out.println(t);
		}
	}
}
