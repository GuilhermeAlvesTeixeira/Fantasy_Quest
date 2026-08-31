package br.com.poo.fantasy_quest.animation;

import java.util.HashMap;
import java.util.Map;

import br.com.poo.fantasy_quest.entity.Entity;
import br.com.poo.fantasy_quest.entity.enums.Direction;
import br.com.poo.fantasy_quest.animation.enums.AnimationState;

public class Animator {
	
	private Map<AnimationState, Map<Direction, Animation>> animations;
	private AnimationState currentState;
	private Direction currentDirection;
	private Animation currentAnimation;
	
	
	public Animator()
	{
		animations = new HashMap<>();
	}
	
	public void addAnimation(AnimationState state, Direction direction, Animation animation)
	{
		animations
			.computeIfAbsent(state, k -> new HashMap<>())
			.put(direction, animation);
	}
	
	public void setState(AnimationState state, Direction direction)
	{

	    if (currentState == state && currentDirection == direction)
	    {
	        return;
	    }
		
		currentState = state;
		currentDirection = direction;
		
		Map<Direction, Animation> stateAnimations = animations.get(state);
		
		if (stateAnimations != null)
		{
			currentAnimation = stateAnimations.get(direction);
		}
	}
	
	public void update(double delta)
	{
		if(currentAnimation != null)
		{
			currentAnimation.update(delta);
		}
	}
	
	public void apply(Entity entity)
	{
		if(currentAnimation != null)
		{
			currentAnimation.apply(entity);
		}
	}
}
