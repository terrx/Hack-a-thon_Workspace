package com.me.Mugwomp;

import java.util.ArrayList;

public abstract class Action {

	ArrayList<TerrainSquare> targetSquares;
	Field field;
	
	int precidence;
	
	Monster origin;
	
	public Action(int precidence, Monster origin) {
		this.precidence = precidence;
		this.origin = origin;
	}
	
	public void setTargets(ArrayList<TerrainSquare> targetSquares) {
		this.targetSquares = targetSquares;
	}
	
	public void resetTargets() {
		this.targetSquares = null;
	}
	
	public abstract boolean isLegal();
	
	public abstract int targetsCount();
	
	public abstract void doAction(Field field);
	
	public abstract String getName();
}

