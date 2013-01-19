package com.me.Mugwomp;

import java.util.ArrayList;

import com.badlogic.gdx.Game;



public class MugwompGame extends Game {
	BattleScreen battleScreen;
	MainMenuScreen mainMenuScreen;
	SelectionScreen selectionScreen;
	GameOver gameOver;
	
	@Override
	public void create() {
		
		mainMenuScreen = new MainMenuScreen(this);
		battleScreen = new BattleScreen(this);
		selectionScreen = new SelectionScreen(this);
		gameOver = new GameOver(this);
		setScreen(mainMenuScreen);
		
	}
	
	public void selectionScreen()
	{
		setScreen(selectionScreen);
		mainMenuScreen.dispose();
	}
	
	public void battleScreen(ArrayList<Monster> monsters)
	{
		battleScreen.setMonsters(monsters);
		setScreen(battleScreen);
		selectionScreen.dispose();
	}
	
	public void gameOver(int player1count, int player2count)
	{
		gameOver.player1count = player1count;
		gameOver.player2count = player2count;
		setScreen(gameOver);
		battleScreen.dispose();
	}
}

