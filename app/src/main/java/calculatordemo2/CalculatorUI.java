package calculatordemo2;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;
import javax.swing.JPanel;

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
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        // JPanel panel = panelFactory.createPanel();
        JPanel numericButtonsPanel = panelFactory.createPanelForNumericButtons(buttonFactory, textArea);
        JPanel primitiveOperatorsPanel = panelFactory.createPrimitiveOperatorsPanel(buttonFactory, textArea, calculator);
        JPanel trigOperatorsPanel = panelFactory.createTrigonometricOperatorsPanel(buttonFactory, textArea, calculator);
        JPanel commonFunctionOperatorsPanel = panelFactory.createCommonFunctionOperatorsPanel(buttonFactory, textArea, calculator);
	    panel.setBackground(Color.darkGray.darker());

        panel.add(textArea);
        panel.add(primitiveOperatorsPanel);
        panel.add(trigOperatorsPanel);
        panel.add(commonFunctionOperatorsPanel);
        panel.add(numericButtonsPanel);


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