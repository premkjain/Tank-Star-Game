package com.mygdx.game.Sprite;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

import java.util.BitSet;

public class Bricks extends InteractiveTIledObject{
    public Bricks(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
    }
}
