package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
import model.SimplePlayer;
import model.interfaces.DicePair;
import view.GameEngineCallbackGUI;

public class GameEngineImpl implements GameEngine {
	private List<Player> players;

	private List<GameEngineCallback> gameEngineCallbacks;

	public GameEngineImpl() {
		players = new ArrayList<Player>();
		gameEngineCallbacks = new ArrayList();
	}

	public int roll(int NUM_FACES) {
		Random rand = new Random();

		return (int) rand.nextInt(NUM_FACES) + 1;
	}

	@Override
	public boolean removePlayer(Player player) {
		return players.remove(player);
	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		DicePairImpl dicePair = null;

		for (int i = initialDelay; i < finalDelay; i += delayIncrement) {
			dicePair = new DicePairImpl(roll(NUM_FACES), roll(NUM_FACES), NUM_FACES);
			for (GameEngineCallback GameEngineCallback : gameEngineCallbacks) {
				GameEngineCallback.intermediateHouseResult(dicePair, this);
			}
			try {
				Thread.sleep(initialDelay);
			} catch (InterruptedException ex) {
				Logger.getLogger(GameEngineImpl.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		for (Player player : players) 
		{

			if ((player.getRollResult().getDice1() + player.getRollResult().getDice2()) > (dicePair.getDice1() + dicePair.getDice2())) 
			{
				String message = String.format("%s won!", player.getPlayerName());
				player.setPoints(player.getPoints() + player.getBet() * 2);
    	  	 	JOptionPane.showMessageDialog(null, message ,"Message", JOptionPane.ERROR_MESSAGE);
			}

			else if ((player.getRollResult().getDice1() + player.getRollResult().getDice2()) < (dicePair.getDice1() + dicePair.getDice2())) 
			{
				String message = String.format("%s lost!", player.getPlayerName());
				player.setPoints(player.getPoints());
				JOptionPane.showMessageDialog(null, message ,"Message", JOptionPane.ERROR_MESSAGE);
			}
			((SimplePlayer) player).resetBet();
			((SimplePlayer) player).resetRollResult();
		}

		for (GameEngineCallback GameEngineCallback : gameEngineCallbacks) 
		{
			GameEngineCallback.houseResult(dicePair, this);
		}

	}

	@Override
	public boolean placeBet(Player player, int bet) {
		return player.placeBet(bet);
	}

	@Override
	public Player getPlayer(String id) {

		for (Player player : players) {
			if (player.getPlayerId().equals(id))
				return player;
		}
		return null;
	}

	@Override
	public void addPlayer(Player newPlayer) 
	{
		players.add(newPlayer);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback)
	{
		this.gameEngineCallbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		return this.gameEngineCallbacks.remove(gameEngineCallback);
	}

	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement)
	{

		if (!players.contains(player))
			return;

		if (player.getBet() > 0) {
			DicePairImpl dicePair = null;

			for (int i = initialDelay; i < finalDelay; i += delayIncrement) {
				dicePair = new DicePairImpl(roll(NUM_FACES), roll(NUM_FACES), NUM_FACES);
				for (GameEngineCallback GameEngineCallback : gameEngineCallbacks) {
					GameEngineCallback.intermediateResult(player, dicePair, this);
				}
				try {
					Thread.sleep(initialDelay);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
			player.setRollResult(dicePair);

			for (GameEngineCallback GameEngineCallback : gameEngineCallbacks) 
			{
				GameEngineCallback.result(player, player.getRollResult(), this);
			}
		}
	}

	@Override
	public Collection<Player> getAllPlayers()
	{

		return Collections.unmodifiableList(this.players);
	}

	public List<GameEngineCallback> getGameEngineCallback() 
	{
		return gameEngineCallbacks;
	}

	public List<Player> getPlayers() 
	{
		return players;
	}
}