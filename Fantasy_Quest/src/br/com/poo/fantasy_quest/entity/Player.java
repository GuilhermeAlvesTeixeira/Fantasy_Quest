package br.com.poo.fantasy_quest.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.com.poo.fantasy_quest.animation.SpriteAnimation;
import br.com.poo.fantasy_quest.animation.enums.AnimationState;
import br.com.poo.fantasy_quest.entity.enums.Direction;

//import br.com.poo.fantasy_quest.animation.AnimationState;

//import br.com.poo.fantasy_quest.animation.Animator;
//import br.com.poo.fantasy_quest.animation.SpriteAnimation;
//import br.com.poo.fantasy_quest.main.GamePanel;

import br.com.poo.fantasy_quest.main.GameConfig;
import br.com.poo.fantasy_quest.main.KeyHandler;

public class Player extends DynamicEntity {
	
	KeyHandler keyH;
	
	public Player(KeyHandler keyH)
	{
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage(); // obs: usa animator
	}
	
	public void setDefaultValues()
	{	
		this.setX(100);
		this.setY(100);
		this.setSpeed(4);
		this.setDirection(Direction.DOWN);
	}
	
	public void getPlayerImage()
	{
		try 
		{
			BufferedImage[] sprites = new BufferedImage[16]; //Allocate 16 
			
			for(int i = 0; i < sprites.length; i++)
			{
				String path = String.format(
						"/br/com/poo/fantasy_quest/player/%02d_ch_man001.png", i
				);
				
				sprites[i] = ImageIO.read(getClass().getResourceAsStream(path));
			}
			
			/**
			 * ::::::::::::::::::::::::::
			 * ::::::::: DOWN :::::::::::
			 * ::::::::::::::::::::::::::
			 */
			
			this.getAnimator().addAnimation(AnimationState.WALK,
					Direction.DOWN, 
					new SpriteAnimation(0.15, 
							sprites[0], 
							sprites[1], 
							sprites[2], 
							sprites[3])
					);
			
			/**
			 * ::::::::::::::::::::::::::
			 * ::::::::: LEFT :::::::::::
			 * ::::::::::::::::::::::::::
			 */
			
			this.getAnimator().addAnimation(AnimationState.WALK,
					Direction.LEFT, 
					new SpriteAnimation(0.15, 
							sprites[4], 
							sprites[5], 
							sprites[6], 
							sprites[7])
					);
			
			/**
			 * ::::::::::::::::::::::::::
			 * ::::::::: RIGHT :::::::::::
			 * ::::::::::::::::::::::::::
			 */
			
			this.getAnimator().addAnimation(AnimationState.WALK,
					Direction.RIGHT, 
					new SpriteAnimation(0.15, 
							sprites[8], 
							sprites[9], 
							sprites[10], 
							sprites[11])
					);
			
			/**
			 * ::::::::::::::::::::::::::
			 * :::::::::: UP  :::::::::::
			 * ::::::::::::::::::::::::::
			 */
			
			this.getAnimator().addAnimation(AnimationState.WALK,
					Direction.UP, 
					new SpriteAnimation(0.15, 
							sprites[12], 
							sprites[13], 
							sprites[14], 
							sprites[15])
					);
			
			this.getAnimator().setState(AnimationState.WALK, Direction.DOWN);
			
		}
		catch (IOException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//alt shift + r
	public void update(double delta)
	{
		// TODO Auto-generated method stub
		this.updateMovement();
		
		this.getAnimator().update(delta);
		this.getAnimator().apply(this);
	}
	
	public void updateMovement()
	{	
		//Agora que os atributos de Entity são privados, atualizamos os calculos com os getters
		
		if(keyH.upPressed == true)
		{
			setY(getY() - getSpeed()); // feio, mas é a vida :P | y-= speed
			setDirection(Direction.UP);
			getAnimator().setState(AnimationState.WALK, getDirection());
		}
		else if(keyH.downPressed == true)
		{
			setY(getY() + getSpeed()); // feio, mas é a vida :P | y+= speed
			setDirection(Direction.DOWN);
			getAnimator().setState(AnimationState.WALK, getDirection());
		}
		else if(keyH.leftPressed == true)
		{
			setX(getX() - getSpeed()); // feio, mas é a vida :P | x-= speed
			setDirection(Direction.LEFT);
			getAnimator().setState(AnimationState.WALK, getDirection());
		}
		else if(keyH.rightPressed == true)
		{
			setX(getX() + getSpeed()); // feio, mas é a vida :P | x+= speed
			setDirection(Direction.RIGHT);
			getAnimator().setState(AnimationState.WALK, getDirection());
		}
		
	}
	
	@Override
	public void draw(Graphics2D g2)
	{	
		// TODO Auto-generated method stub
		g2.drawImage(this.getSprite(), this.getX(), this.getY(), GameConfig.TILE_SIZE, GameConfig.TILE_SIZE, null);
	}
}
