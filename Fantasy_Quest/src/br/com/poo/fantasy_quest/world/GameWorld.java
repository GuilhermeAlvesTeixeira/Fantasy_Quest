package br.com.poo.fantasy_quest.world;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import br.com.poo.fantasy_quest.entity.Entity;

/**
 * @author inctr
 * @version 1.0
 * 
 * Define o mundo em que está sendo jogado, quais entidades existem autalmente no mundo.
 *
 * TécnicA: Polimorfismo. Antes eu desenhava todas as entidades no GamePanel
 *
 */
public class GameWorld 
{
	private List<Entity> entities; //entidades do jogo. ex: player, monstros, sla etc
	
	public GameWorld()
	{	
		//Adicionamos entidades ao ciclo de vida do construtor de GameWorld
		entities = new ArrayList<>(); 
	}
	
	public void update(double delta)
	{
		for(Entity entity : entities)
		{
			entity.update(delta);
		}
	}
	
	public void draw(Graphics2D g2)
	{
		for(Entity entity : entities)
		{
			entity.draw(g2);		
		}
	}
	
	
}
