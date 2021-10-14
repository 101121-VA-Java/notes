package com.revature.models;

public class Human{
   public String hairColor;
   public int age;
   public String name;
   public boolean isRightHanded;

    public Human(){}

    public Human(String name){
        this.name = name;
    }

    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String eat(String food){
        return "I'm eating " + food;
    }

    public void sleep(){
        System.out.println("zzzz");
    }
}