package br.com.poo.fantasy_quest.animation;

import br.com.poo.fantasy_quest.entity.Entity;

public interface Animation 
{
	void update(double delta);
	void apply(Entity entity);
}
