package com.cc3002.breakout.logic.brick;

import com.cc3002.breakout.logic.IPrinter;

/** IBrick instance subclass by specialization, each one
 * of these knows what kind of brick it is and how many hits
 * can resist. 
 * 
 * @author Bastián Inostroza
 * @see AbstractBrick
 * @see SoftBrick
 */
public class StoneBrick extends AbstractBrick {
  
  
  public StoneBrick() {
    super(3);
  }


  public boolean isSoftBrick() {
    return false;
  }

  
  public boolean isStoneBrick() {
    return true;
  }

  
  @Override
  public char charChooser(final IPrinter printer) {
    return printer.printStoneBrick();
  }
  
}
