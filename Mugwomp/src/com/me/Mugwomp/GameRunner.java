package com.me.Mugwomp;

import java.util.ArrayList;

public class GameRunner {
	
	BattleScreen battleScreen;
	
	Field field;
	
	ArrayList<Monster> monsters;
	ArrayList<Integer> playerIDs;
	
	public GameRunner(BattleScreen bs) {
		battleScreen = bs;
	}
	
	public void runGame() {
		for(Integer id : playerIDs) {
			for(Monster monster : monsters) {
				if(monster.getPlayerID() == id && monster.isAlive()) {
					monster.getMove();
				}
			}
		}
	}
	
}
