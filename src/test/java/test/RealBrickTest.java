package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cc3002.breakout.logic.IBrick;
import com.cc3002.breakout.logic.SoftBrick;
import com.cc3002.breakout.logic.StoneBrick;

public class RealBrickTest {

  @Test
  public void stoneBrickRemainigPointsTest() {
    final IBrick aBrick = new StoneBrick();
    assertEquals("Expect 3 remaining hits", 3, aBrick.remainingHits());
  }
  
  @Test
  public void softBrickRemainigPointsTest() {
    final IBrick aBrick = new SoftBrick();
    assertEquals("Expect 3 remaining hits", 1, aBrick.remainingHits());
  }
  
  @Test
  public void stoneBrickHitTest() {
    final IBrick aBrick = new StoneBrick();
    assertFalse("Expect false", aBrick.hit());
  }

  @Test
  public void softBrickHitTest() {
    final IBrick aBrick = new SoftBrick();
    assertTrue("Expect true", aBrick.hit());
  }
  
}
