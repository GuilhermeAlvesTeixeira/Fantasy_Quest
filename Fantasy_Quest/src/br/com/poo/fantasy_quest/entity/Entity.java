/**
 * Entity class
 * 
 * This stores variables that will be used in player, monster and NPC classes
 * 
 */

package br.com.poo.fantasy_quest.entity;

import java.awt.image.BufferedImage;

import br.com.poo.fantasy_quest.animation.Animator;

public class Entity {
	
	public int x, y;
	public int speed;
	
	public Direction 	 direction;
	public BufferedImage sprite;
	public Animator 	 animator;

	
	//public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	//public String direction;
	
	
}
