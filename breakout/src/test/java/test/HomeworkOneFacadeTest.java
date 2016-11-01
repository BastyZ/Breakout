package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cc3002.breakout.facade.HomeworkOneFacade;
import com.cc3002.breakout.logic.*;


public class HomeworkOneFacadeTest {

  @Test
  public void test() {
    final HomeworkOneFacade facade = new HomeworkOneFacade();
    facade.setCurrentLevel( facade.newLevelWithSoftAndStoneBricks( "levelName1", 10 , 0.5) );
    assertEquals( "comparing number of bricks.", 10, facade.numberOfBricks() );
    assertEquals( "comparing names.", "levelName1", facade.getLevelName() );
    assertFalse("tiene sgte nivel.", facade.hasNextLevel() );
  }
  
  @Test
  public void getBrickTest() {
    final HomeworkOneFacade facade = new HomeworkOneFacade();
    facade.setCurrentLevel( facade.newLevelWithSoftAndStoneBricks( "levelName2", 10 , 1) );
    assertTrue( "correct brick soft list test.", softBricksListComparer( facade.getBricks() ) );
    facade.setCurrentLevel( facade.newLevelWithSoftAndStoneBricks( "Level Name", 10 , 0) );
    assertFalse( "correct brick stone list test.", softBricksListComparer( facade.getBricks() ) );
  }
  
  @Test
  public void currentLevelTest() {
    final HomeworkOneFacade facade = new HomeworkOneFacade();
    final ILevel newLevel = facade.newLevelWithSoftAndStoneBricks("levelName3", 80, 0.8);
    facade.setCurrentLevel(newLevel);
    assertEquals("We should obtain the same object.", newLevel, facade.getCurrentLevel() );
  }
  
  
  @Test
  public void currentVoidLevelTest() {
    final HomeworkOneFacade facade = new HomeworkOneFacade();
    assertNull("We should obtain the same object.", facade.getCurrentLevel());
  }
    
  
  @Test
  public void getCurrentLevelTest() {
    final HomeworkOneFacade facade = new HomeworkOneFacade();
    assertNull( "Initial level is not defined.", facade.getCurrentLevel() );
    facade.setCurrentLevel( facade.newLevelWithSoftAndStoneBricks( "levelName4", 10 , 1) );
    final ILevel level = facade.getCurrentLevel();
    assertEquals( "proper name.", level.getLevelName(), facade.getLevelName() );
    assertEquals( "equal required points.", level.getRequiredPoints(), facade.getRequiredPoints() );
    assertTrue( "equal brick list.", bricksComparer( level.getBricks(), facade.getBricks() ) );
    final HomeworkOneFacade secondFacade = new HomeworkOneFacade();
    secondFacade.setCurrentLevel( secondFacade.newLevelWithSoftAndStoneBricks( "levelName4", 10 , 0) );
    assertFalse( "different brick list.", bricksComparer( level.getBricks(), secondFacade.getBricks() ) );
  }
  
  @Test
  public void getNullLevelTest() {
    final HomeworkOneFacade facade = new HomeworkOneFacade();
    assertNull("Initial level is not defined.", facade.getCurrentLevel() );
  }
  
  @Test
  public void playerTest() {
    final HomeworkOneFacade facade = new HomeworkOneFacade();
    facade.setCurrentPlayer( new Player() );
    assertEquals( "number of hearts.", 3, facade.getNumberOfHearts() );
    assertEquals( "score points.", 0, facade.earnedScore() );
    assertEquals( "loss of one heart.", 2, facade.lossOfHeart() );
  }
  
  
  @Test
  public void printerSoftTest() {
    final HomeworkOneFacade facade = new HomeworkOneFacade();
    facade.setCurrentLevel( facade.newLevelWithSoftAndStoneBricks( "levelName5", 20 , 1) );
    assertEquals( "verifies equal strings.", "****************" + System.lineSeparator() + "****" + System.lineSeparator() , facade.spawnBricks( facade.getCurrentLevel() ) );
  }
  
  
  @Test
  public void printerStoneTest() {
    final HomeworkOneFacade facade = new HomeworkOneFacade();
    facade.setCurrentLevel( facade.newLevelWithSoftAndStoneBricks( "levelName6", 10 , 0) );
    assertEquals( "verifies equal strings.", "##########" + System.lineSeparator() , facade.spawnBricks( facade.getCurrentLevel() ) );
  }
  
  
  private boolean bricksComparer(final List<IBrick> list1, final List<IBrick> list2) {
    boolean bool = true;
    int position;
    for( position = 0; position < list2.size(); position++){
      if( list1.get(position).isSoftBrick() && list2.get(position).isSoftBrick() ) {
        continue;
      } else { 
        bool = false; 
      }
    }
    return bool;
  }

  private boolean softBricksListComparer( final List<IBrick> list) {
    boolean bool = true;
    int position;
    for( position = 0; position < list.size(); position++) {
      if( list.get(position).isSoftBrick() ) {
        continue;
      } else { 
        bool = false; 
      }
    }
    return bool;
  }

}
