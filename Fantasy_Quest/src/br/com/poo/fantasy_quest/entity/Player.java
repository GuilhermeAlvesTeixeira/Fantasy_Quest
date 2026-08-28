package br.com.poo.fantasy_quest.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.com.poo.fantasy_quest.animation.AnimationState;
//Animations
import br.com.poo.fantasy_quest.animation.Animator;
import br.com.poo.fantasy_quest.animation.SpriteAnimation;
import br.com.poo.fantasy_quest.main.GamePanel;
import br.com.poo.fantasy_quest.main.KeyHandler;

public class Player extends Entity {
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH)
	{
		this.gp = gp;
		this.keyH = keyH;
		
		animator = new Animator();
		
		setDefaultValues();
		getPlayerImage(); // obs: usa animator
		
		
	}
	
	public void setDefaultValues()
	{
		x = 100;
		y = 100;
		speed = 4;
		direction = Direction.DOWN;
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
			
			animator.addAnimation(AnimationState.WALK,
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
			
			animator.addAnimation(AnimationState.WALK,
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
			
			animator.addAnimation(AnimationState.WALK,
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
			
			animator.addAnimation(AnimationState.WALK,
					Direction.UP, 
					new SpriteAnimation(0.15, 
							sprites[12], 
							sprites[13], 
							sprites[14], 
							sprites[15])
					);
			
			animator.setState(AnimationState.WALK, Direction.DOWN);
			
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
		// update char position
		
		if(keyH.upPressed == true)
		{
			y -= speed;
			direction = Direction.UP;
			
			animator.setState(AnimationState.WALK, direction);
		}
		else if(keyH.downPressed == true)
		{
			y += speed;
			direction = Direction.DOWN;
			
			animator.setState(AnimationState.WALK, direction);
		}
		else if(keyH.leftPressed == true)
		{
			x -= speed;
			direction = Direction.LEFT;
			
			animator.setState(AnimationState.WALK, direction);
		}
		else if(keyH.rightPressed == true)
		{
			x += speed;
			direction = Direction.RIGHT;
			
			animator.setState(AnimationState.WALK, direction);
		}
		
		animator.update(delta);
		animator.apply(this);
	}
	
	public void draw(Graphics2D g2)
	{
		g2.drawImage(sprite, x, y, gp.tileSize, gp.tileSize, null);
	}
}
