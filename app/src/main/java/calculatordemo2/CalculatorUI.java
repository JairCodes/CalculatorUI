package calculatordemo2;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Insets;

public class CalculatorUI{
    public final JFrame frame;
    public final PanelFactory panelFactory;
    public final ButtonFactory buttonFactory;
    public final JTextArea textArea;
    public final Calculator calculator;

    public CalculatorUI() {
        frame = new JFrame("Calculator");
        frame.setResizable(true);
        textArea = new JTextArea(2, 25);
        panelFactory = new PanelFactory();
        buttonFactory = new ButtonFactory();
        calculator = new Calculator(); // Instantiate the Calculator
    }
    
    public void init() {
        frame.setSize(465, 370);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // JPanel panel = new JPanel(new GridLayout(6, 2));//0,1
        JPanel panel = new JPanel(new GridLayout(0, 1,0,0));//0,1
        JPanel numericButtonsPanel = panelFactory.createPanelForNumericButtons(buttonFactory, textArea);
        JPanel primitiveOperatorsPanel = panelFactory.createPrimitiveOperatorsPanel(buttonFactory, textArea, calculator);
        JPanel trigOperatorsPanel = panelFactory.createTrigonometricOperatorsPanel(buttonFactory, textArea, calculator);
        JPanel commonFunctionOperatorsPanel = panelFactory.createCommonFunctionOperatorsPanel(buttonFactory, textArea, calculator);
        JPanel createC = panelFactory.createC(buttonFactory, textArea, calculator);
	    

        panel.add(textArea);
        panel.add(primitiveOperatorsPanel);
        panel.add(trigOperatorsPanel);
        // panel.add(primitiveOperatorsPanel);col 2
        panel.add(commonFunctionOperatorsPanel);
        panel.add(createC);
        panel.add(numericButtonsPanel);

        panel.setBackground(Color.darkGray.darker());

        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Helper function to read a number from the text area
     * @return The parsed number
     */
    public Double reader() {
        Double num;
        String str = textArea.getText();
        num = Double.valueOf(str);
        return num;
    }

    /**
     * Helper function that sets the text area with the number, and avoids NaN issues
     * @param num The number to be displayed
     */
	public void writer(final Double num) {
		if (Double.isNaN(num)) {
			textArea.setText("");
		} else {
			textArea.setText(Double.toString(num));
		}
	}
	

    public void updateTextArea(Double result) {
        if (!Double.isNaN(result)) {
            textArea.setText(Double.toString(result));
        }
    }
}