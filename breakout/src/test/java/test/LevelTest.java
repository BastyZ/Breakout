package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cc3002.breakout.logic.*;
import com.cc3002.breakout.logic.brick.IBrick;
import com.cc3002.breakout.logic.brick.SoftBrick;
import com.cc3002.breakout.logic.brick.StoneBrick;
import com.cc3002.breakout.logic.level.Level;

public class LevelTest {
  
  @Test
  public void numberTest() {
    final Level aLevel = new Level( "Level2" , 10, 1 );
    assertEquals( "number of bricks fail" , 10, aLevel.numberOfBricks() );
  }
    
  @Test
  public void nameTest() {
    final Level aLevel = new Level( "Level1" , 10, 1 );  
    assertEquals( "level name fail" , "Level1",  aLevel.getLevelName() );
  }
  
  @Test
  public void pointsSoftTest() {
    final Level aLevel = new Level( "Level1" , 10, 1 );
    assertEquals("required points test with Sotf bricks" ,(int) (10*10*0.7), aLevel.getRequiredPoints() );
  }
  
    @Test
    public void pointsStoneTest() {
    final Level aLevel2 = new Level( "Level2" , 10, 0 );
    assertEquals("required points test with Stone bricks" ,(int) (10*50*0.7), aLevel2.getRequiredPoints() );
  }
  
  @Test
  public void listTest1() {
    final List<IBrick> anotherListOfBricks = setListOfBricks(0, 2);
    final Level aLevel = new Level( "Level3" , 2 , 1 );
    assertFalse( "get bricks fail with Stone" , bricksComparer( anotherListOfBricks , aLevel.getBricks() ) );
  }
  
  @Test
  public void listTest2() {
    final List<IBrick> anotherListOfBricks = setListOfBricks(0, 2);
    final Level aLevel = new Level( "Level4" , 2 , 1 );
    assertFalse( "get bricks fail with Stone" , bricksComparer( anotherListOfBricks , aLevel.getBricks() ) );
  }
  
  @Test
  public void listTest3() {
    final List<IBrick> listOfBricks = setListOfBricks(1, 2);
    final List<IBrick> anotherListOfBricks = setListOfBricks(0, 2);
    assertFalse( "get bricks fail with differen bricks" , bricksComparer( anotherListOfBricks , listOfBricks ) );
  }
  
  @Test
  public void listTest4() {
    final List<IBrick> listOfBricks = setListOfBricks(1, 2);
    final List<IBrick> anotherListOfBricks = setListOfBricks(1, 2);
    assertTrue( "get bricks fail with differen bricks" , bricksComparer( anotherListOfBricks , listOfBricks ) );
  }

  private boolean bricksComparer(final List<IBrick> listOfBricks, final List<IBrick> bricks) {
    int position;
    for( position = 0; position < bricks.size(); position++){
      if( listOfBricks.get(position).isSoftBrick() && bricks.get(position).isSoftBrick() ) {
        continue;
      } else { 
        return falso(); 
      }
    }
    return true;
  }
  
  private boolean falso(){
    return false;
  }

  private List<IBrick> setListOfBricks(final double probability, final int large) {
    final List<IBrick> newBrickList = new ArrayList<IBrick>();
    for(int i = 0; i < large ; i ++ ) {
      if( Math.random() <= probability ){
        newBrickList.add( i, new SoftBrick() );
      } else {
        newBrickList.add(i, new StoneBrick() );
      }
    }
    return newBrickList;
  }

  
}
