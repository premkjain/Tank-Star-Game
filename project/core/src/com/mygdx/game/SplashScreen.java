package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.OpenMenue;
import com.mygdx.game.TankStars;

public class SplashScreen implements Screen {
    TankStars game;
    private float progress;
    Texture background;
    private final ShapeRenderer shapeRenderer;

    public SplashScreen(TankStars game) {
        this.game=game;
        this.shapeRenderer=new ShapeRenderer();
        background = new Texture("Splash.png");
        queueAssets();
    }

    private void queueAssets() {
        game.assets.load("Splash.png",Texture.class);

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        update(delta);
        game.batch.begin();
        game.batch.draw(background,0,0);
        game.font.draw(game.batch,"LOADING....",350,60);
        game.batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(350,80,500,40);

        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(350,80,progress *500,40);
        shapeRenderer.end();
    }

    private void update(float delta) {
        progress = MathUtils.lerp(progress, game.assets.getProgress(), .1f);
//        System.out.println(progress + " " + game.assets.getProgress());
        if (game.assets.update() && progress + .000001f == game.assets.getProgress()) {
            game.setScreen(new OpenMenue(game));
        }
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
        shapeRenderer.dispose();
        background.dispose();
    }
}