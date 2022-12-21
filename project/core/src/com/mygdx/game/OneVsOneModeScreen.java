package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class OneVsOneModeScreen implements Screen {
    TankStars game;
    Texture OneVsOneModePhoto;

    public OneVsOneModeScreen(TankStars game) {
        this.game = game;
        OneVsOneModePhoto=new Texture("OneVsOneModePhoto.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(OneVsOneModePhoto,0,0);

        if(385<=Gdx.input.getX() && Gdx.input.getX()<=878 && 286<=Gdx.input.getY() && Gdx.input.getY()<=403){
            // select tank
            if(Gdx.input.isTouched()){
                game.setScreen(new PlayerTankSelectMode(game));
            }
        }

        if(385<=Gdx.input.getX() && Gdx.input.getX()<=878 && 521<=Gdx.input.getY() && Gdx.input.getY()<=644){
            // fight
            if(Gdx.input.isTouched()){
                game.setScreen(new FightModeScreen(game));
            }
        }

//        System.out.println("hi");
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
