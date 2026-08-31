package br.com.poo.fantasy_quest.entity;

import java.awt.Graphics2D;

/**
 * @author inctr
 * 
 * StaticEntity representa entidades que não possuem comportamento/movimentação que mudam ao longo do tempo
 * 
 * 
 */
		
public abstract class StaticEntity extends Entity
{	
	@Override
	public void update(double delta)
	{
		// sem atualização dinamica, se precisar de animações usem a classe DynamicEntity em:
		// /Fantasy_Quest/src/br/com/poo/fantasy_quest/entity/DynamicEntity.java
	}
	
	@Override
	public abstract void draw(Graphics2D g2);
}
