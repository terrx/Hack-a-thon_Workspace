package com.me.Mugwomp;

import java.util.Scanner;

public class Monster {
	
	TerrainSquare myLocation;
	int hp = 50;
	int speed = 10;
	int defense = 10;
	int attack = 10;
	int maxHp = 50;
	int spAttack = 50;
	int playerID = 0;
	int id;
	boolean facing;
	boolean moveSelected;
	String textureName;
	String name;
	String breed;
	
	int bodyType;
	
	Action action1;
	Action action2;
	Action action3;
	
	final int FIRE = 0;
	final int WATER = 1;
	final int AIR = 2;
	final int PLANT = 3;
	final int EARTH = 4;
	
	final int A_FIRE = 0;
	final int A_WATER = 1;
	final int A_AIR = 2;
	final int A_PLANT = 3;
	final int A_EARTH = 4;
	final int A_ICE = 5;
	final int A_GEN = 6;
	
	double[] bodyRes;
	
	
	public boolean isAlive() {
		return (hp > 0);
	}

	public Integer getPlayerID() {
		return playerID;
	}

	public void getMove() {
		System.out.println("Please select action for " + name);
		System.out.println("1. Move");
		System.out.println("2. Attack");
		Scanner scan = new Scanner(System.in);
		
		int actionSelection = Integer.parseInt(scan.next());
		
		switch(actionSelection) {
			
		}
	}

	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}

	public String getBreed() {
		return breed;
	}
	
	public void setBreed(String b) {
		breed = b;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int i) {
		id = i;
	}
	
	public int getHP() {
		return hp;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}
	
	public int getMaxHP() {
		return maxHp;
	}
	
	public void setMaxHP(int hp) {
		maxHp = hp;
	}
	
	public boolean getMoveSelected() {
		return moveSelected;
	}
	
	public void setMoveSelected(boolean b) {
		moveSelected = b;
	}
	
	public void dealDamage(int damage, int type)
	{
		hp -= (damage*bodyRes[type]);
	}
	
}
