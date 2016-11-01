package com.cc3002.breakout.logic;

import java.util.List;

/** Printer interface that receives a brick of IBrick list
 * and shows it on a visualization form independent  of the other
 * printers. 
 * 
 * @author Bastián Inostroza
 *
 */
public interface IPrinter {
  
  String spawnBricks( List<IBrick> list);

  char printSoftBrick();

  char printStoneBrick();

}
