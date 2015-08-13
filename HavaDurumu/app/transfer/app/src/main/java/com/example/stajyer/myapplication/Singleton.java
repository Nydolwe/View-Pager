package com.example.stajyer.myapplication;

/**
 * Created by stajyer on 10.08.2015.
 */
public class Singleton {


    private static Singleton instance;

    public Person person;

    private Singleton(){}


    public static Singleton getInstance(){
        if(instance==null)
            instance = new Singleton();

        return instance;
    }

}