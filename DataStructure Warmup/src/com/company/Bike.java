package com.company;

/**
 * Created by Dereck on 0001, March 1, 2017.
 */
public class Bike {
    private int size;
    private int height;
    private int type;

    public Bike(int startsize, int startheight, int starttype){
        size = startsize;
        height = startheight;
        type = starttype;
    }

    public int getsize(){ return size;}

    public int getheight(){return height;}

    public int gettype(){return type;}

}
