package br.com.poo.fantasy_quest.animation;

import java.awt.image.BufferedImage;

import br.com.poo.fantasy_quest.entity.Entity;

public class SpriteAnimation implements Animation
{	
	private BufferedImage[] frames;
	
	private double frameTime;
	private double timer;
	
	private int currentFrame;
	
	// vargs BufferedImage...frames
	public SpriteAnimation(double frameTime, BufferedImage...frames)
	{
		this.frameTime = frameTime;
		this.frames = frames;
	}

	@Override
	public void update(double delta) {
		// TODO Auto-generated method stub
		timer += delta;
		
		if(timer >= frameTime)
		{
			timer -= frameTime;
			currentFrame++;
			
			if(currentFrame >= frames.length)
			{
				currentFrame = 0;
			}
		}
	}

	@Override
	public void apply(Entity entity) {
		// TODO Auto-generated method stub
		entity.setSprite(frames[currentFrame]);
	}
	
}
