package com.company;

/**
 * Created by Dereck on 0001, March 1, 2017.
 */
public class RoadBike extends Bike{
    private int wheel;
    private int handlebar;

    public RoadBike(int startsize, int startheight, int starttype, int startwheel, int starthandlebar){
        super(startsize, startheight, starttype);
        wheel = startwheel;
        handlebar = starthandlebar;
    }
}
