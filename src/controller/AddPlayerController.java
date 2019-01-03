
package controller;

import javax.swing.JOptionPane;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AddPlayer;
import view.GameEngineCallbackGUI;

public class AddPlayerController 
{
	AddPlayer playerToBeAdded = new AddPlayer();
	
	public AddPlayerController(GameEngine gameEngine, AddPlayer playerToBeAdded) 
	{
		playerToBeAdded.jBAdd.addActionListener(new java.awt.event.ActionListener()
		{
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
	            	String message = "";
	
	            addPlayer(playerToBeAdded.nameText.getText(), Integer.parseInt(playerToBeAdded.xText.getText()), gameEngine);
	
	            	message = "Added the player";
	
	            	JOptionPane.showMessageDialog(null, message ,"Message", JOptionPane.ERROR_MESSAGE); 
            }

        });
	}

	public void addPlayer(String name,int points,GameEngine gameEngine)
    {
        int id = gameEngine.getAllPlayers().size() + 1;
        
        Player player = new SimplePlayer(String.valueOf(id),name,points);
        
        gameEngine.addPlayer(player);
    }
}
