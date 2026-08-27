package br.com.poo.fantasy_quest.main;

import java.awt.Color;
import java.awt.Dimension;

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
	
	// The Game Loop! Ebaaa
	@Override
	public void run()
	{
		
	}
}