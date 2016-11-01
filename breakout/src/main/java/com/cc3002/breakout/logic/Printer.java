package com.cc3002.breakout.logic;

import java.util.List;

/** Very poor ASCII art like printer, that spawns brick 
 * of an ILevel instance (List of type IBrick of a Ilevel object) as an array
 * with row of 16 bricks.
 * 
 * @author Bastián Inostroza
 * @see ILevel
 * @see IBrick
 */
public class Printer implements IPrinter {
  private static char softBrick = '*';
  private static char stoneBrick = '#';
  

  public String spawnBricks(final List<IBrick> list ) {
    final StringBuilder aStringBuilder = new StringBuilder();
    int position;
    aStringBuilder.append( list.get(0).charChooser(this) );
    for ( position = 1; position < list.size(); position++ ) {
      final String value =  position % 16 == 0 ? System.lineSeparator() : "" ; 
      aStringBuilder.append( value ); 
      aStringBuilder.append( list.get(position).charChooser(this) );
    }
    return aStringBuilder.append( System.lineSeparator() ).toString();
  }


  public char printSoftBrick() {
    return softBrick;
  }


  public char printStoneBrick() {
    return stoneBrick;
  }

  
}
