package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player,Cloneable
{
    private String playerName, playerId;
    
    private int points, bet;
    
    private DicePair rollResult;
    
    public SimplePlayer(String playerId, String playerName, int initialPoints)
    {
        this.playerId = playerId;
        this.playerName = playerName;
        this.points = initialPoints;
    }
    
    @Override
    public String getPlayerName()
    {
        return playerName;
    }
    
    @Override
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }
    
    @Override
    public int getPoints()
    {
        return points;
    }
    
    @Override
    public void setPoints(int points)
    {
        this.points = points;
    }
    
    @Override
    public String getPlayerId()
    {
        return playerId;
    }

    @Override
    public boolean placeBet(int bet) 
    {

    		if (bet > 0 && points >= bet)
    		{
    			this.bet = bet;
    			points -= bet;
    			return true;
    		}

    		return false;    
    }
    
    @Override
    public int getBet()
    {
        return bet;
    }
    
    public void resetBet()
    {
        this.bet = 0;
    }
    
    @Override
    public DicePair getRollResult()
    {
        return rollResult;
    }
    
    @Override
    public void setRollResult(DicePair rollResult)
    {
        this.rollResult = rollResult;
    }
    
    public void resetRollResult()
    {
        this.rollResult = null;
    }

    @Override
    public String toString()
    {
        String playerInfo = "";
        
        playerInfo = "Player: id = " + this.playerId + ", name = " + this.playerName  + ", points = " + this.points;
        
        return playerInfo;
    }
 
    
}
