package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Scenes.Hud;
import com.mygdx.game.Sprite.PlayerBody;
import com.mygdx.game.Sprite.PlayerBody2;
import com.mygdx.game.Tools.B2WorldCreator;

public class FightModeScreen implements Screen {
    TankStars game;
    Texture FightModePhoto;
    Texture fireButton;

    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;

    //tiled map variables
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    //Box2d variables
    private World world;
    private Box2DDebugRenderer b2dr;
    private PlayerBody player1;
    private PlayerBody2 player2;

    private TextureAtlas atlas;
    boolean chk=true;

    int fireChance=0;
    // 0-> player1
    // 1-> player2
    public FightModeScreen(TankStars game) {
        atlas=new TextureAtlas("Tanks_weapons_boxes.pack");
        this.game = game;

        fireButton=new Texture("fire.png");
//        FightModePhoto=new Texture("FightPhoto.png");

        gamecam=new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        gamePort=new FitViewport(TankStars.WIDTH/TankStars.PPM,TankStars.HEIGHT/TankStars.PPM,gamecam);
        hud=new Hud(game.batch);

        mapLoader=new TmxMapLoader();
        map=mapLoader.load("level2.tmx");
        renderer=new OrthogonalTiledMapRenderer(map,1/TankStars.PPM);
        gamecam.position.set(gamePort.getWorldWidth()/2,gamePort.getWorldHeight()/2,0);

        world=new World(new Vector2(0,-1000/TankStars.PPM),true);
        b2dr=new Box2DDebugRenderer();

        player1=new PlayerBody(world,this,32,300);
//        player2= new PlayerBody2(world,this,1170,500);
        player2=new PlayerBody2(world,this,1170,500);
        new B2WorldCreator(world,map);
    }

    public TextureAtlas getAtlas(){
        return atlas;
    }

    public void handleInput(float dt){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player2.b2body.getLinearVelocity().x<=2/1000){
            player2.b2body.applyLinearImpulse(new Vector2(100f, 0), player2.b2body.getWorldCenter(), true);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && player2.b2body.getLinearVelocity().x>=-2/1000){
            player2.b2body.applyLinearImpulse(new Vector2(-0100f, 0), player2.b2body.getWorldCenter(), true);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D) && player1.b2body.getLinearVelocity().x<=2/1000){
            player1.b2body.applyLinearImpulse(new Vector2(0100f, 0), player1.b2body.getWorldCenter(), true);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.A) && player1.b2body.getLinearVelocity().x<=2/1000){
            player1.b2body.applyLinearImpulse(new Vector2(-0100f, 0), player2.b2body.getWorldCenter(), true);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.F)){
            bullet missile=new bullet(player1,world);
            missile.fire();
        }
    }

    public void update(float dt){
        handleInput(dt);
        world.step(1/60f,6,2);

//        if(chk==true){
//            player1.update(dt);
//            chk=false;
//        }
//        else{
//            player2.update(dt);
//            chk=true;
//        }
        player1.update(dt);
        player2.update(dt);
//        gamecam.position.x=player.b2body.getPosition().x;
        gamecam.update();
        renderer.setView(gamecam);
    }

    @Override
    public void show() {

    }

    public void FireBullet(){
        System.out.println("hi");
    }



    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        b2dr.render(world,gamecam.combined);

//        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        player1.draw(game.batch);
        player2.draw(game.batch);

        game.batch.end();
        player1.b2body.setLinearVelocity(0,player1.b2body.getLinearVelocity().y);
        player2.b2body.setLinearVelocity(0,player2.b2body.getLinearVelocity().y);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        hud.dispose();

    }
}
