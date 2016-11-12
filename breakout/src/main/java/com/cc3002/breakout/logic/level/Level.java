package com.cc3002.breakout.logic.level;

import java.util.ArrayList;
import java.util.List;

import com.cc3002.breakout.logic.IPrinter;
import com.cc3002.breakout.logic.Printer;
import com.cc3002.breakout.logic.brick.IBrick;
import com.cc3002.breakout.logic.brick.SoftBrick;
import com.cc3002.breakout.logic.brick.StoneBrick;

/** Basic tipo of level, each instance have his own name,
 * number of bricks, and a probability of having soft bricks.
 * 
 * <P> Level possess an arrayList of IBricks that a player
 * will try to break in order to gains score. </p>
 * 
 * @author Bastián Inostroza
 * @see IBrick
 *
 */
public class Level implements ILevel {
  
  private final String levelName;
  private final int requiredPoints;
  private final transient List<IBrick> brickList;
  
  /** Level constructor, with a positive numbre of bricks and a probability
   * of soft brick between 0 and 1.
   * 
   * @param name Name of the level
   * @param num NUkber of bricks in the level
   * @param probabilityOfSoftBrick probability of apperearance of a softBrick
   */
  public Level(final String name, final int num, final double probabilityOfSoftBrick) {
    this.levelName = name;
    this.brickList = setBrickList( num, probabilityOfSoftBrick);
    this.requiredPoints = setRequiredPoints(brickList);
  }
  

  private int setRequiredPoints(final List<IBrick> list) {
    int points = 0;
    for ( int i = 0; i < list.size(); i++) {
      points += list.get(i).isStoneBrick() ? 50 : 10 ;
    }
    return  (int) (points * 0.7);
  }
  
  
  private List<IBrick> setBrickList(final int num, final double probabilityOfSoftBrick) {
    final List<IBrick> newBrickList = new ArrayList<IBrick>();
    final double probability = probabilityOfSoftBrick;
    for (int i = 0; i < num ; i ++ ) {
      if ( Math.random() <= probability ) {
        newBrickList.add( i, new SoftBrick() );
      } else {
        newBrickList.add(i, new StoneBrick() );
      }
    }
    return newBrickList;
  }
  

  public int numberOfBricks() {
    return brickList.size();
  }
  

  public String getLevelName() {
    return this.levelName;
  }
  

  public int getRequiredPoints() {
    return this.requiredPoints;
  }
  

  public List<IBrick> getBricks() {
    return this.brickList;
  }
  

  public String spawnBricks() {
    final IPrinter aPrinter = new Printer();   
    return aPrinter.spawnBricks( brickList );
  }
  

}
