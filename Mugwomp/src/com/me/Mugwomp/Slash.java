package com.me.Mugwomp;

import java.util.Random;

public class Slash extends Action{

	public Slash(int precidence, Monster origin) {
		super(precidence, origin);
	}

	public void doAction(Field field) {
		System.out.println("SLAAAASH");
		Random rand = new Random();
		
		int x = origin.myLocation.getX();
		int y = origin.myLocation.getY();
		
		if(origin.facing) {
			if(y - 1 >= 0) {
				if(field.get(x-1, y-1).hasMonster() && (field.get(x-1, y-1).getMonster().playerID != origin.playerID)) {
					int damage = (int) ((origin.attack * (rand.nextDouble() + 0.5)) * ((100 - field.get(x-1, y-1).getMonster().defense) / 100.0));
					field.get(x-1, y-1).getMonster().dealDamage(damage,origin.A_GEN);
				}
			}
			if(y + 1 < 3) {
				if(field.get(x-1, y+1).hasMonster() && (field.get(x-1, y+1).getMonster().playerID != origin.playerID)) {
					int damage = (int) ((origin.attack * (rand.nextDouble() + 0.5)) * ((100 - field.get(x-1, y+1).getMonster().defense) / 100.0));
					field.get(x-1, y+1).getMonster().dealDamage(damage,origin.A_GEN);
				}
			}
			if(field.get(x-1, y).hasMonster() && (field.get(x-1, y).getMonster().playerID != origin.playerID)) {
				int damage = (int) ((origin.attack * (rand.nextDouble() + 0.5)) * ((100 - field.get(x-1, y).getMonster().defense) / 100.0));
				field.get(x-1, y).getMonster().dealDamage(damage,origin.A_GEN);
			}
		} else {
			if(y - 1 >= 0) {
				if(field.get(x+1, y-1).hasMonster() && (field.get(x+1, y-1).getMonster().playerID != origin.playerID)) {
					int damage = (int) ((origin.attack * (rand.nextDouble() + 0.5)) * ((100 - field.get(x+1, y-1).getMonster().defense) / 100.0));
					field.get(x+1, y-1).getMonster().dealDamage(damage,origin.A_GEN);
				}
			}
			if(y + 1 < 3) {
				if(field.get(x+1, y+1).hasMonster() && (field.get(x+1, y+1).getMonster().playerID != origin.playerID)) {
					int damage = (int) ((origin.attack * (rand.nextDouble() + 0.5)) * ((100 - field.get(x+1, y+1).getMonster().defense) / 100.0));
					field.get(x+1, y+1).getMonster().dealDamage(damage,origin.A_GEN);
				}
			}
			if(field.get(x+1, y).hasMonster() && (field.get(x+1, y).getMonster().playerID != origin.playerID)) {
				int damage = (int) ((origin.attack * (rand.nextDouble() + 0.5)) * ((100 - field.get(x+1, y).getMonster().defense) / 100.0));
				field.get(x+1, y).getMonster().dealDamage(damage,origin.A_GEN);
			}
		}
	}

	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public int targetsCount() {
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Slash";
	}
	
}

