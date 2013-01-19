package com.me.Mugwomp;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver implements Screen {


		private BitmapFont font;
		private SpriteBatch batch;
		
		int score = 0;
		
		OrthographicCamera camera;
		
		public GameOver(MugwompGame mugwompGame) {			
			camera = new OrthographicCamera();
		    camera.setToOrtho(false, 800, 480);
		    
		    batch = new SpriteBatch();
		    
		    font = new BitmapFont();
		}
		
		public void setScore(int score) {
			this.score = score;
		}

		@Override
		public void render(float delta) {
			// TODO Auto-generated method stub
			
			//Gdx.gl.glClearColor(0, 0, 0, 1);
		    //Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			
			camera.update();
			
			batch.begin();
			font.setScale(2, 2);
			font.draw(batch, "Game Over", 325, 240);
			font.setScale(1, 1);
			String s = Integer.toString(score);
			font.draw(batch, "Your score: " + s, 350, 210);
			batch.end();
		}

		@Override
		public void resize(int width, int height) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void show() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void hide() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void pause() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void resume() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

	
	
}
