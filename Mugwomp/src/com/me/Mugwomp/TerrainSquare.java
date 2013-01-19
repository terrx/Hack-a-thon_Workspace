package com.me.Mugwomp;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class TerrainSquare {

	Rectangle myPos;
	
	Monster myMonster = null;
	
	boolean aligned = false;
	
	int allegiance;
	
	int x;
	int y;

	
	public void setMonster(Monster mon) {
		myMonster = mon;
	}
	
	public Monster getMonster() {
		return myMonster;
	}
	
	public void setRectangle(Rectangle rec) {
		myPos = rec;
	}
	
	public Rectangle getRectangle() {
		return myPos;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}

	public boolean hasMonster() {
		return myMonster != null;
	}

	public void render(SpriteBatch batch, ArrayList<Texture> monsterTextures, ArrayList<Texture> flipedMonsterTextures) {
		if(hasMonster()) {
			ArrayList<Texture> texts;
			if(myMonster.facing) {
				texts = monsterTextures;
			} else {
				texts = flipedMonsterTextures;
			}
			batch.draw(texts.get(myMonster.getId()),myPos.x,myPos.y);
		}
	}
}
