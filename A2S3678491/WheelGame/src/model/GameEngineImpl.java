package model;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {

	
    
	private List<Player> players = new LinkedList<>();
	
	private List<GameEngineCallback> gameCallbacks = new ArrayList<>();
	
	private List<Slot> slots = new  ArrayList<>();
	

	private void addSlot()
	{
		Slot slot_1 = new SlotImpl(0, Color.GREEN00, 0);
		Slot slot_2 = new SlotImpl(1, Color.RED, 27);
		Slot slot_3 = new SlotImpl(2, Color.BLACK, 10);
		Slot slot_4 = new SlotImpl(3, Color.RED, 25);
		Slot slot_5 = new SlotImpl(4, Color.BLACK, 29);
		Slot slot_6 = new SlotImpl(5, Color.RED, 12);
		Slot slot_7 = new SlotImpl(6, Color.BLACK, 8);
		Slot slot_8 = new SlotImpl(7, Color.RED, 19);
		Slot slot_9 = new SlotImpl(8, Color.BLACK, 31);
		Slot slot_10 = new SlotImpl(9, Color.RED, 18);
		Slot slot_11 = new SlotImpl(10, Color.BLACK, 6);
		Slot slot_12 = new SlotImpl(11, Color.RED, 21);
		Slot slot_13 = new SlotImpl(12, Color.BLACK, 33);
		Slot slot_14 = new SlotImpl(13, Color.RED, 16);
		Slot slot_15 = new SlotImpl(14, Color.BLACK, 4);
		Slot slot_16 = new SlotImpl(15, Color.RED, 23);
		Slot slot_17 = new SlotImpl(16, Color.BLACK, 35);
		Slot slot_18 = new SlotImpl(17, Color.RED, 14);
		Slot slot_19 = new SlotImpl(18, Color.BLACK, 2);
		Slot slot_20 = new SlotImpl(19, Color.GREEN0, 0);
		Slot slot_21 = new SlotImpl(20, Color.BLACK, 28);
		Slot slot_22 = new SlotImpl(21, Color.RED, 9);
		Slot slot_23 = new SlotImpl(22, Color.BLACK, 26);
		Slot slot_24 = new SlotImpl(23, Color.RED, 30);
		Slot slot_25 = new SlotImpl(24, Color.BLACK, 11);
		Slot slot_26 = new SlotImpl(25, Color.RED, 7);
		Slot slot_27 = new SlotImpl(26, Color.BLACK, 20);
		Slot slot_28 = new SlotImpl(27, Color.RED, 32);
		Slot slot_29 = new SlotImpl(28, Color.BLACK, 17);
		Slot slot_30 = new SlotImpl(29, Color.RED, 5);
		Slot slot_31 = new SlotImpl(30, Color.BLACK, 22);
		Slot slot_32 = new SlotImpl(31, Color.RED, 34);
		Slot slot_33 = new SlotImpl(32, Color.BLACK, 15);
		Slot slot_34 = new SlotImpl(33, Color.RED, 3);
		Slot slot_35 = new SlotImpl(34, Color.BLACK, 24);
		Slot slot_36 = new SlotImpl(35, Color.RED, 36);
		Slot slot_37 = new SlotImpl(36, Color.BLACK,13);
		Slot slot_38 = new SlotImpl(37, Color.RED, 1);
		
		slots.add(slot_1);
		slots.add(slot_2);
		slots.add(slot_3);
		slots.add(slot_4);
		slots.add(slot_5);
		slots.add(slot_6);
		slots.add(slot_7);
		slots.add(slot_8);
		slots.add(slot_9);
		slots.add(slot_10);
		slots.add(slot_11);
		slots.add(slot_12);
		slots.add(slot_13);
		slots.add(slot_14);
		slots.add(slot_15);
		slots.add(slot_16);
		slots.add(slot_17);
		slots.add(slot_18);
		slots.add(slot_19);
		slots.add(slot_20);
		slots.add(slot_21);
		slots.add(slot_22);
		slots.add(slot_23);
		slots.add(slot_24);
		slots.add(slot_25);
		slots.add(slot_26);
		slots.add(slot_27);
		slots.add(slot_28);
		slots.add(slot_29);
		slots.add(slot_30);
		slots.add(slot_31);
		slots.add(slot_32);
		slots.add(slot_33);
		slots.add(slot_34);
		slots.add(slot_35);
		slots.add(slot_36);
		slots.add(slot_37);
		slots.add(slot_38);	
	}
	
	@Override
	public void spin(int initialDelay, int finalDelay, int delayIncrement)
	{
							
		//Randomly pick one slot from the collection of slots
		Random rand = new Random();
		Slot currentSlot = slots.get(rand.nextInt(slots.size()));
		
		
		//create an iterator and iterate to random slot so we can continue to iterate in the actual spinning
		Iterator<Slot> slotIterator = slots.iterator();	
		iterateToCurrentSlot(currentSlot, slotIterator);
		
		//reference variable used to check condition before assigning to currentSlot
		Slot nextSlot =null;
		
		//the actual spinning when the ball starts rolling
		while(initialDelay < finalDelay)
		{
			  
				
				for(GameEngineCallback gameEngineCallbackLoop : gameCallbacks)
				{
				      gameEngineCallbackLoop.nextSlot(currentSlot, this);
				}
						
				
				//checking if iterate at lastSlot if yes:create a new iterator
				slotIterator = checkingIfAtLastSlot(slotIterator, currentSlot);
				
				nextSlot = slotIterator.next();
				
				currentSlot = nextSlot;
			
				//delay system while ball rolling
				delaySystem(initialDelay);
	
				initialDelay += delayIncrement;
		}
		
		//delay system when ball stops
//		delaySystem(finalDelay);
		
		for(GameEngineCallback gameEngineCallbackLoop : gameCallbacks)
		{
		      gameEngineCallbackLoop.result(currentSlot, this);
		}
	}

	private void delaySystem(int delay) 
	{
		try 
		{
			Thread.sleep(delay);
		} 
		catch (InterruptedException e) 
		{	
			e.printStackTrace();
		}
	}


	private Iterator<Slot> checkingIfAtLastSlot(Iterator<Slot> slotProcess, Slot nextSlotProcess) 
	{
		Slot lastSlot = new SlotImpl(37, Color.RED, 1);

		if(nextSlotProcess.equals(lastSlot))
		{
			slotProcess = slots.iterator();			
		}
		return slotProcess;
	}

	
	//after picking random slot iterate to that slot in the actual spinning
	private void iterateToCurrentSlot(Slot randomSlot, Iterator<Slot> slotProcess) 
	{
		while(slotProcess.hasNext())
		{
			Slot slotLocate = slotProcess.next();
			if(randomSlot.equals(slotLocate))
			{
				break;
			}
		}
	}
	
	 
	@Override
	public void calculateResult(Slot winningSlot) 
	{
		for(Player player : players)
		{
			player.getBetType().applyWinLoss(player, winningSlot);
		}
	}
	
	@Override
	public void addPlayer(Player player) 
	{
		boolean addPlayerResult = true;
		Iterator<Player> iter = players.iterator();
		
		//check duplicate playerID and replace
		addPlayerResult = checkingAddPlayer(player, addPlayerResult, iter);
		
		if(addPlayerResult == true)
		{
			players.add(player);
		}
	}

	private boolean checkingAddPlayer(Player player, boolean addPlayerResult, Iterator<Player> iter) 
	{
		while(iter.hasNext())
		{
			Player temp = iter.next();
			if(temp.getPlayerId().equals(player.getPlayerId()))
			{
				players.remove(temp);
				players.add((SimplePlayer) player);
				addPlayerResult = false;
				break;
			}
		}
		return addPlayerResult;
	}

	@Override
	public Player getPlayer(String id)
	{
		Iterator<Player> iter = players.iterator();
		while(iter.hasNext())
		{
			Player temp = iter.next();
			if(temp.getPlayerId().equals(id))
			{
				return temp;
			}	
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) 
	{
		boolean remove = false;
		Iterator<Player> iter = players.iterator();
		while(iter.hasNext())
		{
			Player temp = iter.next();
			if(temp.getPlayerId().equals(player.getPlayerId()))
			{
				players.remove(temp);
				remove = true; 
				break;
			}
		}		
		return remove;
	}

	
	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		gameCallbacks.add(gameEngineCallback);	
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
			
		boolean remove = false;
		Iterator<GameEngineCallback> iter = gameCallbacks.iterator();
		while(iter.hasNext())
		{
			GameEngineCallback temp = iter.next();
			if(temp.equals(gameEngineCallback))
			{
				gameCallbacks.remove(temp);
				remove = true; 
				break;
			}
		}	
		return remove;
	}
	
	//unmodifiable collection of players
	@Override
	public Collection<Player> getAllPlayers() 
	{
		Collection<Player> unmodifiableCollectionOfPlayer = Collections.unmodifiableCollection(players);
		return unmodifiableCollectionOfPlayer;
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) 
	{
		
		boolean placeBet = false;
		for(Player onePlayer : players)
		{
			if(onePlayer.getPlayerId().equals(player.getPlayerId()))
			{
				//only set betType if bet placed satisfied
				if(onePlayer.setBet(bet))
				{
					onePlayer.setBetType(betType);
					placeBet = true;
				}
			}
		}
		return placeBet;		
	}	
	
	@Override
	public Collection<Slot> getWheelSlots()
	{	
		addSlot();
		return slots;
	}	
}
