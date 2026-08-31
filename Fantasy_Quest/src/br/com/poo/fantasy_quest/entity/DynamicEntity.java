package br.com.poo.fantasy_quest.entity;

import java.awt.Graphics2D;

import br.com.poo.fantasy_quest.animation.Animator;

/**
 * @author inctr
 * 
 * DynamicEntity representa entidades que possuem comportamento/movimentação que mudam ao longo do tempo
 * 
 */
public class DynamicEntity extends Entity {
	
	private Animator animator;
	
	public DynamicEntity() 
	{
		animator = new Animator();
	}

	public Animator getAnimator() {
		return animator;
	}

	public void setAnimator(Animator animator) {
		this.animator = animator;
	}

	@Override
	public void update(double delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
