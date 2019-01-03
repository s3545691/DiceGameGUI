package client;

import view.GameEngineCallbackImpl;
import view.MainFrame;
import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;

public class MyTestClient
{
    
	public static void main(String args[])
	{
		final GameEngine gameEngine = new GameEngineImpl();
		MainFrame mainFrame = new MainFrame(gameEngine);


		Player[] players = new Player[]
				{ new SimplePlayer("1", "The Roller1", 10000), new SimplePlayer("2", "The Loser", 9000)};


		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(mainFrame));

		for (Player player : players)
		{
			gameEngine.placeBet(player, 500);
			gameEngine.addPlayer(player);
			gameEngine.rollPlayer(player, 100, 1000, 10);
		}

		gameEngine.rollHouse(1, 100, 10);
	}
}

