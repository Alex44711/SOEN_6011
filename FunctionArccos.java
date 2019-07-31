package soen6011;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * the program to implement the Arccos function
 * 
 * @author Prabhpreet Singh
 * 
 *
 */
public class FunctionArccos {
	private JFrame frame;

	/**
	 * This method converts a String input into double and checks the value for
	 * boundaries before implementing its Arccos.
	 * 
	 * @param input the String input given by the user
	 * @return the String result of implementation of input
	 */
	public String getInput(String input) {
		try {
			double number = Double.parseDouble(input);
			if (number < -1 || number > 1) {
				return "Please Enter Number in the range of -1 to 1";
			} else {
				double answer = mainArccosFunction(number);
				return answer + " rad";
			}
		} catch (Exception ex1) {
			return "Invalid Input. Please Enter Number in the range of -1 to 1";
		}
	}

	/**
	 * The function takes double input as argument and pass the value to implement
	 * its Arccos
	 * 
	 * @param number the number entered by user
	 * @return the implemented arccos of the input number
	 */
	public double mainArccosFunction(double number) {
		double answer = 0;
		counter = 3;
		answer = (3.14159265359 / 2) - number;
		answer = answer - arccosRecursive(number);
		return answer;
	}

	private JTextField inputField;
	int counter;

	/**
	 * the recursive approach to implement the arccos function by using taylor
	 * series of expansion
	 * 
	 * @param number the number entered by the user whose arccos is to be calculated
	 * @return the part of the formula to be calculated
	 */
	double arccosRecursive(double number) {
		double oddproduct = 1;
		double evenproduct = 1;
		double numproduct = 1;
		double sum = 0;
		for (int i = 1; i < counter; i = i + 2) {
			oddproduct = oddproduct * i; // for calculating odd factorial
		}
		for (int i = 2; i < counter; i = i + 2) {
			evenproduct = evenproduct * i; // for calculating even factorial
		}
		for (int i = 0; i < counter; i++) {
			numproduct = numproduct * number; // for calculating power of x in the formula
		}
		sum = (oddproduct * numproduct) / (evenproduct * counter);
		counter = counter + 2;
		if (counter <= 301) {
			sum = sum + arccosRecursive(number);
			return sum;
		} else {
			return sum;
		}
	}

	/**
	 * main function of the class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FunctionArccos window = new FunctionArccos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FunctionArccos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(new Dimension(580, 350));
		frame.setLocationRelativeTo(null);
		// frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblArccosFunction = new JLabel("Arccos Function");
		lblArccosFunction.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblArccosFunction.setHorizontalAlignment(SwingConstants.CENTER);
		lblArccosFunction.setBounds(187, 23, 149, 31);
		frame.getContentPane().add(lblArccosFunction);
		JLabel lblEnterNumberFrom = new JLabel("Enter a number  from -1 to 1");
		lblEnterNumberFrom.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEnterNumberFrom.setBounds(10, 82, 244, 31);
		frame.getContentPane().add(lblEnterNumberFrom);
		inputField = new JTextField();
		inputField.setBackground(Color.WHITE);
		inputField.setForeground(Color.BLACK);
		inputField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		inputField.setBounds(264, 83, 210, 28);
		JLabel resultField = new JLabel("");
		resultField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		resultField.setBounds(164, 213, 390, 29);
		frame.getContentPane().add(resultField);
		frame.getContentPane().add(inputField);
		inputField.setColumns(10);
		JButton btnFindArccos = new JButton("Find Arccos");
		btnFindArccos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnFindArccos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input = inputField.getText();
				String output = getInput(input);
				resultField.setText(output);
			}
		});
		btnFindArccos.setBounds(47, 141, 136, 38);
		frame.getContentPane().add(btnFindArccos);
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblResult.setBounds(76, 213, 107, 31);
		frame.getContentPane().add(lblResult);
		JButton Refresh = new JButton("Refresh");
		Refresh.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(""); // clear the input field
				resultField.setText(""); // clear the output field
			}
		});
		Refresh.setBounds(299, 141, 138, 38);
		frame.getContentPane().add(Refresh);

	}
}
