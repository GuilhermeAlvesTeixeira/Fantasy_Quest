package br.com.poo.fantasy_quest.world;

import java.awt.Color;
import java.awt.Graphics2D;

import br.com.poo.fantasy_quest.main.GameConfig;

public class GameMap 
{
	private final int[][] tiles;
	
	public GameMap()
	{
		// tiles hardcoded
		tiles = new int[][] {
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, //16
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
			//16
		};
	}
	
	//Bem programação 1 isso daqui...
	
	public void draw(Graphics2D g2)
	{
		for(int row = 0; row < tiles.length; row++)
		{
			for(int col = 0; col < tiles[0].length; col++)
			{
				int x = col * GameConfig.TILE_SIZE;
				int y = row * GameConfig.TILE_SIZE;
				
				if(tiles[row][col] == 0)
				{
					g2.setColor(Color.DARK_GRAY);
				}
				else if(tiles[row][col] == 1)
				{
					g2.setColor(Color.BLACK);
				}
				
				g2.fillRect(x, y, GameConfig.TILE_SIZE, GameConfig.TILE_SIZE);
			}
		}
	}//#
	
	
	
	
	
}
