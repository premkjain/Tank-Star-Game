package com.mygdx.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.TankStars;

public class Hud1 implements Disposable{
    public Stage stage;
    private Viewport viewport;

    private Integer health1;
    private Integer health2;
    private Integer decreament;
    private boolean healthCheck;

    private Label healthLabel1;
    private Label healthLabel2;

    public Hud1(SpriteBatch sb){
        health1=10;
        health2=10;
        decreament=2;

        viewport=new FitViewport(TankStars.WIDTH,TankStars.HEIGHT,new OrthographicCamera());
        stage=new Stage(viewport,sb);

        Table table=new Table();
        table.top();
        table.setFillParent(true);

        healthLabel1=new Label(String.format("03d%",health1),new Label.LabelStyle(new BitmapFont(),Color.WHITE));

    }
    @Override
    public void dispose() {
        stage.dispose();
    }
}