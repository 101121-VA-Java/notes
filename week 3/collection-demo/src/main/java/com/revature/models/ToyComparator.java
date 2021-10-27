package com.revature.models;

import java.util.Comparator;

public class ToyComparator implements Comparator<Toy> {

	@Override
	public int compare(Toy o1, Toy o2) {
		return o1.getName().length() - o2.getName().length();
	}

}
