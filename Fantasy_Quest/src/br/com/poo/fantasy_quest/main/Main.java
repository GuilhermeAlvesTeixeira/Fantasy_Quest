package br.com.poo.fantasy_quest.main;

import javax.swing.JFrame;

public class Main {
	
	public static final int  width = 800;
	public static final int  height = 600;
	
	
    public static void main(String[] args) {

        JFrame window = new JFrame();

        window.setTitle("Fantasy Quest");
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        GamePanel gamePanel = new GamePanel();
        
        window.add(gamePanel);
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.startGameThread();
    }
}