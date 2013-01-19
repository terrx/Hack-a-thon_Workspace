package com.me.Mugwomp;

import java.util.Random;

public class MudTug extends Action {
	
	public MudTug(int precidence, Monster origin) {
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
		
		int x = origin.myLocation.getX();
		int y = origin.myLocation.getY();
		Random rand = new Random();
		
		if(origin.facing) {
			if(targetSquares.get(0).getX() < x && targetSquares.get(0).getY() == y) {
				if(targetSquares.get(0).hasMonster() && (targetSquares.get(0).getMonster().playerID != origin.playerID)) {
					int damage = (int) ((origin.spAttack * (rand.nextDouble() )) * ((targetSquares.get(0).getMonster().defense) / 100.0));
					targetSquares.get(0).getMonster().dealDamage(damage,origin.A_EARTH);
					
					if(!field.get(targetSquares.get(0).getX()+1, y).hasMonster()  && !(field.get(targetSquares.get(0).getX()+1, y).aligned && field.get(targetSquares.get(0).getX()+1, y).allegiance == origin.playerID))
					{
						Monster m = targetSquares.get(0).getMonster();
						m.myLocation.setMonster(null);
						m.myLocation =field.get(targetSquares.get(0).getX()+1, y);
						field.get(targetSquares.get(0).getX()+1, y).setMonster(m);
					}
				}
			}
		} else {
			if(targetSquares.get(0).getX() > x && targetSquares.get(0).getY() == y) {
				if(targetSquares.get(0).hasMonster() && (targetSquares.get(0).getMonster().playerID != origin.playerID)) {
					int damage = (int) ((origin.spAttack * (rand.nextDouble() )) * ((targetSquares.get(0).getMonster().defense) / 100.0));
					targetSquares.get(0).getMonster().dealDamage(damage,origin.A_EARTH);
					
					if(!field.get(targetSquares.get(0).getX()-1, y).hasMonster() && !(field.get(targetSquares.get(0).getX()-1, y).aligned && field.get(targetSquares.get(0).getX()-1, y).allegiance == origin.playerID))
					{
						Monster m = targetSquares.get(0).getMonster();
						m.myLocation.setMonster(null);
						m.myLocation =field.get(targetSquares.get(0).getX()-1, y);
						field.get(targetSquares.get(0).getX()-1, y).setMonster(m);
					}
				}
			}
		}
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Mud Tug";
	}
	
}



