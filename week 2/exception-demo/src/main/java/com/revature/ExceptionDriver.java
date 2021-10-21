package com.revature;

import java.util.Scanner;

import com.revature.exceptions.FortyTwoException;

public class ExceptionDriver {
	public static void main(String[] args) {

		// Array OO bounds E - preventable with validation | Runtime Exception
		int[] arr = new int[3];
		if (arr.length >= 6) {
			arr[5] = 5;
		}

//		Scanner sc = new Scanner(System.in);
//		int i = sc.nextInt();
//		i = i/0;
//		sc.close();

		// Arithmetic exception | Runtime
		// bad practice to handle runtime exception, should git gud at writing code instead
//		try {
//			int i = 1 / 0;
//		} catch (ArithmeticException | IndexOutOfBoundsException e) {
//			System.out.println("Arithmetic / IOOBException exception behavior");
//			e.printStackTrace();
//		} catch (Exception e) {
//			System.out.println("Handle any exception");
//			e.printStackTrace();
//		}
		ExceptionDriver ed = new ExceptionDriver();
//		
		Scanner sca = new Scanner(System.in);
		try {
			// put risky code here | code that can throw an exception
			
			ed.noInfo();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// always executes
			System.out.println("Hi, I'm always executing");
			sca.close();
		}

		// try with resources, closes the scanner at the end
		try(Scanner scan = new Scanner(System.in);){
			
		}
		
		int a = ed.add(42, 0);
		
		System.out.println("End of the main method");
	}

	public void throwException() throws Exception {
		throw new Exception();
	}
	
	public void noInfo() throws Exception {
		ExceptionDriver ed = new ExceptionDriver();
		ed.throwException();
	}
	
	public int add(int a, int b) {
		int result = a + b;
		if(result == 42) {
			throw new FortyTwoException();
		}
		return result;
	}
 }
