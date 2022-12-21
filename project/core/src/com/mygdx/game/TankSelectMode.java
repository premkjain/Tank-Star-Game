package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class TankSelectMode implements Screen {
    TankStars game;
    Texture TankSelectModePhoto;

    public TankSelectMode(TankStars game) {
        this.game = game;
        TankSelectModePhoto=new Texture("TankSelectPhoto.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(TankSelectModePhoto,0,0);

        if(26<=Gdx.input.getX() && Gdx.input.getX()<=266 && 27<=Gdx.input.getY() && Gdx.input.getY()<=88){
            // back
            if(Gdx.input.isTouched()){
                game.setScreen(new PlayerTankSelectMode(game));
            }
        }

        if(19<=Gdx.input.getX() && Gdx.input.getX()<=265 && 456<=Gdx.input.getY() && Gdx.input.getY()<=515){
            // abramas
            if(Gdx.input.isTouched()){
                game.setScreen(new FightModeScreen(game));
            }
        }

        if(479<=Gdx.input.getX() && Gdx.input.getX()<=746 && 456<=Gdx.input.getY() && Gdx.input.getY()<=515){
            // pumkin
            if(Gdx.input.isTouched()){
                game.setScreen(new FightModeScreen(game));
            }
        }

        if(999<=Gdx.input.getX() && Gdx.input.getX()<=1244 && 456<=Gdx.input.getY() && Gdx.input.getY()<=515){
            // frost
            if(Gdx.input.isTouched()){
                game.setScreen(new FightModeScreen(game));
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
