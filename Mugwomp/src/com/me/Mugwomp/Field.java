package com.me.Mugwomp;

import com.badlogic.gdx.math.Rectangle;

public class Field {

	TerrainSquare[][] field;

	public Field() {
		field = new TerrainSquare[6][3];
		
		for(int x = 0; x < 6; x++) {
        	for(int y = 0; y < 3; y++) {
        		field[x][y] = new TerrainSquare();
        		Rectangle rec = new Rectangle();
        		rec.setWidth(109.4433f);
        		rec.setHeight(109.4433f);
        		rec.setX(72 + (109.4433f * x));
        		rec.setY(400 + (109.4433f * y));
        		field[x][y].setRectangle(rec);
        		field[x][y].setX(x);
        		field[x][y].setY(y);
        	}
        }
	}
	
	public void updateAllegiance() {
		for(int x = 0; x < 6; x++) {
			for(int y = 0; y < 3; y++) {
				field[x][y].aligned = false;
			}
		}
		int x;
		boolean found = false;
		for(x = 0; x < 6; x++) {
			for(int y = 0; y < 3; y++) {
				if(field[x][y].hasMonster()) {
					if(field[x][y].getMonster().playerID == 0) {
						found = true;
						break;
					}
				}
			}
			if(found) break;
		}
		for(; x < 6; x++) {
			for(int y = 0; y < 3; y++) {
				field[x][y].aligned = true;
				field[x][y].allegiance = 0;
			}
		}
		
		found = false;
		for(x = 5; x >= 0; x--) {
			for(int y = 0; y < 3; y++) {
				if(field[x][y].hasMonster()) {
					if(field[x][y].getMonster().playerID == 1) {
						found = true;
						break;
					}
				}
			}
			if(found) break;
		}
		for(; x >= 0; x--) {
			for(int y = 0; y < 3; y++) {
				field[x][y].aligned = true;
				field[x][y].allegiance = 1;
			}
		}
	}
	
	public TerrainSquare get(int x, int y) {
		return field[x][y];
	}
	
}
