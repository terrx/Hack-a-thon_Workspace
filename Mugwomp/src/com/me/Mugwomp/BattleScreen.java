package com.me.Mugwomp;

import java.util.ArrayList;
import java.util.Collections;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;

public class BattleScreen implements Screen {

	Texture background;
	
	Texture decidedMenu;
	Texture attackMenu;
	Texture undecidedMenu;
	Texture enemyMenu;
	
	ArrayList<Texture> monsterTextures = new ArrayList<Texture>();
	ArrayList<Texture> flipedMonsterTextures = new ArrayList<Texture>();
	
	ArrayList<Action> actions = new ArrayList<Action>();
	Action currentAction;
	
	ArrayList<Monster> monsters = new ArrayList<Monster>();
	
	Texture bar;
	
	private BitmapFont font;
	
	MugwompGame game;
	
	boolean click = false;
	
	GameRunner gr;
	
	OrthographicCamera camera;
	
	SpriteBatch batch;
	
	TerrainSquare currentTS = null;
	int currentPlayer = 0;
	
	private int chooseVsRun = 2;
	
	private final int CHOOSE = 0;
	private final int RUN = 1;
	private final int PLACE = 2;
	
	int player1count = 3;
	int player2count = 3;
	
	private int chooseMode = 0;
	
	private final int DEFAULT = 0;
	private final int UNDEC = 1;
	private final int TARGET_SEEK = 2;
	private final int ATTACK_SELECT = 3;
	
	Rectangle attack1 = new Rectangle();
	Rectangle attack2 = new Rectangle();
	Rectangle attack3 = new Rectangle();
	
	boolean placeDebounce = false;
	int placeCount = 0;
	
	Field field;
	
	long lastActionTime;
	
	int actionCount = 0;
	
	public BattleScreen(MugwompGame mugwompGame) {
		game = mugwompGame;
		
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 800);
	    
	    batch = new SpriteBatch();
	    
	    font = new BitmapFont();
	    
	    Texture.setEnforcePotImages(false);
	    
	    monsterTextures.add(new Texture(Gdx.files.internal("RIT_Tiger_Idle_Small.png")));
	    monsterTextures.add(new Texture(Gdx.files.internal("RIT_Tiger_Idle_Small_2.png")));
	    
	    flipedMonsterTextures.add(new Texture(Gdx.files.internal("RIT_Tiger_Idle_Small_flip.png")));
	    flipedMonsterTextures.add(new Texture(Gdx.files.internal("RIT_Tiger_Idle_Small_2_flip.png")));
	    
	    background = new Texture(Gdx.files.internal("Battlefield_Grass.png"));

	    decidedMenu = new Texture(Gdx.files.internal("Decided_Menu.png"));
	    attackMenu = new Texture(Gdx.files.internal("Attack_Menu.png"));
	    undecidedMenu = new Texture(Gdx.files.internal("Undecided_Menu.png"));
	    enemyMenu = new Texture(Gdx.files.internal("Opponent_Menu.png"));
	    
	    field = new Field();
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	    
	    camera.update();
		
		batch.begin();
		
		batch.draw(background,0,0);
		drawMenu();
		
		for(int x = 0; x < 6; x++) {
        	for(int y = 0; y < 3; y++) {
        		field.get(x,y).render(batch,monsterTextures,flipedMonsterTextures);
        	}
        }
		
		batch.end();
		
