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
	
	
	//FPS
	int FPS = 60;
	
    /**
     *  ::::::::::::::::::::::::::::::::::::::::::::::::::
     *  :::::::::::::::: KeyHandler ::::::::::::::::::::::
     *  ::::::::::::::::::::::::::::::::::::::::::::::::::
    **/
	KeyHandler keyH = new KeyHandler();
	
    /**
     *  ::::::::::::::::::::::::::::::::::::::::::::::::::
     *  :::::::::::::::: GAME THREAD :::::::::::::::::::::
     *  ::::::::::::::::::::::::::::::::::::::::::::::::::
    **/
	Thread gameThread;
	
	
	//Set player's default position
	int playerX     = 100;
	int playerY     = 100;
	int playerSpeed = 4;
	
    /**
     *  ::::::::::::::::::::::::::::::::::::::::::::::::::
     *  :::::::::::::::: GAME PANEL :::::::::::::::::::::
     *  ::::::::::::::::::::::::::::::::::::::::::::::::::
    **/
	public GamePanel()
	{
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
		// key input
		this.addKeyListener(keyH);
		this.setFocusable(true); // <- Game Panel can be "focused" to receive key input 
	
	}
	
	public void startGameThread()
	{
		gameThread = new Thread(this); //passing GamePanel class
		gameThread.start();
	}
	
	public void update()
	{	
		// update char position
		
		if(keyH.upPressed == true)
		{
			playerY -= playerSpeed;
		}
		else if(keyH.downPressed == true)
		{
			playerY += playerSpeed;
		}
		else if(keyH.leftPressed == true)
		{
			playerX -= playerSpeed;
		}
		else if(keyH.rightPressed == true)
		{
			playerX += playerSpeed;
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//changes graphics to graphics2D
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose();
	}
	
	//The Game Loop - Abordagem delta accumulator - balde de tempo
	
    /**
     *  ::::::::::::::::::::::::::::::::::::::::::::::::::
     *  :::::::::::::::: GAME LOOP  ::::::::::::::::::::::
     *  ::::::::::::::::::::::::::::::::::::::::::::::::::
    **/
	
	@Override 
	public void run()
	{	
		double drawInterval = 1_000_000_000/FPS; //16,66 ms
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		long timer = 0;
		int drawCount = 0;
		
		while (gameThread != null)
		{	
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			
			//
			timer += (currentTime - lastTime);
			
			lastTime = currentTime;
			
			if (delta >= 1)
			{
				// 1. UPDATE: update information such as character positions
				update();
				
				// 2. DRAW: draw the screen with the updated information
				repaint(); // -- calls paintComponent method	
				
				delta--;
				
				drawCount++; // increase drawCounts!
			}
			
			if (timer >= 1_000_000_000) {System.out.println("FPS: " + drawCount); drawCount = 0; timer = 0;}
		}
	}
	

//Ctrl + Shift + C --> Retira comentários
// 
//	The Game Loop - Abordagem Sleep
//	@Override
//	public void run()
//	{
//		while(gameThread != null)
//		{	
//					
//			//Sleep Method - fix FPS to 60
//			//ps: this means we draw the screen every 0.01666 seconds
//			double drawInterval = 1_000_000_000/FPS; // nanoseconds/fps
//			double nextDrawTime = System.nanoTime() + drawInterval;
//			
//			// 1. UPDATE: update information such as character positions
//			update();
//			
//			// 2. DRAW: draw the screen with the updated information
//			repaint(); // -- calls paintComponent method
//			
//			try 
//			{
//				double remainingTime = nextDrawTime - System.nanoTime();
//				remainingTime /= 1_000_000; // nano -> milisseconds
//				
//				if(remainingTime < 0)
//				{
//					remainingTime = 0;
//				}
//				
//				Thread.sleep((long)remainingTime);
//				
//				nextDrawTime += drawInterval;
//			} 
//			catch (InterruptedException e) 
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//	}
}