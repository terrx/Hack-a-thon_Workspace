package com.me.Mugwomp;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainMenuScreen implements Screen {

	MugwompGame game;
	
	
	Texture backgroundimage;
	
	OrthographicCamera camera;
	SpriteBatch batch;
	
	
	public MainMenuScreen(MugwompGame mugwompGame) {
		game = mugwompGame;
		Texture.setEnforcePotImages(false);
		backgroundimage = new Texture(Gdx.files.internal("Main_Menu.png"));
		
		camera = new OrthographicCamera();
	      camera.setToOrtho(false, 800, 800);
	      
	      batch = new SpriteBatch();
	      
	      
	    
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		 
	    batch.begin();
	    batch.draw(backgroundimage, 0, 0);
		batch.end();
		
		 if(Gdx.input.isTouched()) 
		 { 
			 Vector3 touchPos = new Vector3(); 
			 touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0); 
			 camera.unproject(touchPos); 
			 //System.out.println("X:" + touchPos.x + " Y:" + touchPos.y); 
			 Rectangle startbutton = new Rectangle();
			 
			 startbutton.x =257;
			 startbutton.y = 247;
			 startbutton.width = 278;
			 startbutton.height = 103;
			 
			if (startbutton.contains(touchPos.x, touchPos.y))
			{
				game.selectionScreen();
			}
		
		 
		}
		
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
		backgroundimage.dispose();
		
	}
	
}


