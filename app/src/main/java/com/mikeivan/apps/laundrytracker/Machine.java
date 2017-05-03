package com.mikeivan.apps.laundrytracker;

/**
 * Created by Mivan on 4/22/2017.
 */

public class Machine {

    private String mType;
    private String mName;
    private int mTime;

    public Machine(String type, String name, int time) {
        mType = type;
        mName = name;
        mTime = time;
    }

    public String getType() { return mType; }

    public String getName()  { return mName; }

    public int getTime() { return mTime; }
}
