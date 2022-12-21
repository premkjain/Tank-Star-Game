package com.mygdx.game.Screens.screens;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.TankStars;
import jdk.vm.ci.meta.Constant;
//import sun.security.pkcs11.wrapper.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TiledObjectUtil {
    public static void parseTiledObjectLayer(World world, MapObjects objects){
        for(MapObject object : objects){
            Shape shape;
            if(object instanceof PolygonMapObject){
                shape=createPolyline((PolygonMapObject) object);
            } else{
                continue;
            }

            Body body;
            BodyDef bdef=new BodyDef();
            bdef.type=BodyDef.BodyType.StaticBody;
            body=world.createBody(bdef);
            body.createFixture(shape,1.0f);
            shape.dispose();
        }


    }

    private static ChainShape createPolyline(PolygonMapObject polyline){
        float[] vertices= polyline.getPolygon().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length/2];

        for(int i=0;i<worldVertices.length;i++){
            worldVertices[i]=new Vector2(vertices[i*2]/ TankStars.PPM,vertices[i*2+1]/TankStars.PPM);
//            worldVertices[i]=new Vector2(vertices[i*2],vertices[i*2+1]);
        }
        ChainShape cs = new ChainShape();
        cs.createChain(worldVertices);
        return cs;
    }
}
