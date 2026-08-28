package br.com.poo.fantasy_quest.main;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
	
	
	
	public static final int  width = 800;
	public static final int  height = 600;
	
    public static void main(String[] args) {

        JFrame window = new JFrame();

        String splashText = getRandomSplashText();

        window.setTitle("Fantasy Quest - " + splashText);
        
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        //Loads the icon using getResource so it works even after generating the .jar
        ImageIcon icon = null;
		try 
		{
			icon = new ImageIcon(Main.class.getResource("/br/com/poo/fantasy_quest/icons/Fantasy_Quest_Icon_256x256.png"));
			if (icon.getImage() != null)
			{
				Image image = icon.getImage();
				
				// Sets the icon for both the window top bar and the OS taskbar
				window.setIconImage(image);
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.err.println("Unable to load the game icon.");
			e.printStackTrace();
		}
 
  
        GamePanel gamePanel = new GamePanel();
        
        window.add(gamePanel);
        window.pack();
        
        window.setLocationRelativeTo(null);
        
        // Makes the window visible on the screen. It is called at the very end 
        // to ensure all added components (like GamePanel) render correctly at startup
        window.setVisible(true);
        
        gamePanel.startGameThread();
       
    }
    
    public static String getRandomSplashText() {

        SplashText[] texts = SplashText.values();

        int index = (int) (Math.random() * texts.length);

        return texts[index].getText();
    }
}