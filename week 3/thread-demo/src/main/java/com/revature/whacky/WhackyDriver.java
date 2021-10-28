package com.revature.whacky;

public class WhackyDriver {

	public static void main(String[] args) {
		Counter count = new Counter();
		CounterRunnable countJob = new CounterRunnable(count);
		
		Thread t1 = new Thread(countJob);
		Thread t2 = new Thread(countJob);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The final count is " + count.count);
	}

}
