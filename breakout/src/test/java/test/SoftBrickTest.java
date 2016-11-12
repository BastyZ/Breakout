package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cc3002.breakout.logic.brick.IBrick;
import com.cc3002.breakout.logic.brick.SoftBrick;

public class SoftBrickTest {

  @Test
  public void softTest() {
    final IBrick aBrick = new SoftBrick();
    assertTrue( "is soft test", aBrick.isSoftBrick());
  }
  
  @Test
  public void stoneTest() {
    final IBrick aBrick = new SoftBrick();
    assertFalse("in't stone test", aBrick.isStoneBrick());
  }

}
