package com.revature;

public class ThreadDriver {

	public static void main(String[] args) {
		
		Runnable job = () -> {
			System.out.println("This is in a lambda expression.");
		};
		
		HelloThread t1 = new HelloThread();
		Thread t2 = new Thread(new GoodbyeThread());
		Thread t3 = new Thread(job);
		Thread t4 = new Thread(() -> {
			System.out.println("This is in a lambda expression.");
		});
		
		System.out.println("The state of t1(before start) is: " + t1.getState());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		
		try {
			// wait for a thread to finish executing before continuing execution of this thread (in this case main thread)
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("End of the main method");
	}

}

class HelloThread extends Thread{
	
	@Override
	public void run() {
		// thread behavior is specified in the run method
		System.out.println("Hello Thread has started!");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hello");
	}	
}

//Runnable job = () -> {
//	System.out.println("This is in a lambda expression.");
//};

class GoodbyeThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Goodbye Thread has started!");
	}
	
}
