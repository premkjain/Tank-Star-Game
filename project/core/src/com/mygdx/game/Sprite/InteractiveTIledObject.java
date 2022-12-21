package com.mygdx.game.Sprite;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.TankStars;

public abstract class InteractiveTIledObject {
    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Rectangle bounds;
    protected Body body;

    public InteractiveTIledObject(World world,TiledMap map,Rectangle bounds) {
        this.map = map;
        this.world=world;
        this.bounds=bounds;

        BodyDef bdef=new BodyDef();
        FixtureDef fdef=new FixtureDef();
        PolygonShape shape=new PolygonShape();

        bdef.type=BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX()+bounds.getWidth()/2)/ TankStars.PPM,(bounds.getY()+bounds.getHeight()/2)/TankStars.PPM);

        body=world.createBody(bdef);

        shape.setAsBox(bounds.getWidth()/2,bounds.getHeight()/2);
        fdef.shape=shape;
        body.createFixture(fdef);
    }
}
