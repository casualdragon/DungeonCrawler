package edu.apsu.csci.teamaz.dungeoncrawler.worldobjects;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.util.Size;

/**
 * The GenericEntity class is a subclass of the basic WorldObject. Its serves as the primary class for
 * objects that need to be drawn and can move.
 */

public class GenericEntity extends WorldObject {
    //Constructor
    //Context will be removed later as the object is only going to store the drawable itself.
    public GenericEntity(Point location, int rotation, Size size, int step, Context context) {
        super(location,rotation,size, context, false);
        this.step = step;
    }

    //Methods
    //moves the object
    public void updateRotation(Point targetPoint){
        //this is needs to be researched more
        setRotation((int) Math.toDegrees(Math.atan2(targetPoint.x - mapLocation.x, targetPoint.y - mapLocation.y)));

    }

    public Point calculateNextLocation(){
        Point p = new Point(mapLocation.x, mapLocation.y);
        p.x = p.x - (int) (-step *  Math.sin(Math.toRadians(rotation)));
        p.y = p.y + (int) (step *  Math.cos(Math.toRadians(-rotation)));

        Log.i("=================", "GenericEntity Rotation " + rotation);
        Log.i("=================", "New GenericEntity Location " + p.toString());

        return p;
    }

    //Getters
    public int getStep() {
        return step;
    }

    public int getReverseCount() {
        return reverseCount;
    }

    public int getReverseStep() {
        return reverseStep;
    }


    //Setters
    public void setStep(int step) {
        this.step = step;
    }

    public void setReverseCount(int reverseCount) {
        this.reverseCount = reverseCount;
    }

    public void setReverseStep(int reverseStep) {
        this.reverseStep = reverseStep;
    }


    //Fields
    protected int step;
    protected int reverseCount;
    protected int reverseStep;
}