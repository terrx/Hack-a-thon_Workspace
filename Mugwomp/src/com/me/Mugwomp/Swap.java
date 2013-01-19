package com.me.Mugwomp;

public class Swap extends Action {

	public Swap(int precidence, Monster origin) {
		super(precidence, origin);
	}

	public boolean isLegal() {
		if(!targetSquares.get(0).hasMonster()) return false;
		if(targetSquares.get(0).getMonster().playerID != origin.playerID) return false;
		return true;
	}

	public int targetsCount() {
		return 1;
	}

	public void doAction(Field field) {
		int x = origin.myLocation.getX();
		int y = origin.myLocation.getY();
		
		int x2 = targetSquares.get(0).getX();
		int y2 = targetSquares.get(0).getY();
		
		Monster m = field.get(x2, y2).getMonster();
		
		origin.myLocation = field.get(x2, y2);
		field.get(x2, y2).setMonster(origin);
		
		m.myLocation = field.get(x, y);
		field.get(x, y).setMonster(m);
	}

	public String getName() {
		return "Swap";
	}

}