		switch(chooseVsRun) {
			case CHOOSE:
				choose();
				break;
			case RUN:
				for(Monster m : monsters) {
					m.moveSelected = false;
				}
				run();
				break;
			case PLACE:
				place();
				break;
		}
	}

	private void place() {
		if(currentPlayer == 0) {
			if(Gdx.input.isTouched() && !placeDebounce) {
				placeDebounce = true;
				Vector3 touchPos = new Vector3();
		        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		        camera.unproject(touchPos);
		        TerrainSquare ts;
		        for(int x = 0; x < 6; x++) {
		        	for(int y = 0; y < 3; y++) {
		        		ts = field.get(x,y);
		        		if(ts.getRectangle().contains(touchPos.x, touchPos.y)) {
		        			if(ts.getX() > 2 && !ts.hasMonster()) {
		        				ts.setMonster(monsters.get(placeCount));
		        				monsters.get(placeCount).myLocation = ts;
		        				placeCount++;
		        			}
		        		}
		        	}
		        }
			}
			if(!Gdx.input.isTouched()) {
				placeDebounce = false;
			}
			if(placeCount > 2) {
				currentPlayer = 1;
			}
		} else {
			if(Gdx.input.isTouched() && !placeDebounce) {
				placeDebounce = true;
				Vector3 touchPos = new Vector3();
		        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		        camera.unproject(touchPos);
		        TerrainSquare ts;
		        for(int x = 0; x < 6; x++) {
		        	for(int y = 0; y < 3; y++) {
		        		ts = field.get(x,y);
		        		if(ts.getRectangle().contains(touchPos.x, touchPos.y)) {
		        			if(ts.getX() <= 2 && !ts.hasMonster()) {
		        				ts.setMonster(monsters.get(placeCount));
		        				monsters.get(placeCount).myLocation = ts;
		        				placeCount++;
		        			}
		        		}
		        	}
		        }
			}
			if(!Gdx.input.isTouched()) {
				placeDebounce = false;
			}
			if(placeCount == 6) {
				currentPlayer = 0;
				chooseVsRun = CHOOSE;
			}
		}
	}

	private void drawMenu() {
		
		if(player1count == 0 || player2count == 0)
		{
			//GAMEOVER
		}
		else
		{
			if(chooseMode == ATTACK_SELECT) {
				batch.draw(attackMenu,0,0);
				
				attack1.x =92;
				attack1.y = 223;
				attack1.width = 230;
				attack1.height = 55;
				
				font.draw(batch,currentTS.getMonster().action1.getName(), 120, 260);
				
				attack2.x =92;
				attack2.y = 134;
				attack2.width = 230;
				attack2.height = 55;
				
				font.draw(batch,currentTS.getMonster().action2.getName(), 120, 171);
				
				attack3.x =92;
				attack3.y = 43;
				attack3.width = 230;
				attack3.height = 55;
				
				font.draw(batch,currentTS.getMonster().action3.getName(), 120, 80);
				
				if(Gdx.input.isTouched() ) 
				 { 
					 
						Vector3 touchPos = new Vector3(); 
						touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0); 
						camera.unproject(touchPos); 
				        System.out.println("You have clicked: X:" + touchPos.x + " Y:" + touchPos.y);
				        
				        if (attack1.contains(touchPos.x, touchPos.y) && click == false)
						{
				        	currentAction = currentTS.getMonster().action1;
			        		chooseMode = TARGET_SEEK;
						}
				        if (attack2.contains(touchPos.x, touchPos.y) && click == false)
						{
				        	currentAction = currentTS.getMonster().action2;
			        		chooseMode = TARGET_SEEK;
						}
				        if (attack3.contains(touchPos.x, touchPos.y) && click == false)
						{
				        	currentAction = currentTS.getMonster().action3;
			        		chooseMode = TARGET_SEEK;
						}
				        
				        click = true;

				}
				else
				{
						click = false;
				}
				
			} else {
				font.setColor(0, 0, 0, 1);
				if(currentTS == null) {
					
				} else if(currentTS.hasMonster()) {
					font.draw(batch, currentTS.getMonster().getName() + " - " + currentTS.getMonster().getBreed(), 45, 360);
					if(currentTS.getMonster().playerID == currentPlayer) {
						if(currentTS.getMonster().getMoveSelected()) {
							batch.draw(decidedMenu,0,0);
						} else {
							batch.draw(undecidedMenu,0,0);
						}
					} else {
						batch.draw(enemyMenu,0,0);
					}
					font.draw(batch, currentTS.getMonster().getHP() + "/" + currentTS.getMonster().getMaxHP(), 245, 211);
					font.draw(batch, Integer.toString(currentTS.getMonster().attack), 255, 170);
					font.draw(batch, Integer.toString(currentTS.getMonster().defense), 255, 124);
					font.draw(batch, Integer.toString(currentTS.getMonster().speed), 255, 85);
					
					
				}
			}
		}
		
		
	}

	private void choose() {
		if(Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
	        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
	        camera.unproject(touchPos);
	        TerrainSquare ts;
			switch(chooseMode) {
				case DEFAULT:
			        //System.out.println("You have clicked: X:" + touchPos.x + " Y:" + touchPos.y);
			        for(int x = 0; x < 6; x++) {
			        	for(int y = 0; y < 3; y++) {
			        		ts = field.get(x,y);
			        		if(ts.getRectangle().contains(touchPos.x, touchPos.y)) {
			        			//System.out.println("You have clicked: X:" + ts.getX() + " Y:" + ts.getY());
			        			currentTS = ts;
			        			if(currentTS.getMonster() != null) {
			        				if((currentTS.getMonster().playerID == currentPlayer) && !currentTS.getMonster().getMoveSelected()) {
			        					chooseMode = UNDEC;
			        				}
			        			}
			        		}
			        	}
			        }
					break;
				case UNDEC:
			        //System.out.println("You have clicked: X:" + touchPos.x + " Y:" + touchPos.y);
			        for(int x = 0; x < 6; x++) {
			        	for(int y = 0; y < 3; y++) {
			        		ts = field.get(x,y);
			        		if(ts.getRectangle().contains(touchPos.x, touchPos.y)) {
			        			//System.out.println("You have clicked: X:" + ts.getX() + " Y:" + ts.getY());
			        			currentTS = ts;
			        		}
			        	}
			        }
			        if((touchPos.x >= 448 && touchPos.x <= 692) && (touchPos.y >= 107 && touchPos.y <= 162)) {
		        		currentAction = new Move(currentTS.getMonster().speed,currentTS.getMonster());
		        		chooseMode = TARGET_SEEK;
		        	}
			        if((touchPos.x >= 448 && touchPos.x <= 692) && (touchPos.y >= 188 && touchPos.y <= 245)) {
		        		chooseMode = ATTACK_SELECT;
		        	}
					break;
				case TARGET_SEEK:
					if(currentAction.targetsCount() == 0) {
						actions.add(currentAction);
						currentAction = null;
						currentTS.getMonster().setMoveSelected(true);
						chooseMode = DEFAULT;
					} else if(currentAction.targetsCount() == 1) {
						for(int x = 0; x < 6; x++) {
				        	for(int y = 0; y < 3; y++) {
				        		ts = field.get(x,y);
				        		if(ts.getRectangle().contains(touchPos.x, touchPos.y)) {
				        			ArrayList<TerrainSquare> array = new ArrayList<TerrainSquare>();
				        			array.add(ts);
				        			currentAction.setTargets(array);
				        			if(currentAction.isLegal()) {
				        				int i;
				        				for(i=0; i<actions.size(); i++)
				        				{
				        					if(actions.get(i).precidence < currentAction.precidence )
				        					{
				        						actions.add(0, currentAction);
				        						i = actions.size()+1;
				        					}
				        					
				        				}
				        				if(i == actions.size())
				        				{
				        					actions.add(currentAction);
				        				}
				        				
										currentAction = null;
										currentTS.getMonster().setMoveSelected(true);
										chooseMode = DEFAULT;
				        			} else {
				        				currentAction.resetTargets();
				        			}
				        		}
				        	}
				        }
					}
					break;
				case ATTACK_SELECT:
					break;
			}
	    }
		if(currentPlayer == 0) {
			boolean done = true;
			for(Monster m : monsters) {
				if(m.playerID == 0 && !m.getMoveSelected()) {
					done = false;
					break;
				}
			}
			if(done) {
				currentPlayer = 1;
			}
		} else {
			boolean done = true;
			for(Monster m : monsters) {
				if(m.playerID == 1 && !m.getMoveSelected()) {
					done = false;
					break;
				}
			}
			if(done) {
				currentPlayer = 0;
				chooseVsRun = RUN;
			}
		}
	}
	
	private void run() {
		if(TimeUtils.nanoTime() - lastActionTime > 1000000000) {
			if(actions.get(actionCount).isLegal())actions.get(actionCount).doAction(field);
			field.updateAllegiance();
			lastActionTime = TimeUtils.nanoTime();
			actionCount++;
		}
		if(actionCount == actions.size()) {
			chooseVsRun = CHOOSE;
			actionCount = 0;
			actions = new ArrayList<Action>();
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

	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}

}

