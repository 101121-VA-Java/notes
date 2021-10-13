public class HelloWorld{
	public static void main(String[] args){
			
		// This a single line comment

		/*
		This is
		a
		multiline comment
		*/
		System.out.println("Hello World!");

		// Primitive datatypes
		
		// Whole numbers
		byte by = 1;
		short sh = 2;
		int in = 6;
		long lo = -123L;

		// Floating points
		float fl = 12.3f;
		double dou = 12.3;
		
		// Boolean
		boolean bo = true;

		// Characters
		char ch = 'C';

		int a; //variable declaration 
		a = 5; // variable initialization/assignment
	
		String s = "Hello World";
		s = new String("Hi");
		String s2 = "Hello World";
		
		if(in == 4){
			System.out.println("in is equal to 4");
		} else if( in == 6){
			System.out.println("Something else");
		}
		else {
			System.out.println("Actually in is equal to: " + in);
		
		}
		
		for(int i = 0; i < in; i++){
			if(i%2 == 0){
				System.out.println("This is iteration: " + i);
			}
		}
		String s3 = new String("Hi");
		System.out.println("is s == s3: " + (s == s3));   
	
		char[] letters = s2.toCharArray();
		
		for(int i = 0; i < 3; i++){
			System.out.println("hello!");
		}

		for(int i = 0; i < letters.length; i++){
			System.out.println("The letter printed out is: " + letters[i]);
		}
		
		for(char l : letters){
			System.out.println("The letter printed out is: " + l);
		}
		
		boolean condition = true;

		while(in < 10 && !condition){
			System.out.println(in);
			in++;
		}

		do{
			System.out.println("hi");
		}while(!condition);
		
	}
}	


