package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cc3002.breakout.facade.HomeworkTwoFacade;
import com.cc3002.breakout.logic.Player;
import com.cc3002.breakout.logic.brick.IBrick;
import com.cc3002.breakout.logic.level.ILevel;

public class HomeworkTwoFacadeTest {

  @Test
  public void test() {
    final HomeworkTwoFacade facade2 = new HomeworkTwoFacade();
    facade2.setCurrentLevel( facade2.newLevelWithSoftAndStoneBricks( "levelName1", 10 , 0.5) );
    assertEquals( "comparing number of bricks.", 10, facade2.numberOfBricks() );
    assertEquals( "comparing names.", "levelName1", facade2.getLevelName() );
    assertFalse("tiene sgte nivel.", facade2.hasNextLevel() );
  }
  
  @Test
  public void getBrickTest() {
    final HomeworkTwoFacade facade = new HomeworkTwoFacade();
    facade.setCurrentLevel( facade.newLevelWithSoftAndStoneBricks( "levelName2", 10 , 1) );
    assertTrue( "correct brick soft list test.", softBricksListComparer( facade.getBricks() ) );
    facade.setCurrentLevel( facade.newLevelWithSoftAndStoneBricks( "Level Name", 10 , 0) );
    assertFalse( "correct brick stone list test.", softBricksListComparer( facade.getBricks() ) );
  }
  
  @Test
  public void currentLevelTest() {
    final HomeworkTwoFacade facade = new HomeworkTwoFacade();
    final ILevel newLevel = facade.newLevelWithSoftAndStoneBricks("levelName3", 80, 0.8);
    facade.setCurrentLevel(newLevel);
    assertEquals("We should obtain the same object.", newLevel, facade.getCurrentLevel() );
  }
  
  
  @Test
  public void currentVoidLevelTest() {
    final HomeworkTwoFacade facade = new HomeworkTwoFacade();
    assertNull("We should obtain the same object.", facade.getCurrentLevel());
  }
    
  
  @Test
  public void getCurrentLevelTest() {
    final HomeworkTwoFacade facade = new HomeworkTwoFacade();
    assertNull( "Initial level is not defined.", facade.getCurrentLevel() );
    facade.setCurrentLevel( facade.newLevelWithSoftAndStoneBricks( "levelName4", 10 , 1) );
    final ILevel level = facade.getCurrentLevel();
    assertEquals( "proper name.", level.getLevelName(), facade.getLevelName() );
    assertEquals( "equal required points.", level.getRequiredPoints(), facade.getRequiredPoints() );
    assertTrue( "equal brick list.", bricksComparer( level.getBricks(), facade.getBricks() ) );
    final HomeworkTwoFacade secondFacade = new HomeworkTwoFacade();
    secondFacade.setCurrentLevel( secondFacade.newLevelWithSoftAndStoneBricks( "levelName4", 10 , 0) );
    assertFalse( "different brick list.", bricksComparer( level.getBricks(), secondFacade.getBricks() ) );
  }
  
  @Test
  public void getNullLevelTest() {
    final HomeworkTwoFacade facade = new HomeworkTwoFacade();
    assertNull("Initial level is not defined.", facade.getCurrentLevel() );
  }
  
  @Test
  public void playerTest() {
    final HomeworkTwoFacade facade = new HomeworkTwoFacade();
    facade.setCurrentPlayer( new Player() );
    assertEquals( "number of hearts.", 3, facade.getNumberOfHearts() );
    assertEquals( "score points.", 0, facade.earnedScore() );
    assertEquals( "loss of one heart.", 2, facade.lossOfHeart() );
  }
  
  
  @Test
  public void printerSoftTest() {
    final HomeworkTwoFacade facade = new HomeworkTwoFacade();
    facade.setCurrentLevel( facade.newLevelWithSoftAndStoneBricks( "levelName5", 20 , 1) );
    assertEquals( "verifies equal strings.", "****************" + System.lineSeparator() + "****" + System.lineSeparator() , facade.spawnBricks( facade.getCurrentLevel() ) );
  }
  
  
  @Test
  public void printerStoneTest() {
    final HomeworkTwoFacade facade = new HomeworkTwoFacade();
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
