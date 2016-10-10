package com.cc3002.breakout.facade;

import java.util.List;

import com.cc3002.breakout.logic.IBrick;
import com.cc3002.breakout.logic.ILevel;
import com.cc3002.breakout.logic.IPlayer;
import com.cc3002.breakout.logic.Level;

/** Facade class with the minimum amount of elements (variables),
 *  and all the basic methods for enable logical behavior of the game.
 * 
 * @author Bastián Inostroza
 *
 */
public class HomeworkOneFacade {
  private final transient boolean nextLevel;
  private transient ILevel currentLevel;
  private transient IPlayer currentPlayer;
  
  
  public HomeworkOneFacade() {
    this.nextLevel = false;
  }
  
  /** Sets a level with an arbitrary probability of
   *  soft bricks (between 0 and 1) for a cretain quantity of bricks.
   *  All levels must hace a name.
   *  
   * @param levelName name of the level
   * @param number number of bricks on the level
   * @param probability probability of soft brick 
   * @return ILevel
   * @author Bastián Inostroza
   */
  public ILevel newLevelWithSoftAndStoneBricks(final String levelName, final int number, final double probability) {
    final ILevel newLevel = new Level(levelName, number, probability);
    this.setCurrentLevel(newLevel);
    return newLevel;
  }

  
  public long numberOfBricks() {
    return currentLevel.numberOfBricks();
  }

  
  public List<IBrick> getBricks() {
    return currentLevel.getBricks();
  }
  
  
  public Boolean hasNextLevel() {
    return nextLevel;
  }

  
  public String getLevelName() {
    return currentLevel.getLevelName();
  }
  
  
  public int getRequiredPoints() {
    return currentLevel.getRequiredPoints();
  }
  
  
  public int getNumberOfHearts() {
    return currentPlayer.getNumberOfHearts();
  }
  
  
  public int lossOfHeart() {
    return currentPlayer.lossOfHeart();
  }
  
  
  public long earnedScore() {
    return currentPlayer.earnedScore();
  }
  

  public ILevel getCurrentLevel() {
    return this.currentLevel;
  }  
  
  
  public void setCurrentLevel(final ILevel newLevel) {
    currentLevel = newLevel;
  }
  

  public void setCurrentPlayer(final IPlayer newPlayer) {
    currentPlayer = newPlayer;
  }
  
  
  public String spawnBricks(final ILevel level) {
    return currentLevel.spawnBricks();
  }
  
  
}
