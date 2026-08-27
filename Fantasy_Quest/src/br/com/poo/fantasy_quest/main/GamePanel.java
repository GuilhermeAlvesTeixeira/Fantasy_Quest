package br.com.poo.fantasy_quest.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	//SCREEN SETTINGS
	final int originalTitleSize = 16; //16x16 tile
	final int scale = 3; // 3 * [16px, 16px]
	
	final int tileSize = originalTitleSize * scale; // 48x48 tile size
	
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	
	final int screenWidth = tileSize * maxScreenCol;  //768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 576 pixels
	
	Thread gameThread;
	
	public GamePanel()
	{
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}
	
	public void startGameThread()
	{
		gameThread = new Thread(this); //passing GamePanel class
		gameThread.start();
	}
	
	public void update()
	{
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//changes graphics to graphics2D
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fillRect(100, 100, tileSize, tileSize);
		g2.dispose();
	}
	
	// The Game Loop! Ebaaa
	@Override
	public void run()
	{
		while(gameThread != null)
		{
			// 1. UPDATE: update information such as character positions
			update();
			
			// 2. DRAW: draw the screen with the updated information
			repaint(); // -- calls paintComponent method
		}
	}
}