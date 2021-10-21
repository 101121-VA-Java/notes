package com.revature.driver;

import com.revature.models.RegularTask;
import com.revature.models.User;

public class FinalDriver {

	public static void main(String[] args) {
		RegularTask rt = new RegularTask();
		
		System.out.println(rt.specificInt);
		
		// Cannot reassign a final variable
		//rt.specificInt = 5;

		System.out.println(rt.assignedUser);
		
		rt.assignedUser.name = "Bobby";
		// cannot reassigned to a new user
		//rt.assignedUser = new User("Please");
		
		System.out.println(rt.assignedUser);
	}

}
