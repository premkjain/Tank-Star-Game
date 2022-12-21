package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class PlayerTankSelectMode implements Screen {
    TankStars game;
    Texture PlayerTankSelectPhoto;

    public PlayerTankSelectMode(TankStars game) {
        this.game = game;
        PlayerTankSelectPhoto=new Texture("PlayerTankSelectPhoto.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(PlayerTankSelectPhoto,0,0);

        if(387<=Gdx.input.getX() && Gdx.input.getX()<=883 && 223<=Gdx.input.getY() && Gdx.input.getY()<=346){
            // player1
            if(Gdx.input.isTouched()){
                game.setScreen(new TankSelectMode(game));
            }
        }

        if(380<=Gdx.input.getX() && Gdx.input.getX()<=886 && 526<=Gdx.input.getY() && Gdx.input.getY()<=647){
            // player 2
            if(Gdx.input.isTouched()){
                game.setScreen(new TankSelectMode(game));
            }
        }

//        System.out.println(Gdx.input.getX()+" "+Gdx.input.getY());
        game.batch.end();
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

    }
}
