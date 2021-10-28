package com.revature.whacky;

public class CounterRunnable implements Runnable{

	Counter c;
	
	public CounterRunnable(Counter c) {
		super();
		this.c = c;
	}

	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			c.increment();
		}
	}

}
