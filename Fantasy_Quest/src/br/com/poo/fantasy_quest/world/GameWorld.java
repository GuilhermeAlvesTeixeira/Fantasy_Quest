package br.com.poo.fantasy_quest.world;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import br.com.poo.fantasy_quest.entity.Entity;
import br.com.poo.fantasy_quest.main.KeyHandler;

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
	private final List<Entity> entities; //entidades do jogo. ex: player, monstros, sla etc
	
	//Ps de gambiarra: eu sei que não faz sentido GameWorld receber um keyHandler, mas dps eu refatoro
	public GameWorld()
	{	
		//aqui adicionamos entidades ao ciclo de vida do construtor de GameWorld
		entities = new ArrayList<>(); 
		
		//initEntities();
	}
	
	/*
	public void initEntities()
	{		
		//Player player = new Player(k);
		//entities.add(player);
	}
	*/
	
	/*
	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
	*/

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
	
	/**
	 * ::::::::::::::::::::::::::::::::::::::::
	 * ::::::::::::::::::::::::::::::::::::::::
	 */
	
	/**
	 * Adiciona uma entidade ao mundo
	 * @param entity
	 */
	public void addEntity(Entity entity)
	{
		if(entity != null)
		{
			entities.add(entity);
		}
	}
	
	/**
	 * remove uma entidade do mundo
	 * @param entity
	 */	
	public void removeEntity(Entity entity)
	{
		if(entity != null)
		{
			entities.remove(entity);
		}
	}
	
	
}
