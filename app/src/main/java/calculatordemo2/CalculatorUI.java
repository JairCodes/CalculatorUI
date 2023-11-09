package calculatordemo2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * CalculatorUI class that creates and adds buttons, event handling for the buttons, and calls calculator
 * methods and functions for logic when necessary
 * @author Soria, Steckler, Tesic, Metsis
 */

public class CalculatorUI implements ActionListener {
	private final JFrame frame;
	private final JPanel panel;
	private final JTextArea text;
	private final JButton jButtons[], add, sub, mult, div, equal, cancel, sqrRt, sqr, inverse, cos, sin, tan,ATan,ASin,ACos;
	private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private final Calculator calc;


	
	/**
	 * The main top level GUI of the calculator and it's frame, button, and text area for # display
	 */
	public CalculatorUI() {
		frame = new JFrame("Calculator");
		frame.setResizable(true);
		panel = new JPanel(new FlowLayout());
		text = new JTextArea(2, 25);//text box
		jButtons = new JButton[10];
		
		panel.setBackground(Color.darkGray.darker());

		for (int i = 0; i < 10; i++) {
			jButtons[i] = new JButton(String.valueOf(i));
			jButtons[i].setPreferredSize(new Dimension(300/5,25));
			// jButtons[i].setBackground(new Color(242,170,187));
			jButtons[i].setBackground(Color.pink);
            // jButtons[i].setForeground(new Color(198,117,122));
			jButtons[i].setForeground(Color.black);
		}
		jButtons[0].setPreferredSize(new Dimension(150,25));

		add = new JButton("+");
		// add.setPreferredSize(new Dimension(50,25));
		add.setForeground(Color.pink);
		add.setBackground(Color.black);
		sub = new JButton("-");
		sub.setForeground(Color.pink);
		sub.setBackground(Color.black);
		mult = new JButton("*");
		mult.setForeground(Color.pink);
		mult.setBackground(Color.black);
		div = new JButton("/");
		div.setForeground(Color.pink);
		div.setBackground(Color.black);
		equal = new JButton("=");
		equal.setForeground(Color.pink);
		equal.setBackground(Color.black);
		sqrRt = new JButton("√");
		sqrRt.setForeground(Color.pink);
		sqrRt.setBackground(Color.black);
		sqr = new JButton("x*x");
		sqr.setForeground(Color.pink);
		sqr.setBackground(Color.black);
		inverse = new JButton("1/x");
		inverse.setForeground(Color.pink);
		inverse.setBackground(Color.black);
		cos = new JButton("Cos");
		cos.setForeground(Color.pink);
		cos.setBackground(Color.black);
		sin = new JButton("Sin");
		sin.setForeground(Color.pink);
		sin.setBackground(Color.black);
		tan = new JButton("Tan");
		tan.setForeground(Color.pink);
		tan.setBackground(Color.black);
		ATan = new JButton("ATan");
		ATan.setForeground(Color.pink);
		ATan.setBackground(Color.black);
		ASin = new JButton("ASin");
		ASin.setForeground(Color.pink);
		ASin.setBackground(Color.black);
		ACos = new JButton("ACos");
		ACos.setForeground(Color.pink);
		ACos.setBackground(Color.black);
		cancel = new JButton("C");
		cancel.setForeground(Color.magenta);
		cancel.setBackground(Color.white);
		
		calc = new Calculator();
	}

	/**
	 * Initializes and sets the frame size, buttons, panels. The main runner method of the UI class.
	 */
	public void init() {
		frame.setSize(300, 340);//eidth and height of the box
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.add(panel);

		panel.add(text);
		// for (int i = 9; i >= 0; i--) {
		// 	panel.add(jButtons[i]);
		// 	jButtons[i].addActionListener(this);
		// }
		
		// add operand buttons
		

		
		panel.add(add);
		panel.add(sub);
		panel.add(mult);
		panel.add(div);
		panel.add(sqr);
		panel.add(sqrRt);
		panel.add(inverse);
		panel.add(cos);
		panel.add(sin);
		panel.add(tan);
		panel.add(ATan);
		panel.add(ASin);
		panel.add(ACos);
		panel.add(equal);
		panel.add(cancel);
		// add event listeners
		add.addActionListener(this);
		sub.addActionListener(this);
		mult.addActionListener(this);
		div.addActionListener(this);
		sqr.addActionListener(this);
		sqrRt.addActionListener(this);
		inverse.addActionListener(this);
		cos.addActionListener(this);
		sin.addActionListener(this);
		tan.addActionListener(this);
		ATan.addActionListener(this);
		ASin.addActionListener(this);
		ACos.addActionListener(this);
		equal.addActionListener(this);
		cancel.addActionListener(this);

		for (int i = 9; i >= 0; i--) {
			panel.add(jButtons[i]);
			jButtons[i].addActionListener(this);
		}

		frame.setVisible(true);
	}

	/**
	 * Event handling implementation for Calculator button pressing
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		final Object source = e.getSource();
		// check 0-9 and update textfield
		for (int i = 0; i < 10; i++) {
			if (source == jButtons[i]) {
				text.replaceSelection(buttonValue[i]);
				return;
			}
		}
		if (source == add) {
			writer(calc.twoOpCaller(Calculator.twoOperator.add, reader()));
		}
		if (source == sub) {
			writer(calc.twoOpCaller(Calculator.twoOperator.subtract, reader()));
		}
		if (source == mult) {
			writer(calc.twoOpCaller(Calculator.twoOperator.multiply,
					reader()));
		}
		if (source == div) {
			writer(calc.twoOpCaller(Calculator.twoOperator.divide, reader()));
		}
		if (source == sqr) {
			writer(calc.calcScience(Calculator.singleOperator.square,
					reader()));
		}
		if (source == sqrRt) {
			writer(calc.calcScience(Calculator.singleOperator.squareRoot,
					reader()));
		}
		if (source == inverse) {
			writer(calc.calcScience(
					Calculator.singleOperator.oneDevidedBy, reader()));
		}
		if (source == cos) {
			writer(calc.calcScience(Calculator.singleOperator.cos,
					reader()));
		}
		if (source == sin) {
			writer(calc.calcScience(Calculator.singleOperator.sin,
					reader()));
		}

		if (source == tan) {
			writer(calc.calcScience(Calculator.singleOperator.tan,
					reader()));
		}
		if (source == ATan) {
			writer(calc.calcScience(Calculator.singleOperator.ATan,
					reader()));
		}
		if (source == ASin) {
			writer(calc.calcScience(Calculator.singleOperator.ASin,
					reader()));
		}
		if (source == ACos) {
			writer(calc.calcScience(Calculator.singleOperator.ACos,
					reader()));
		}
		if (source == equal) {
			writer(calc.calculateEqual(reader()));
		}
		if (source == cancel) {
			writer(calc.reset());
		}
		// for easy continued calculations/copy
		text.selectAll();
	}

	/**
	 * Helper function that gets the texfield area and updates the number input
	 * @return the updated number
	 */
	public Double reader() {
		Double num;
		String str;
		str = text.getText();
		num = Double.valueOf(str);

		return num;
	}

	/**
	 * Helper function that sets the textfield with the number, and avoids NaN issues
	 * @param num
	 */
	public void writer(final Double num) {
		if (Double.isNaN(num)) {
			text.setText("");
		} else {
			text.setText(Double.toString(num));
		}
	}
}
