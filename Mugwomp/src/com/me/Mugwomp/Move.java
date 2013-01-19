package com.me.Mugwomp;

import java.util.ArrayList;

public class Move extends Action{

	public Move(int precidence, Monster origin) {
		super(precidence, origin);
	}

	public void doAction(Field field) {
		origin.myLocation.setMonster(null);
		origin.myLocation = targetSquares.get(0);
		targetSquares.get(0).setMonster(origin);
	}

	@Override
	public boolean isLegal() {
		if(targetSquares.size() != 1) return false;
		if(Math.abs(targetSquares.get(0).getX() - origin.myLocation.getX()) > 1) return false;
		if(Math.abs(targetSquares.get(0).getY() - origin.myLocation.getY()) > 1) return false;
		if(targetSquares.get(0).hasMonster()) return false;
		if(targetSquares.get(0).aligned && (targetSquares.get(0).allegiance != origin.playerID)) return false;
		return true;
	}

	@Override
	public int targetsCount() {
		return 1;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Move";
	}

}
