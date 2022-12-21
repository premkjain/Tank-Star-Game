package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TankStars extends Game {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	public static final float PPM=1f;
	public static Music music = null;
	public SpriteBatch batch;

	public AssetManager assets;
	public BitmapFont font;

	public TankStars() {
	}

	@Override
	public void create(){
		font=new BitmapFont();
		assets = new AssetManager();
		Sound sound;
		music = (Music) Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);

		music.play();
		batch=new SpriteBatch();
//		this.setScreen(new MainMenueScreen(this));
//		this.setScreen(new OpenMenue(this));
//		this.setScreen(new FightModeScreen(this));
		this.setScreen(new SplashScreen(this));
	}

	@Override
	public void render(){
		super.render();
	}
}
