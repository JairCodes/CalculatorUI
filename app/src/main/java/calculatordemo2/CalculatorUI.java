package calculatordemo2;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;
import javax.swing.JPanel;


public class CalculatorUI{
    private final JFrame frame;
    private final PanelFactory panelFactory;
    private final ButtonFactory buttonFactory;
    private final JTextArea textArea;
	

    public CalculatorUI() {
        frame = new JFrame("Calculator");
		frame.setResizable(true);
		textArea = new JTextArea(2,25);
        panelFactory = new PanelFactory();
        buttonFactory = new ButtonFactory();
    }

    public void init() {
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	JPanel panel = new JPanel(new GridLayout(0, 1));
	panel.setBackground(Color.darkGray.darker());

    // JPanel panel = panelFactory.createPanel();
    JPanel numericButtonsPanel = panelFactory.createPanelForNumericButtons(buttonFactory, textArea);
    JPanel primitiveOperatorsPanel = panelFactory.createPrimitiveOperatorsPanel(buttonFactory);
    JPanel trigOperatorsPanel = panelFactory.createTrigonometricOperatorsPanel(buttonFactory);
    JPanel commonFunctionOperatorsPanel = panelFactory.createCommonFunctionOperatorsPanel(buttonFactory);
    
    panel.add(textArea); // Add the text area to the panel
    // panel.add(numericButtonsPanel);
    panel.add(primitiveOperatorsPanel);
    panel.add(trigOperatorsPanel);
    panel.add(commonFunctionOperatorsPanel);
	panel.add(numericButtonsPanel);
	


    frame.add(panel);
    frame.setVisible(true);
	}

	

	public Double reader() {
		Double num;
		String str;
		str = textArea.getText();
		num = Double.valueOf(str);

		return num;
	}

	public void writer(final Double num) {
		if (Double.isNaN(num)) {
			textArea.setText("");
		} else {
			textArea.setText(Double.toString(num));
		}
	}

}

