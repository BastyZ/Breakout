package com.cc3002.breakout.logic.brick;

import com.cc3002.breakout.logic.IPrinter;

/** IBrick instance subclass by specialization, each one
 * of these knows what kind of brick it is and how many hits
 * can resist. 
 * 
 * @author Bastián Inostroza
 * @see AbstractBrick
 * @see StoneBrick
 */
public class SoftBrick extends AbstractBrick {
  
  public SoftBrick() {
    super( 1 );
  }
  
  
  public boolean isSoftBrick() {
    return true;
  }

  
  public boolean isStoneBrick() {
    return false;
  }

  
  @Override
  public char charChooser(final IPrinter printer) {
    return printer.printSoftBrick();
  }

  
}
