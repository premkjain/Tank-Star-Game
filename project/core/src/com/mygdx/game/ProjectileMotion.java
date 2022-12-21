package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.sun.org.apache.bcel.internal.generic.PUSH;

public class ProjectileMotion {
    public float gravity;
    public Vector2 startVelocity=new Vector2();
    public Vector2 startPoint = new Vector2();

    public float getX(float t){
        return startPoint.x*t+startPoint.x;
    }

    public float getY(float t){
        return 0.5f*gravity*t*t+startVelocity.y*t+startPoint.y;
    }
}
