package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class StandardDeviationImpTest {

  @Test
  public void isDoubleTest() {
    assertEquals(true,StandardDeviationImp.isDouble("123.4456"));
    assertEquals(false,StandardDeviationImp.isDouble("123 456"));
  }
  
  @Test
  public void isNumericTest() {
    assertEquals(true,StandardDeviationImp.isNumeric("12346"));
    assertEquals(false,StandardDeviationImp.isNumeric("123a46"));
  }
  
  @Test
  public void mathSqureTest() {
    assertEquals(2,StandardDeviationImp.mathSqure(4),0.1);
    assertEquals(4.2,StandardDeviationImp.mathSqure(17.46),0.1);
  }
  
  @Test
  public void implStandardDeviationTest() {
    assertEquals(1,StandardDeviationImp.implStandardDeviation());
  }
  
  @Test
  public void outputTest() {
    assertEquals(1,StandardDeviationImp.output(12.3,1));
  }
  
  @Test
  public void functionAvailTest() {
    assertEquals(1,StandardDeviationImp.functionAvail());
  }
}
