package soen6011;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * The program to perform unit testing of implementation of Arccos function.
 * 
 * @author Prabhpreet Singh
 *
 */
class ArccosFunctionTest {
	@Test
	void test_AcosOne() {
		FunctionArccos test = new FunctionArccos();
		String result = test.getInput("1");
		assertEquals("0.046078621796800334 rad", result);
	}

	@Test
	void test_AcosMinusOne() {
		FunctionArccos test = new FunctionArccos();
		String result = test.getInput("-1");
		assertEquals("3.0955140317931997 rad", result);
	}

	@Test
	void test_AcosZero() {
		FunctionArccos test = new FunctionArccos();
		String result = test.getInput("0");
		assertEquals("1.570796326795 rad", result);
	}

	@Test
	void test_AcosHalf() {
		FunctionArccos test = new FunctionArccos();
		String result = test.getInput("0.5");
		assertEquals("1.047197551196701 rad", result);
	}

	@Test
	void test_AcosMinusHalf() {
		FunctionArccos test = new FunctionArccos();
		String result = test.getInput("-0.5");
		assertEquals("2.0943951023932987 rad", result);
	}

	@Test
	void test_AcosOneByRootTwo() {
		FunctionArccos test = new FunctionArccos();
		String result = test.getInput("0.707");
		assertEquals("0.785549163399847 rad", result);
	}

	@Test
	void test_AcosThree() {
		FunctionArccos test = new FunctionArccos();
		String result = test.getInput("3");
		assertEquals("Please Enter Number in the range of -1 to 1", result);
	}

	@Test
	void test_AcosBlank() {
		FunctionArccos test = new FunctionArccos();
		String result = test.getInput("");
		assertEquals("Invalid Input. Please Enter Number in the range of -1 to 1", result);
	}

	@Test
	void test_AcosString() {
		FunctionArccos test = new FunctionArccos();
		String result = test.getInput("sdvsdv");
		assertEquals("Invalid Input. Please Enter Number in the range of -1 to 1", result);
	}

	@Test
	void test_SpecialCharacters() {
		FunctionArccos test = new FunctionArccos();
		String result = test.getInput("?#$^");
		assertEquals("Invalid Input. Please Enter Number in the range of -1 to 1", result);
	}

	@Test
	void test_AcosDoubleOne() {
		FunctionArccos test = new FunctionArccos();
		double result = test.mainArccosFunction(1);
		assertEquals(0.046078621796800334, result);
	}

	@Test
	void test_AcosdoubleOneByRootTwo() {
		FunctionArccos test = new FunctionArccos();
		double result = test.mainArccosFunction(1 / 1.414);
		assertEquals(0.7852471177794784, result);
	}

	@Test
	void test_AcosDoubleNumber() {
		FunctionArccos test = new FunctionArccos();
		double result = test.mainArccosFunction(0.1242342423423432243221);
		assertEquals(1.4462402693541714, result);
	}
}
