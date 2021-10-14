package com.revature.driver;

import com.revature.models.Human;

public class Driver{

    public static void main(String[] args){

        Human kevin = new Human();
        
        Human dean = new Human("Dean");

        Human michael = new Human("Michael", 25);

        System.out.println(dean.name);
        System.out.println(michael.age);

        System.out.println(dean.eat("rice"));
        michael.sleep();
    }
}