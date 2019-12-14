package model;

import client.SimpleTestClient;
import model.enumeration.BetType;
import model.interfaces.Player;
/**
 * <pre> Assignment interface for Further Programming representing the player
 * to be implemented by SimplePlayer class with the following constructor:
 * 	  <b>public SimplePlayer(String playerId, String playerName, int initialPoints)</b>
 * 
 * <b>NOTE:</b> playerID is unique and if another player with same id is added it replaces the previous player</pre>
 *
 * @author Caspar Ryan
 * 
 */
public class SimplePlayer implements Player  {
			
	
	private String playerID;
	private String playerName;
	private int initialPoints;
	private int bet;
	private BetType betType;
	
	
	public SimplePlayer(String playerID, String playerName, int initialPoints)
	{
		this.playerID = playerID;
		this.playerName = playerName;
		this.initialPoints = initialPoints;	
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
		return initialPoints;
	}


	@Override
	public void setPoints(int points) 
	{
		initialPoints = points; 	
	}


	@Override
	public String getPlayerId() 
	{	
		return playerID;
	}


	@Override
	public boolean setBet(int bet) 
	{
		boolean result = false;
		
		if(bet > 0 && this.initialPoints >= bet)
		{
			this.bet = bet;
			result = true;
		}
		return result;
	}


	@Override
	public int getBet() 
	{
		return bet;
	}


	@Override
	public void setBetType(BetType betType)
	{
		this.betType = betType; 		
	}


	@Override
	public BetType getBetType()
	{
		return betType;
	}


	@Override
	public void resetBet() 
	{
		this.bet = 0;		
	}
	
	public String toString()
	{
		return String.format("Player:  id=%s,  name=%s, bet=%d  betType=%s, points=%d\n",
							  getPlayerId(),  getPlayerName(),  getBet(), getBetType().toString(), getPoints());
	}
	
	
}
