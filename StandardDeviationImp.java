package test;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The Function used to implements the standard deviation calculation.
 * In the first input, only F10 is available now.
 * This application also contains the input validation check (error handling), if its wrong, there
 * is a clear reminder to re-input.
 * @author Tongwei Zhang
 *    
 */
public class StandardDeviationImp {
  public static void main(String[] args) {
    functionAvail();
    implStandardDeviation();
  }
  
  /**
   * Primary function to implements the standard deviation.
   */
  public static int implStandardDeviation() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the Function you select(F1:arccos(x) to F10:¦Ò, only \"F10\" "
        + "available):");
    String getInput = sc.nextLine();
    if (getInput.equals("F10")) {
      System.out.print("Input the number of samples:");
      String sampleNumberStr = sc.nextLine();
      while (!isNumeric(sampleNumberStr)) {
        System.out.println("Please enter the positive integer number:");
        sampleNumberStr = sc.nextLine();
      }
      int sampleNumber = Integer.parseInt(sampleNumberStr);
      double[] sampleInfo = new double[sampleNumber];

      System.out.println("Enter the value of samples seperated by enter:");
      for (int i = 0; i < sampleNumber; i++) {
        String temp = sc.nextLine();
        while (!isDouble(temp)) {
          System.out.println("Please enter a vaild double(int) number:");
          temp = sc.nextLine();
        }
        sampleInfo[i] = Double.parseDouble(temp);
      }
      int temp = 0;
      for (double eachInt : sampleInfo) {
        temp += eachInt;
      }
      double average = temp / (sampleNumber - 1);
      double temp2 = 0;
      for (int i = 0; i < sampleNumber; i++) {
        temp2 += ((sampleInfo[i] - average) * (sampleInfo[i] - average));
      }
      double beforeRoot = temp2 / sampleNumber;
      double beforeGround = mathSqure(beforeRoot);
      System.out.print("Enter the number of decimals you want to keep(maximum 9):");
      String decimalDigital = sc.nextLine();
      while (!isNumeric(decimalDigital) || decimalDigital.equals("")) {
        System.out.println("Please enter a integer between [0,9]:");
        decimalDigital = sc.nextLine();
      }
      output(beforeGround, Integer.parseInt(decimalDigital));
      System.out.println("Whether starts another calculate?(Y/N)");
      String choice = sc.nextLine();
      while (!choice.equals("Y") && !choice.equals("N")) {
        System.out.println("Please the Y or N");
        choice = sc.nextLine();
      }
      if (choice.equals("Y")) {
        System.out.println("");
        functionAvail();
        implStandardDeviation();
      } else {
        System.exit(0);
      }
    } else {
      System.out.println("These functions has not integrated!!");
    }
    sc.close();
    return 1;
  }
  
  /**Judge if a string is double type number.
   * @param str
   * input value
   * @return boolean
   */
  public static boolean isDouble(String str) {
    Pattern pattern = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
    return pattern.matcher(str).matches() && (str.indexOf(" ") == -1);
  }
  
  /**
   * This function used to show the available functions in ETERNITY. 
   */
  public static int functionAvail() {
    System.out.println("ETERNITY: FUNCTIONS:");
    System.out.println("F1: arccos(x)   F2: tan(x)");
    System.out.println("F3: sinh(x)     F4: logb(x)");
    System.out.println("F5: ¦£(x)        F6: abx");
    System.out.println("F7: abx         F8: B(x, y)");
    System.out.println("F9: xy          F10: ¦Ò");
    System.out.println("Only F10(Standard Deviation) available for this part!!!");
    return 1;
  }
  
  /**
   * Judge if a string is numeric.
   * @param str String
   * @return boolean
   */
  public static boolean isNumeric(String str) {
    Pattern pattern = Pattern.compile("[0-9]*");
    return pattern.matcher(str).matches();
  }

  /**
   * Control the result format, that is the number of decimal kept.
   * @param b double
   * @param i int
   */
  public static int output(double b, int i) {
    switch (i) {
      case 0:
        System.out.println((int) b);
        break;
      case 1:
        System.out.println(String.format("%.1f", b));
        break;
      case 2:
        System.out.println(String.format("%.2f", b));
        break;
      case 3:
        System.out.println(String.format("%.3f", b));
        break;
      case 4:
        System.out.println(String.format("%.4f", b));
        break;
      case 5:
        System.out.println(String.format("%.5f", b));
        break;
      case 6:
        System.out.println(String.format("%.6f", b));
        break;
      case 7:
        System.out.println(String.format("%.7f", b));
        break;
      case 8:
        System.out.println(String.format("%.8f", b));
        break;
      case 9:
        System.out.println(String.format("%.9f", b));
        break;
      default:
        System.out.println(String.format("%.2f", b));
        break;
    }
    return 1;
  }

  /**
   * Implement the square function using Newton iteration method.
   * @param c double
   * @return double
   * 
   */
  public static double mathSqure(double c) {
    if (c < 0) {
      return Double.NaN;
    }
    double err = 1e-7;
    double x = c;
    while (Math.abs(x - c / x) > err) {
      x = (x + c / x) / 2.0;
    }
    return x;
  }
}
