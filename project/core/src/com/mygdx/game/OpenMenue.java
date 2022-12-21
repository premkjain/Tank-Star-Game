package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class OpenMenue implements Screen {
    TankStars game;
    Texture OpenMenueScreen;

    public OpenMenue(TankStars game) {
        this.game = game;
        OpenMenueScreen = new Texture("openMenuePhoto.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(OpenMenueScreen,0,0);

        if(24<=Gdx.input.getX() && Gdx.input.getX()<=343 && 577<=Gdx.input.getY() && Gdx.input.getY()<=656){
            // Resume
            if(Gdx.input.isTouched()){
                game.setScreen(new ResumeModeOptionScreen(game));
            }
        }

        if(488<=Gdx.input.getX() && Gdx.input.getX()<=819 && 620<=Gdx.input.getY() && Gdx.input.getY()<=700){
            // Start
            if(Gdx.input.isTouched()){
                game.setScreen(new GameModeOptionScreen(game));
            }
        }

        if(923<=Gdx.input.getX() && Gdx.input.getX()<=1260 && 548<=Gdx.input.getY() && Gdx.input.getY()<=630){
            // Exit
            if(Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }

//        System.out.println(Gdx.input.getX()+" "+Gdx.input.getY());
        game.batch.end();
    }
    @Override
    public void show() {

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
