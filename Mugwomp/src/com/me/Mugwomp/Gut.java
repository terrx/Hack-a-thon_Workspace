package com.me.Mugwomp;

import java.util.Random;

public class Gut extends Action {

	public Gut(int precidence, Monster origin) {
		super(precidence, origin);
	}

	public boolean isLegal() {
		int x = origin.myLocation.getX();
		int y = origin.myLocation.getY();
		
		if(origin.facing) {
			if(Math.abs(targetSquares.get(0).getX() - x) > 2 || (targetSquares.get(0).allegiance != origin.playerID && targetSquares.get(0).aligned) || targetSquares.get(0).hasMonster()) {
				
				return false;
				
			}
			else
			{
				return true;
			}
		} else {
			if(Math.abs(targetSquares.get(0).getX() - x) > 2 || (targetSquares.get(0).allegiance != origin.playerID && targetSquares.get(0).aligned)|| targetSquares.get(0).hasMonster()) {
				
				return false;
			}
			else
			{
				return true;
			}
		}
	}

	@Override
	public int targetsCount() {
		return 1;
	}

	@Override
	public void doAction(Field field) {
		
		int x = origin.myLocation.getX();
		int y = origin.myLocation.getY();
		Random rand = new Random();
		
		if(origin.facing) {
			if(Math.abs(targetSquares.get(0).getX() - x) > 2 || (targetSquares.get(0).allegiance != origin.playerID && targetSquares.get(0).aligned)|| targetSquares.get(0).hasMonster()) {
			}
			else
			{
				
				Monster m = field.get(x, y).getMonster();
				field.get(x, y).setMonster(null);
				m.myLocation =field.get(targetSquares.get(0).getX(),targetSquares.get(0).getY());
				field.get(targetSquares.get(0).getX(), targetSquares.get(0).getY()).setMonster(m);

				x = origin.myLocation.getX();
				y = origin.myLocation.getY();
				if(field.get(x-1, y).hasMonster() && (field.get(x-1, y).getMonster().playerID != origin.playerID)) {
					int damage = (int) ((origin.spAttack * (rand.nextDouble() + 0.5)) * ((100 - field.get(x-1, y).getMonster().defense) / 100.0));
					field.get(x-1, y).getMonster().dealDamage(damage,origin.A_AIR);
				}

			}
		} else {
			if(Math.abs(targetSquares.get(0).getX() - x) > 2 || (targetSquares.get(0).allegiance != origin.playerID && targetSquares.get(0).aligned)|| targetSquares.get(0).hasMonster()) {
			}
			else
			{
				Monster m = field.get(x, y).getMonster();
				field.get(x, y).setMonster(null);
				m.myLocation =field.get(targetSquares.get(0).getX(),targetSquares.get(0).getY());
				field.get(targetSquares.get(0).getX(), targetSquares.get(0).getY()).setMonster(m);

				x = origin.myLocation.getX();
				y = origin.myLocation.getY();
				
				if(field.get(x-1, y).hasMonster() && (field.get(x-1, y).getMonster().playerID != origin.playerID)) {
					int damage = (int) ((origin.spAttack * (rand.nextDouble() + 0.5)) * ((100 - field.get(x-1, y).getMonster().defense) / 100.0));
					field.get(x-1, y).getMonster().dealDamage(damage,origin.A_AIR);
				}
			}
		
		}
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Gut";
	}
	
}