package com.cc3002.breakout.logic.level;

import java.util.List;

import com.cc3002.breakout.logic.brick.IBrick;

/** ILevel interface determines the basic methods for any level
 * in the game.
 * 
 * @author Bastián Inostroza
 *
 */
public interface ILevel {

  String getLevelName();

  int getRequiredPoints();

  int numberOfBricks();
  
  List<IBrick> getBricks();

  String spawnBricks();
}
