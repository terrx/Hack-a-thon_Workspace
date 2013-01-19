package com.me.Mugwomp;

import java.util.Random;

public class BrickBash extends Action{

	public BrickBash(int precidence, Monster origin) {
		super(precidence, origin);
	}

	public boolean isLegal() {
		int x = origin.myLocation.getX();
		int y = origin.myLocation.getY();
		
		if(origin.facing) {
			if(targetSquares.get(0).getX() < x && targetSquares.get(0).getY() == y) {
				return true;
			}
			else
			{
				return false;
			}
		} else {
			if(targetSquares.get(0).getX() > x && targetSquares.get(0).getY() == y) {
				return true;
			}
			else
			{
				return false;
			}
		}
	}

	@Override
	public int targetsCount() {
		return 1;
	}

	@Override
	public void doAction(Field field) {
		System.out.println("Brick Bash");
		Random rand = new Random();
		
		int x = origin.myLocation.getX();
		int y = origin.myLocation.getY();
		
		if(origin.facing) {
			if(targetSquares.get(0).getX() < x && targetSquares.get(0).getY() == y) {
				if(targetSquares.get(0).hasMonster() && (targetSquares.get(0).getMonster().playerID != origin.playerID)) {
					int damage = (int) ((origin.spAttack * (rand.nextDouble() + 0.5)) * ((targetSquares.get(0).getMonster().defense) / 100.0));
					targetSquares.get(0).getMonster().dealDamage(damage,origin.A_EARTH);
				}
			}
		} else {
			if(targetSquares.get(0).getX() > x && targetSquares.get(0).getY() == y) {
				if(targetSquares.get(0).hasMonster() && (targetSquares.get(0).getMonster().playerID != origin.playerID)) {
					int damage = (int) ((origin.spAttack * (rand.nextDouble() + 0.5)) * ((targetSquares.get(0).getMonster().defense) / 100.0));
					targetSquares.get(0).getMonster().dealDamage(damage,origin.A_EARTH);
				}
			}
		}
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Brick Bash";
	}
	
}
