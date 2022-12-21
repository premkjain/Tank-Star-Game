package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.Sprite.PlayerBody;

import java.awt.*;

public class bullet extends Sprite {
    private Body bullet;
    private BodyDef b=new BodyDef();
    private PlayerBody b2body;
    private World world;
    public bullet(PlayerBody fd,World world){
        super(new Texture("missile_1.png"));
        this.b2body=fd;
        this.world=world;
    }

    public void fire(){
        b.type = BodyDef.BodyType.DynamicBody;
        CircleShape ballshape = new CircleShape();
        ballshape.setRadius(10);

        FixtureDef bulletF = new FixtureDef();
        bulletF.shape = ballshape;
        bulletF.density = 0.00000003f;
        bulletF.friction = 0.000004f;
        bulletF.restitution = 0100f;

        b.position.set(b2body.getPosX()+40, b2body.getPosY()+25);

        bullet = world.createBody(b);
        bullet.createFixture(bulletF).setUserData("bullet");
//        bullet.applyLinearImpulse((ball.getPosition().x)*200, (ball.getPosition().y)*100, ball.getPosition().x, ball.getPosition().y, true);
//        bullet.applyLinearImpulse((aim1.getX())*100, (aim1.getY())*90, b2body.getPosX()+40, b2body.getPosY()+25, true);

        bullet.applyLinearImpulse(100, 100, b2body.getPosX()+4000, b2body.getPosY()+2500, true);

//        com.mygdx.game..b2body.applyLinearImpulse(new Vector2(-0100f, 0), player2.b2body.getWorldCenter(), true);
//        bullet.applyLinearImpulse(new Vector2(-100f,0),bullet.getWorldCenter(),true);
//        bullet.applyForceToCenter(100,100,true);
    }

}
