package com.example.segundoauqui.zooapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Blob;

/**
 * Created by segundoauqui on 8/11/17.
 */

public class MyContacs implements Parcelable {
    int id;
    String Name;
    String Clase;
    String Order;
    String Range;

    public MyContacs(int id, String name, String clase, String order, String range) {
        this.id = id;
        Name = name;
        Clase = clase;
        Order = order;
        Range = range;
    }

    protected MyContacs(Parcel in) {
        id = in.readInt();
        Name = in.readString();
        Clase = in.readString();
        Order = in.readString();
        Range = in.readString();
    }

    public static final Creator<MyContacs> CREATOR = new Creator<MyContacs>() {
        @Override
        public MyContacs createFromParcel(Parcel in) {
            return new MyContacs(in);
        }

        @Override
        public MyContacs[] newArray(int size) {
            return new MyContacs[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getClase() {
        return Clase;
    }

    public void setClase(String clase) {
        Clase = clase;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        Order = order;
    }

    public String getRange() {
        return Range;
    }

    public void setRange(String range) {
        Range = range;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(Name);
        dest.writeString(Clase);
        dest.writeString(Order);
        dest.writeString(Range);
    }
}