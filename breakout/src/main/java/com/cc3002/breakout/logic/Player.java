package com.cc3002.breakout.logic;

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
  
  @Override
  public int getNumberOfHearts() {
    return this.hearts;
  }
  
  @Override
  public int lossOfHeart() {
    this.hearts -= 1;
    return this.hearts;
  }
  
  @Override
  public long earnedScore() {
    return score;
  }
  
  
  

}
