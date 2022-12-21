package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class GameModeOptionScreen implements Screen {
    TankStars game;
    Texture GameModeOptionPhoto;
    public GameModeOptionScreen(TankStars game) {
        this.game=game;
        GameModeOptionPhoto=new Texture("GameModeOptionPhoto.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(GameModeOptionPhoto,0,0);

        if(26<=Gdx.input.getX() && Gdx.input.getX()<=264 && 27<=Gdx.input.getY() && Gdx.input.getY()<=85){
            // Back
            if(Gdx.input.isTouched()){
                game.setScreen(new OpenMenue(game));
            }
        }

        if(744<=Gdx.input.getX() && Gdx.input.getX()<=1237 && 295<=Gdx.input.getY() && Gdx.input.getY()<=421){
            //
            if(Gdx.input.isTouched()){
                game.setScreen(new OneVsOneModeScreen(game));
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
