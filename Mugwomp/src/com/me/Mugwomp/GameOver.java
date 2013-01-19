package com.me.Mugwomp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver implements Screen {


	
		private SpriteBatch batch;
		
		Texture player1win;
		Texture player2win;
		
		int player1count;
		int player2count;
		
		OrthographicCamera camera;
		
		public GameOver(MugwompGame mugwompGame) {			
			camera = new OrthographicCamera();
		    camera.setToOrtho(false, 800, 480);
		    
		    batch = new SpriteBatch();
		  
		}

		@Override
		public void render(float delta) {
			// TODO Auto-generated method stub
			
			Gdx.gl.glClearColor(0, 0, 0, 1);
		    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			
			camera.update();
			
			batch.begin();
			
			
			if(player1count == 0)
			{
				player2win = new Texture(Gdx.files.internal("Player_2_Win.png"));
				batch.draw(player2win, 0, 0);
			}
			if(player2count == 0)
			{

				player1win = new Texture(Gdx.files.internal("Player_1_Win.png"));
				batch.draw(player1win, 0, 0);
			}
		
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
