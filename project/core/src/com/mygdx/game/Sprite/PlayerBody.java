package com.mygdx.game.Sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.FightModeScreen;
import com.mygdx.game.TankStars;

public class PlayerBody extends Sprite {
    public World world;
    public Body b2body;
    private TextureRegion tankStand;

    public PlayerBody(World world, FightModeScreen screen, int x, int y) {
        super(screen.getAtlas().findRegion("Spectre"));
        this.world = world;
        defineTank(x,y);
        tankStand=new TextureRegion(getTexture(),0,136,128,75);
        setBounds(0,0,128/ TankStars.PPM,75/TankStars.PPM);
        setRegion(tankStand);
    }

    public float getPosX(){
        return b2body.getPosition().x;
    }

    public float getPosY(){
        return b2body.getPosition().y;
    }

    public void update(float dt){
        setPosition(b2body.getPosition().x-getWidth()/2,b2body.getPosition().y-getHeight()/2);
    }

    public void defineTank(int x,int y){
        BodyDef bdef=new BodyDef();
        bdef.position.set(x,y);
        bdef.type=BodyDef.BodyType.DynamicBody;
        b2body=world.createBody(bdef);

        FixtureDef fdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(20);

        fdef.shape=shape;
        b2body.createFixture(fdef);
    }
}
