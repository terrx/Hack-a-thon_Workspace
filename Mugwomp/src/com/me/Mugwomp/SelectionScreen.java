package com.me.Mugwomp;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class SelectionScreen implements Screen {
	
	MugwompGame game;
	
	Texture backgroundimage;
	Texture backgroundimage2;
	Texture monster1image;
	Texture monster2image;
	Texture monster3image;
	Texture monster4image;
	Texture monster5image;
	Texture monster6image;
	Texture donereadyimage;
	Texture donedisabledimage;
	Texture player1image;
	Texture player2image;
	Texture selectimage;
	Texture deselectimage;
	Texture backimage;
	Texture head1image;
	Texture head2image;
	Texture head3image;
	Texture head4image;
	Texture head5image;
	Texture head6image;
	
	Texture mini1image;
	Texture mini2image;
	Texture mini3image;
	Texture mini4image;
	Texture mini5image;
	Texture mini6image;
	
	boolean player = false;
	boolean done = false;
	boolean click = true;
	boolean select1 = false;
	boolean select2 = false;
	boolean select3 = false;
	boolean select4 = false;
	boolean select5 = false;
	boolean select6 = false;
	
	boolean once = false;
	
	boolean selecting; 
	
	String page = "default";
	
	int monster = 0;
	
	ArrayList<Monster> monsters = new ArrayList<Monster>();
	ArrayList<String> selected = new ArrayList<String>();
	ArrayList<String> selected2 = new ArrayList<String>();
	
	final double[] WATER_BODY = {1, .5, 2, 1, 1, 2, 1};
	final double[] FIRE_BODY = {2, 1, 1, .5, 1, .5, 1};
	final double[] AIR_BODY = {.5, 1, 1, 1, 2, 1, 1};
	final double[] PLANT_BODY = {1, 2, 1, 1, .5, 1, 1};
	final double[] EARTH_BODY = {1, 1, .5, 2, 1, 1, 1};
	
	OrthographicCamera camera;
	SpriteBatch batch;
	
	Rectangle donebutton = new Rectangle();
	Rectangle monster1 = new Rectangle();
	Rectangle monster2 = new Rectangle();
	Rectangle monster3 = new Rectangle();
	Rectangle monster4 = new Rectangle();
	Rectangle monster5 = new Rectangle();
	Rectangle monster6 = new Rectangle();
	
	Rectangle selectbutton = new Rectangle();
	Rectangle backbutton = new Rectangle();
	 
	 
	
	
	public SelectionScreen(MugwompGame mugwompGame) {
		game = mugwompGame;
		
		Texture.setEnforcePotImages(false);
		backgroundimage = new Texture(Gdx.files.internal("Selection.png"));
		backgroundimage2 = new Texture(Gdx.files.internal("Basic_BG.png"));
		
		
		//NEED to get image files
		monster1image = new Texture(Gdx.files.internal("RIT_Tiger_Bio.png"));
		monster2image = new Texture(Gdx.files.internal("Owl_Bio.png"));
		monster3image = new Texture(Gdx.files.internal("Firemoth_Bio.png"));
		monster4image = new Texture(Gdx.files.internal("Iceturtle_Bio.png"));
		monster5image = new Texture(Gdx.files.internal("Seahorse_Bio.png"));
		monster6image = new Texture(Gdx.files.internal("Spider_Bio.png"));
		
		head1image = new Texture(Gdx.files.internal("RIT_Tiger_Headshot.png"));
		head2image = new Texture(Gdx.files.internal("Owl_Headshot.png"));
		head3image = new Texture(Gdx.files.internal("Firemoth_Headshot.png"));
		head4image = new Texture(Gdx.files.internal("Iceturtle_Headshot.png"));
		head5image = new Texture(Gdx.files.internal("Seahorse_Headshot.png"));
		head6image = new Texture(Gdx.files.internal("Spider_Headshot.png"));
		
		mini1image = new Texture(Gdx.files.internal("RIT_Tiger_Selected.png"));
		mini2image = new Texture(Gdx.files.internal("Owl_Selected.png"));
		mini3image = new Texture(Gdx.files.internal("Firemoth_Selected.png"));
		mini4image = new Texture(Gdx.files.internal("Iceturtle_Selected.png"));
		mini5image = new Texture(Gdx.files.internal("Seahorse_Selected.png"));
		mini6image = new Texture(Gdx.files.internal("Spider_Selected.png"));
		
		donereadyimage = new Texture(Gdx.files.internal("Done_Ready.png"));
		donedisabledimage = new Texture(Gdx.files.internal("Done_Disabled.png"));
		player1image = new Texture(Gdx.files.internal("Player_1.png"));
		player2image = new Texture(Gdx.files.internal("Player_2.png"));
		selectimage = new Texture(Gdx.files.internal("Select.png"));
		deselectimage = new Texture(Gdx.files.internal("Deselect.png"));
		backimage = new Texture(Gdx.files.internal("Back.png"));
		
		camera = new OrthographicCamera();
	      camera.setToOrtho(false, 800, 800);
	      
	      batch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0.2f, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		
	    batch.begin();
	    
		if(page == "default")
		{
			printDefault();
		}
		else
		{
			printMonster();
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
		// TODO Auto-generated method stub
		
	}
	
	public void printDefault()
	{
		
		 batch.draw(backgroundimage, 0, 0);
		 
		//Place the donebutton
				donebutton.x =510;
				donebutton.y = 44;
				donebutton.width = 166;
				donebutton.height = 36;
				
				//Monster1
				monster1.x =71;
				monster1.y = 402;
				monster1.width = 196;
				monster1.height = 196;
				
				batch.draw(head1image, 70, 400);
				
				//Monster2
				monster2.x =300;
				monster2.y = 402;
				monster2.width = 196;
				monster2.height = 196;
				
				batch.draw(head2image, 299, 400);

				
				//Monster3
				monster3.x =533;
				monster3.y = 402;
				monster3.width = 196;
				monster3.height = 196;
				
				batch.draw(head3image, 531, 400);
				
				//Monster4
				monster4.x =69;
				monster4.y = 164;
				monster4.width = 196;
				monster4.height = 196;
				
				batch.draw(head4image, 69, 170);

				//Monster5
				monster5.x =300;
				monster5.y = 164;
				monster5.width = 196;
				monster5.height = 196;

				batch.draw(head5image, 299, 170);

				//Monster6
				monster6.x =533;
				monster6.y = 164;
				monster6.width = 196;
				monster6.height = 196;
				
				batch.draw(head6image, 530, 170);
			    
				int x;
			   for(int i =0; i< selected.size(); i++)
			   {
				   if(player == true && once == false)
				   {
					   if(3==selected.size())
					   {
						   break;
					   }
					   else if(3 == selected.size()-1)
					   {
						   i=3;
						   once = true;
					   }
				   }
				   if(i==0 || i==3)
				   {
					   x = 69;
				   }
				   else if(i==1 || i==4)
				   {
					   x = 192;
				   }
				   else
				   {
					   x = 319;
				   }
				   
				   if(selected.get(i)== "RIT Tiger")
				   {
					   batch.draw(mini1image, x, 43);
				   }
				   if(selected.get(i)== "Night Stag")
				   {
					   batch.draw(mini2image, x, 43);
				   }
				   if(selected.get(i)== "Firefly")
				   {
					   batch.draw(mini3image, x, 43);
				   }
				   if(selected.get(i)== "Glaishel")
				   {
					   batch.draw(mini4image, x, 43);
				   }
				   if(selected.get(i)== "Shore-Strider")
				   {
					   batch.draw(mini5image, x, 43);
				   }
				   if(selected.get(i)== "Nettle Crawler")
				   {
					   batch.draw(mini6image, x, 43);
				   }
			   }
			    
			    if(player == false)
			    {
			    	batch.draw(player1image, 445, 85);
			    }
			    else
			    {
			    	batch.draw(player2image, 445, 85);
			    }
			    
			    if(done == true)
			    {
			    	batch.draw(donereadyimage, 445, 35);
			    }
			    else
			    {
			    	batch.draw(donedisabledimage,445,35);
			    }
				batch.end();
				
				if(Gdx.input.isTouched() ) 
				 { 
					 
					Vector3 touchPos = new Vector3(); 
					 touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0); 
					 camera.unproject(touchPos); 
					 
					 
					 //if done selecting monsters
					 System.out.println("X: " +touchPos.x +" Y: "+ touchPos.y);
					if (click ==false)
					{
						buttons(touchPos.x, touchPos.y);
					}
					
					 if(monster == 3)
					 {
						 done = true;
					 }
					 else
					 {
						 done = false;
					 }
					 
					if (donebutton.contains(touchPos.x, touchPos.y) && done == true)
					{
						//if both players are done
						if(player == true)
						{
							game.battleScreen(monsters); 

							//game.goBack();
						}
						player = true;
						select1 = false;
						select2 = false;
						select3 = false;
						select4 = false;
						select5 = false;
						select6 = false;
						monster = 0;
						done = false;
						
					}
				
					click = true;
				}
				else
				{
					click = false;
				}
	}
	
	public void printMonster()
	{
		//batch.draw(backgroundimage2, 0, 0);
		
		
		//Select button
		selectbutton.x =530;
		selectbutton.y = 50;
		selectbutton.width = 196;
		selectbutton.height = 196;
		
		//Back button
		backbutton.x =20;
		backbutton.y = 50;
		backbutton.width = 196;
		backbutton.height = 196;
		
	    
		if(page == "monster1")
		{
			batch.draw(monster1image, 0, 0);
			selecting=select1;
			if(select1 == false && monster !=3)
			{
				batch.draw(selectimage, 530, 50);
			}
			else if(select1==true)
			{
				batch.draw(deselectimage, 530, 50);
			}
		}
		if(page == "monster2")
		{
			batch.draw(monster2image, 0, 0);
			selecting=select2;

			if(select2 == false && monster !=3)
			{
				batch.draw(selectimage, 530, 50);
			}
			else if(select2==true)
			{
				batch.draw(deselectimage, 530, 50);
			}
		}
		if(page == "monster3")
		{
			batch.draw(monster3image, 0, 0);
			selecting=select3;

			if(select3 == false&& monster !=3)
			{
				batch.draw(selectimage, 530, 50);
			}
			else if(select3==true)
			{
				batch.draw(deselectimage, 530, 50);
			}
		}
		if(page == "monster4")
		{
			batch.draw(monster4image, 0, 0);
			selecting=select4;

			if(select4 == false&& monster !=3)
			{
				batch.draw(selectimage, 530, 50);
			}
			else if(select4==true)
			{
				batch.draw(deselectimage, 530, 50);
			}
		}
		if(page == "monster5")
		{
			batch.draw(monster5image, 0, 0);
			selecting=select5;
			if(select5 == false&& monster !=3)
			{
				batch.draw(selectimage, 530, 50);
			}
			else if(select5==true)
			{
				batch.draw(deselectimage, 530, 50);
			}
		}
		if(page == "monster6")
		{
			batch.draw(monster6image, 0, 0);
			selecting=select6;

			if(select6 == false&& monster !=3)
			{
				batch.draw(selectimage, 530, 50);
			}
			else if(select6==true)
			{
				batch.draw(deselectimage, 530, 50);
			}
		}
		
		
		
		batch.draw(backimage, 20, 50);
		
		
		batch.end();

		//if buttons are pressed
		if(Gdx.input.isTouched() ) 
		 {
			Vector3 touchPos = new Vector3(); 
			 touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0); 
			 camera.unproject(touchPos); 
			
			
			 if(click == false)
			 {
				 if(selectbutton.contains(touchPos.x, touchPos.y) && selecting == false && monster!=3)
					{
						monster++;
						addRemoveMonster();						
						
						
							
						if(page == "monster1")
						 {
							select1 = true;
						 }
						 if(page == "monster2")
						 {
							 select2 = true;
						 }
						 if(page == "monster3")
						 {
							 select3 =true;
						 }
						 if(page == "monster4")
						 {
							 select4 = true;
						 }
						 if(page == "monster5")
						 {
							 select5 = true;
						 }
						 if(page == "monster6")
						 {
							 select6 = true;
						 }
						
					}
					
				 else if(selectbutton.contains(touchPos.x, touchPos.y) && selecting == true)
					{
						monster--;
						addRemoveMonster();
						
						if(page == "monster1")
						 {
							select1 = false;
						 }
						 if(page == "monster2")
						 {
							 select2 = false;
						 }
						 if(page == "monster3")
						 {
							 select3 =false;
						 }
						 if(page == "monster4")
						 {
							 select4 = false;
						 }
						 if(page == "monster5")
						 {
							 select5 = false;
						 }
						 if(page == "monster6")
						 {
							 select6 = false;
						 }
					}
					
					if(backbutton.contains(touchPos.x, touchPos.y))
					{
						page = "default";
					}
			 }
			

				click = true;
		 }
		else
		{
			click = false;
		}
		
	}
	
	public void addRemoveMonster()
	{
		Monster monster1 = new Monster ();
		if(player == false)
		{
			monster1.playerID = 0;
			monster1.facing = true;
		}
		else
		{
			monster1.playerID = 1;
		}
		
		 if(page == "monster1")
		 {
			 selecting = select1;
			 monster1.setName("");
			 monster1.setMaxHP(75);
			 monster1.setBreed("RIT Tiger");
			 monster1.setHP(75);
			 monster1.setId(0);
			 monster1.attack = 20;
			 monster1.defense = 25;
			 monster1.speed = 20;
			 monster1.spAttack= 20;
			 monster1.bodyType = monster1.EARTH;
			 monster1.bodyRes = EARTH_BODY;
			 monster1.action1 = new Slash(monster1.speed,monster1);
			 monster1.action2 = new BrickBash(monster1.speed,monster1);
			 monster1.action3 = new MudTug(monster1.speed,monster1);
			 
		 }
		 if(page == "monster2")
		 {
			 selecting = select2;
			 monster1.setName("");
			 monster1.setMaxHP(60);
			 monster1.setBreed("Night Stag");
			 monster1.setHP(60);
			 monster1.setId(0);
			 monster1.attack = 20;
			 monster1.defense = 16;
			 monster1.speed = 25;
			 monster1.spAttack= 15;
			 monster1.bodyType = monster1.AIR;
			 monster1.bodyRes = AIR_BODY;
			 monster1.action1 = new Gut(monster1.speed,monster1);
			 monster1.action2 = new Serenade(monster1.speed,monster1);
			 monster1.action3 = new Swap(monster1.speed,monster1);
		 }
		 if(page == "monster3")
		 {
			 selecting = select3;
			 monster1.setName("");
			 monster1.setMaxHP(50);
			 monster1.setBreed("Firefly");
			 monster1.setHP(50);
			 monster1.setId(0);
			 monster1.attack = 15;
			 monster1.defense = 15;
			 monster1.speed = 20;
			 monster1.spAttack= 30;
			 monster1.bodyType = monster1.FIRE;
			 monster1.bodyRes = FIRE_BODY;
			 monster1.action1 = new Slash(monster1.speed,monster1);
			 monster1.action2 = new Slash(monster1.speed,monster1);
			 monster1.action3 = new Slash(monster1.speed,monster1);
		 }
		 if(page == "monster4")
		 {
			 selecting = select4;
			 monster1.setName("");
			 monster1.setMaxHP(90);
			 monster1.setBreed("Glaishel");
			 monster1.setHP(90);
			 monster1.setId(0);
			 monster1.attack = 20;
			 monster1.defense = 30;
			 monster1.speed = 15;
			 monster1.spAttack= 18;
			 monster1.bodyType = monster1.WATER;
			 monster1.bodyRes = WATER_BODY;
			 monster1.action1 = new Slash(monster1.speed,monster1);
			 monster1.action2 = new Slash(monster1.speed,monster1);
			 monster1.action3 = new Slash(monster1.speed,monster1);
		 }
		 if(page == "monster5")
		 {
			 selecting = select5;
			 monster1.setName("");
			 monster1.setMaxHP(65);
			 monster1.setBreed("Shore-Strider");
			 monster1.setHP(65);
			 monster1.setId(0);
			 monster1.attack = 20;
			 monster1.defense = 18;
			 monster1.speed = 25;
			 monster1.spAttack= 20;
			 monster1.bodyType = monster1.WATER;
			 monster1.bodyRes = WATER_BODY;
			 monster1.action1 = new Slash(monster1.speed,monster1);
			 monster1.action2 = new Slash(monster1.speed,monster1);
			 monster1.action3 = new Slash(monster1.speed,monster1);
		 }
		 if(page == "monster6")
		 {
			 selecting = select6;
			 monster1.setName("");
			 monster1.setMaxHP(55);
			 monster1.setBreed("Nettle Crawler");
			 monster1.setHP(55);
			 monster1.setId(0);
			 monster1.attack = 30;
			 monster1.defense = 18;
			 monster1.speed = 20;
			 monster1.spAttack= 20;
			 monster1.bodyType = monster1.EARTH;
			 monster1.bodyRes = EARTH_BODY;
			 monster1.action1 = new Slash(monster1.speed,monster1);
			 monster1.action2 = new Slash(monster1.speed,monster1);
			 monster1.action3 = new Slash(monster1.speed,monster1);
		 }
		 
		 if(selecting == false)
		 {
			 monsters.add(monster1);
			 selected.add(monster1.getBreed());
		 }
		 else
		 {
			 for(int i= 0; i <monsters.size(); i++)
			 {
				 if(monsters.get(i).getPlayerID() == monster1.getPlayerID() && monsters.get(i).getBreed() == monster1.getBreed())
				 {
					 monsters.remove(i);
					 selected.remove(i);
				 }
			 }
		 }
	}
	
	//When monster buttons are clicked change page
	public void buttons(float x, float y)
	{
		 if(monster1.contains(x, y))
		 {
			 page = "monster1";
			 click = true;
		 }
		 if(monster2.contains(x, y))
		 {
			 page = "monster2";
			 click = true;

		 }
		 if(monster3.contains(x, y))
		 {
			 page = "monster3";
			 click = true;

		 }
		 if(monster4.contains(x, y))
		 {
			 page = "monster4";
			 click = true;

		 }
		 if(monster5.contains(x, y))
		 {
			 page = "monster5";
			 click = true;

		 }
		 if(monster6.contains(x, y))
		 {
			 page = "monster6";
			 click = true;

		 }
	}

}


	
	

