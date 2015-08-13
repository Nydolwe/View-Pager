package com.example.stajyer.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by stajyer on 10.08.2015.
 */
public class Person implements Parcelable {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String toString(){
        return "" +name;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);

    }

    public Person(){

    }

    public Person(Parcel in){

        this.name = in.readString();

    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Object[] newArray(int size) {
            return new Object[0];
        }
    };

}
