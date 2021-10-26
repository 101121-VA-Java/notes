package com.revature.models;

public class MyObject {

	private int myNumber;

	public MyObject(int myNumber) {
		super();
		this.myNumber = myNumber;
	}

	public int getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myNumber;
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
		MyObject other = (MyObject) obj;
		if (myNumber != other.myNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyObject [myNumber=" + myNumber + "]";
	}
	
	@Override
	protected void finalize() {
		//MyObject prints out this message before getting garbage collected
		System.out.println("I'm getting garbage collected, myNumber is " + myNumber);
	}
}
