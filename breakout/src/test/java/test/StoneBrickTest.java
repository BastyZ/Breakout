package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cc3002.breakout.logic.IBrick;
import com.cc3002.breakout.logic.StoneBrick;

public class StoneBrickTest {

  @Test
  public void stoneTest() {
    final IBrick aBrick = new StoneBrick();
    assertTrue( "is stone test", aBrick.isStoneBrick());
  }
  
  @Test
  public void softTest() {
    final IBrick aBrick = new StoneBrick();
    assertFalse( "isn't soft test", aBrick.isSoftBrick());
  }

}
