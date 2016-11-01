package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cc3002.breakout.logic.IPlayer;
import com.cc3002.breakout.logic.Player;

public class PlayerTest {

  @Test
  public void heartsTest() {
    final IPlayer aPlayer = new Player();
    assertEquals( "number of hearts", 3, aPlayer.getNumberOfHearts() );
    }
  
  @Test
  public void scoreTest() {
    final IPlayer aPlayer = new Player();
    assertEquals( "score points", 0, aPlayer.earnedScore());
  }
  
  @Test
  public void lossOfHeartsTest() {
    final IPlayer aPlayer = new Player();
    assertEquals( "loss of one heart", 2, aPlayer.lossOfHeart() );
  }
  
}
