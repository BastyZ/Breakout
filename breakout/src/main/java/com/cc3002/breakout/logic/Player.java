package com.cc3002.breakout.logic;

import com.cc3002.breakout.logic.level.ILevel;

/** Basic player that plays in a ILevel level instance,
 * all players star with the same quantity of hearts (3)
 * and dies when hearts como down to zero.
 * 
 * @author Bastián Inostroza
 * @see ILevel
 */
public class Player implements IPlayer {
  
  protected transient int hearts;
  final protected transient long score;
  
  
  public Player() {
    this.hearts = 3;
    this.score = 0;
  }
  
  public int getNumberOfHearts() {
    return this.hearts;
  }
  
  public int lossOfHeart() {
    this.hearts -= 1;
    return this.hearts;
  }
  
  public long earnedScore() {
    return score;
  }
  
  
  

}
