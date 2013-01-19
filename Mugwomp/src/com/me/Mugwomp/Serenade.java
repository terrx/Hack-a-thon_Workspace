package com.me.Mugwomp;

public class Serenade extends Action {

	public Serenade(int precidence, Monster origin) {
		super(precidence, origin);
	}

	public boolean isLegal() {
		return true;
	}

	public int targetsCount() {
		return 0;
	}

	public void doAction(Field field) {
		int x = origin.myLocation.getX();
		int y = origin.myLocation.getY();
		
		if((x + 1) < 6) {
			if(field.get(x + 1, y).hasMonster() && field.get(x + 1, y).getMonster().playerID == origin.playerID) {
				field.get(x + 1, y).getMonster().dealDamage(-10, origin.A_AIR);
			}
			if((y + 1) < 3) {
				if(field.get(x + 1, y + 1).hasMonster() && field.get(x + 1, y + 1).getMonster().playerID == origin.playerID) {
					field.get(x + 1, y + 1).getMonster().dealDamage(-10, origin.A_AIR);
				}
			}
			if((y - 1) > 0) {
				if(field.get(x + 1, y - 1).hasMonster() && field.get(x + 1, y - 1).getMonster().playerID == origin.playerID) {
					field.get(x + 1, y - 1).getMonster().dealDamage(-10, origin.A_AIR);
				}
			}
		}
		if((x - 1) > 0) {
			if(field.get(x - 1, y).hasMonster() && field.get(x - 1, y).getMonster().playerID == origin.playerID) {
				field.get(x - 1, y).getMonster().dealDamage(-10, origin.A_AIR);
			}
			if((y + 1) < 3) {
				if(field.get(x - 1, y + 1).hasMonster() && field.get(x - 1, y + 1).getMonster().playerID == origin.playerID) {
					field.get(x - 1, y + 1).getMonster().dealDamage(-10, origin.A_AIR);
				}
			}
			if((y - 1) > 0) {
				if(field.get(x - 1, y - 1).hasMonster() && field.get(x - 1, y - 1).getMonster().playerID == origin.playerID) {
					field.get(x - 1, y - 1).getMonster().dealDamage(-10, origin.A_AIR);
				}
			}
		}
		if((y + 1) < 3) {
			if(field.get(x, y + 1).hasMonster() && field.get(x, y + 1).getMonster().playerID == origin.playerID) {
				field.get(x, y + 1).getMonster().dealDamage(-10, origin.A_AIR);
			}
		}
		if((y - 1) > 0) {
			if(field.get(x, y - 1).hasMonster() && field.get(x, y - 1).getMonster().playerID == origin.playerID) {
				field.get(x, y - 1).getMonster().dealDamage(-10, origin.A_AIR);
			}
		}
	}

	public String getName() {
		return "Serenade";
	}

}
