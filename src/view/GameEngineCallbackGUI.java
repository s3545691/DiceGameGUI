package view;

import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackGUI implements GameEngineCallback
{
    MainFrame mainFrame;

    
    public GameEngineCallbackGUI(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }

    @Override
    public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) 
    { 

    			mainFrame.currentPlayer = player.getPlayerName();
    		
    		
	    	SwingUtilities.invokeLater(new Runnable()
	    	{
	    		public void run()
	    		{
		    			mainFrame.doRefDices(dicePair);
		    			mainFrame.doRefName(player.getPlayerName(),dicePair);
	    			
	    		}
	    	});  
    }

    @Override
    public void result(Player player, DicePair result, GameEngine gameEngine) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                mainFrame.table();
            }
        });
    }

    @Override
    public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) 
    {
       SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                mainFrame.doRefDices(dicePair);
                mainFrame.doRefName("House",dicePair);
            }
        });
    }

    @Override
    public void houseResult(DicePair result, GameEngine gameEngine) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                mainFrame.table();
                mainFrame.doRefTextArea(result,gameEngine);
            }
        });
    }
}
