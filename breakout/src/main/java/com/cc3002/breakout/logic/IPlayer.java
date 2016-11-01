package com.cc3002.breakout.logic;

/** Determines the basic method that rules a player, works with a 
 *  ILevel type instance for score management.
 * 
 * @author Bastián Inostroza
 * @see ILevel 
 *
 */
public interface IPlayer {
  
  int getNumberOfHearts();
  
  int lossOfHeart();
  
  long earnedScore();

}
