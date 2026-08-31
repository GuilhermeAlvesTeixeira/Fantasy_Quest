package br.com.poo.fantasy_quest.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import br.com.poo.fantasy_quest.entity.Player;
import br.com.poo.fantasy_quest.world.GameWorld;

public class GamePanel extends JPanel implements Runnable{
	//SCREEN SETTINGS
	final int originalTitleSize = GameConfig.ORIGINAL_TILE_SIZE; //16x16 tile
	final int scale = GameConfig.SCALE; // 3 * [16px, 16px]
	
	public final int tileSize = GameConfig.TILE_SIZE; // 48x48 tile size
	
	final int maxScreenCol = GameConfig.MAX_SCREEN_COL;
	final int maxScreenRow = GameConfig.MAX_SCREEN_ROW;
	
	final int screenWidth = GameConfig.SCREEN_WIDTH;  //768 pixels
	final int screenHeight = GameConfig.SCREEN_HEIGHT; // 576 pixels
	
	private final GameWorld gameWorld; // privado. Não queremos que expor o mundo certo? vai que alguem apaga as entidades :P
	
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
		
		//ps: iniciar aqui as entidades
		gameWorld = new GameWorld();
		
		/*
		 * :::::::::: PLAYER ::::::::::::::;
		 */
		Player player = new Player(keyH);
		gameWorld.addEntity(player);
	
	}
	
	public void startGameThread()
	{
		gameThread = new Thread(this); //passing GamePanel class
		gameThread.start();
	}
	
	public void update(double delta)
	{
		gameWorld.update(delta);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//changes graphics to graphics2D
		Graphics2D g2 = (Graphics2D)g;
		
		//player.draw(g2);
		gameWorld.draw(g2);
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
		long lastTime = System.nanoTime();
		double acc = 0.0; //acumulador
		int drawCount = 0;
		
		while(gameThread != null)
		{
			long currentTime = System.nanoTime();
			double elapsedTime = (currentTime - lastTime) / 1_000_000_000.0;
			
			lastTime = currentTime;
			
			acc += elapsedTime;
			
			while(acc >= GameConfig.TIME_STEP)
			{
				update(GameConfig.TIME_STEP);
				acc -= GameConfig.TIME_STEP;
			
			}
			repaint();
		}
	}
	
//	@Override 
//	public void run()
//	{	
//		double drawInterval = 1_000_000_000/FPS; //16,66 ms
//		double delta = 0;
//		
//		long lastTime = System.nanoTime();
//		long currentTime;
//		
//		long timer = 0;
//		int drawCount = 0;
//		
//		while (gameThread != null)
//		{	
//			currentTime = System.nanoTime();
//			
//			delta += (currentTime - lastTime) / drawInterval;
//			
//			//tempo real decorrido. PS: NAO TROCAR ISSO DAQUI PQ ANIMATOR UTILIZA
//			//tenho que aprender fixed time stamp urgentemente
//			double elapsed = (currentTime - lastTime) / 1_000_000_000.0;
//			
//			timer += (currentTime - lastTime);
//			
//			lastTime = currentTime;
//			
//			if (delta >= 1)
//			{
//				// 1. UPDATE: update information such as character positions
//				update(delta);
//				
//				// 2. DRAW: draw the screen with the updated information
//				repaint(); // -- calls paintComponent method	
//				
//				delta--;
//				
//				drawCount++; // increase drawCounts!
//			}
//			
//			//check fps
//			if (timer >= 1_000_000_000) {System.out.println("FPS: " + drawCount); drawCount = 0; timer = 0;}
//		}
//	}
	

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