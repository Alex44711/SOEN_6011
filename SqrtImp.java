package test;

import java.util.Scanner;

public class SqrtImp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Function you select:");
		String getInput = sc.nextLine();
		if(getInput.equals("F10")) {
			System.out.print("Input the values seperate by enter:");
			int sampleNumber = Integer.parseInt(sc.next());
			double[] sampleInfo = new double[sampleNumber];
			for(int i=0; i<sampleNumber; i++) {
				sampleInfo[i] = Integer.parseInt(sc.next());
			}
			int temp = 0;
			for(double eachInt:sampleInfo) {
				temp+=eachInt;
			}
			double average = temp/sampleNumber;
			double temp2 = 0;
			for(int i=0; i<sampleNumber; i++) {
				temp2+=((sampleInfo[i]-average)*(sampleInfo[i]-average));  
			}
			double beforeRoot = temp2/sampleNumber;
			double beforeGround = MathSqure(beforeRoot);
			System.out.print("Input the decimal digit numbers(maximum 9):");
			int decimalDigital = Integer.parseInt(sc.next());
			output(beforeGround,decimalDigital);
		}else {
			System.out.println("These functions has not integrated!!");
		}
	}
	
	public static void output(double b, int i) {
		switch(i) {
			case 0:
				System.out.println((int)b);
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
	}
	
	public static double MathSqure(double c) {
		if(c < 0) return Double.NaN;
		double err = 1e-7;
		double x = c; 
		while(Math.abs(x - c/x) > err){
			x = (x + c/x) / 2.0;
		}
		return x;
	}
}
