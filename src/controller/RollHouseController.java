package controller;

import java.util.List;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;
import view.MainFrame;

public class RollHouseController 
{
	public RollHouseController(GameEngine gameEngine, MainFrame mainFrame) 
	{
		mainFrame.buttonTwo.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
				 List<Player> players = (List) gameEngine.getAllPlayers();
			        
				 for(Player player:players)
				 {   
					 if(player.getRollResult() == null)
					 {     
						 System.out.println("Please roll all of the players first !");
						 return;
					 }
				 }
			        
				 new Thread()
				 {
					 public void run()
					 {
						 gameEngine.rollHouse(1, 20, 1);

						 List<Player> players = ((GameEngineImpl)gameEngine).getPlayers();

						 for(Player player:players)
						 {
							 ((SimplePlayer)player).resetBet();
							 ((SimplePlayer)player).resetRollResult();
						 }
					 }

				 }.start();
			        

            }
        });
	}
}
