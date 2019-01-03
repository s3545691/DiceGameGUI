package controller;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;
import view.MainFrame;

public class RollPlayerController 
{
	String name = "";
	
	public RollPlayerController(GameEngine gameEngine, MainFrame mainFrame)
	{
		mainFrame.buttonThree.addActionListener(new java.awt.event.ActionListener() 
		{
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
	            	String message = "";   	
	
	            	if(mainFrame.table.getSelectedRow() < 0)
	            	{
	            		message = "Please select a player to roll !";
	            		JOptionPane.showMessageDialog(null, message ,"Message", JOptionPane.ERROR_MESSAGE);
	            		return;
	            	}
	            	
	            	
	            mainFrame.GUIrolling = true;
	            	
	            mainFrame.currentPlayer = mainFrame.table.getValueAt(mainFrame.table.getSelectedRow(), 1).toString();

	            String id = (mainFrame.table.getValueAt(mainFrame.table.getSelectedRow(), 0).toString());
	
	            	Player player = gameEngine.getPlayer(id);
	            	
	            	if(player.getBet() == 0)
	            	{
	            		System.out.println("Please place your bet first !");
	            		return;
	            	}
	            
	            	new Thread()
	            	{
	            		public void run()
	            		{
	            			gameEngine.rollPlayer(player, 300, 400, 1);
	            		}
	            	}.start();
            }
        });
	}
}
