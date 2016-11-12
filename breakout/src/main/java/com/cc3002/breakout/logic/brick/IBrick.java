package com.cc3002.breakout.logic.brick;

import com.cc3002.breakout.logic.IPrinter;

/** Bricks interface that works with any AbstractBrick sub class,
 * bricks have to know what kind of brick are themselves and
 * how many hits them can resist.
 * 
 * @author Bastián Inostroza
 *
 */
public interface IBrick {

  boolean isSoftBrick();
  
  boolean isStoneBrick();

  char charChooser(IPrinter printer);
  
  int remainingHits();
  
  boolean hit();
  

}
