/**
 * Entity class
 * 
 * This stores variables that will be used in player, monster and NPC classes
 * 
 */

package br.com.poo.fantasy_quest.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

//import br.com.poo.fantasy_quest.animation.Animator;
import br.com.poo.fantasy_quest.entity.enums.Direction;

public abstract class Entity {
	
	private int x, y;
	private int speed;
	private String name;
	
	private Direction 	   direction;
	private BufferedImage  sprite;
	//private Animator 	   animator;  //mudança para DynamicEntity

	
	//public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	//public String direction;
	
	// Getters e Setters
	
    public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public BufferedImage getSprite() {
		return sprite;
	}
	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}

	// deixei aqui os metodos abstratos, pq assim qualquer classe que derive de Entity poderá escrever suas próprias implementações
	public abstract void update(double delta);
	public abstract void draw(Graphics2D g2);
	
}
