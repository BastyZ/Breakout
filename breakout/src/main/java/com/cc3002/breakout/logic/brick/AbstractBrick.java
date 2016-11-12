package com.cc3002.breakout.logic.brick;

import com.cc3002.breakout.logic.IPrinter;

/** 
 * Abstract class of any bricks. Keeps count of remainig hits for all the instances
 * of IBrick type.
 * 
 * <p> Constructor automatically setted by sub classes, new sub clases should have
 *  the proper super() statement. </p> 
 * @author Bastián Inostroza
 *
 */
public abstract class AbstractBrick implements IBrick {
  
  transient private int hitsLeft;
  
  
  protected AbstractBrick(final int setHits) {
    this.hitsLeft = setHits;
  }

  public abstract boolean isSoftBrick();
  
  public abstract boolean isStoneBrick();
  
  public abstract char charChooser(final IPrinter printer);
  
  public int remainingHits() {
    return this.hitsLeft;
  }
  
  public boolean hit() {
    this.hitsLeft -= 1;
    return this.hitsLeft == 0 ? true : false;
  }

}
