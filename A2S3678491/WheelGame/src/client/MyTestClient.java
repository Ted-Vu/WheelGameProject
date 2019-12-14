package client;

import java.util.Collection;
import java.util.Scanner;
//import java.util.logging.Level;
import java.util.logging.*;
import java.util.logging.Logger;


import model.GameEngineImpl;
import model.SimplePlayer;
import model.SlotImpl;
import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import validate.Validator;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

/**
 * <pre> Simple console client for Further Programming assignment 1, 2019
 * <b>NOTE:</b> This code will not compile until you have implemented code for the supplied interfaces!
 * 
 * You must be able to compile your code WITHOUT modifying this class.
 * Additional testing should be done by copying and adding to this class while ensuring this class still works.
 * 
 * The provided Validator.jar will check if your code adheres to the specified interfaces!</pre>
 * 
 * @author Caspar Ryan
 * 
 */
public class MyTestClient
{
   private static final Logger logger = Logger.getLogger(MyTestClient.class.getName());
   

   public static void main(String args[])
   {
      final GameEngine gameEngine = new GameEngineImpl();
      
      // call method in Validator.jar to test *structural* correctness
      // just passing this does not mean it actually works .. you need to test yourself!
      // pass false if you want to show minimal logging (pass/fail) .. (i.e. ONLY once it passes)
      Validator.validate(true);

      // create some test players
      Player[] players = new Player[] { new SimplePlayer("1", "Come In Spinner", 1000),
         new SimplePlayer("2", "The Loser", 750), new SimplePlayer("3", "The Dabbler", 500),
         new SimplePlayer("4", "The Ted", 500)};

      // add logging callback
      gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());

      // check the wheel creation is correct by inspecting logs
      logWheel(gameEngine.getWheelSlots());

      // main loop to add players and place a bet
      int enumOrdinal = 0;
      for (Player player : players)
      {
         gameEngine.addPlayer(player);
//          mod with BetType length so we always stay in range even if num players increases
         // NOTE: we are passing a different BetType each time!
         gameEngine.placeBet(player,50, BetType.values()[enumOrdinal++ % BetType
            .values().length]);
      }
    
      
      logger.log(Level.INFO, "SPINNING ...");
      
      
      // NOTE: result logging is done via GameEngineCallback.result() 
      // after it calls GameEngine.calculateResult())
//       OutputTrace.txt was generated with these parameter values
      gameEngine.spin(1, 100, 5);
      
      enumOrdinal = 0;
      for (Player player : players)
      {
         gameEngine.addPlayer(player);
//          mod with BetType length so we always stay in range even if num players increases
         // NOTE: we are passing a different BetType each time!
         gameEngine.placeBet(player, -25, BetType.values()[enumOrdinal++ % BetType
            .values().length]);
      }
      logger.log(Level.INFO, "SPINNING ...");
      gameEngine.spin(1, 100, 5);
      
      
      // TODO reset bets for next round if you were playing again
     //Next round second spinning

//Prompting for next round
//      Scanner input = new Scanner(System.in);
//      
//      String playingMore = "";
//      do 
//      {
//    	
//	      for (Player player : players)
//	      {
//	         gameEngine.addPlayer(player);
//	         // mod with BetType length so we always stay in range even if num players increases
//	         // NOTE: we are passing a different BetType each time!
//	         gameEngine.placeBet(player, (int)(Math.random()*(player.getPoints() - 0)) + 0, BetType.values()[enumOrdinal++ % BetType
//	            .values().length]);
//	      }
//	      logger.log(Level.INFO, "SPINNING ...");
//	      gameEngine.spin(1, 200, 5);
//	      System.out.println("Do you want to play more ?(Y/N)");
//	      playingMore = input.nextLine();
//	      for(Player player: players)
//	      {
//	    	  player.resetBet();
//	      }
//	     
//      }
//      while(playingMore.equals("Y"));
//      System.exit(0);
      
   }

   // private helper method to log wheel slots
   private static void logWheel(Collection<Slot> wheel)
   {
      logger.log(Level.INFO, "LOGGING WHEEL DATA CREATED BY GameEngineImpl");
      for (Slot slot : wheel)
         logger.log(Level.INFO, slot.toString());
      logger.log(Level.INFO, "END WHEEL LOG\n");
   }
}
