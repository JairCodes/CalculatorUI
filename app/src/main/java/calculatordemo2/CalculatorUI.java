package calculatordemo2;

import javax.swing.*;

public class CalculatorUI {
    private final JFrame frame;
    private final PanelFactory panelFactory;
    private final ButtonFactory buttonFactory;
    private final JTextArea textArea;
    private final Calculator calculator;

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

        JPanel panel = panelFactory.createPanel();
        JPanel numericButtonsPanel = panelFactory.createPanelForNumericButtons(buttonFactory, textArea);
        JPanel primitiveOperatorsPanel = panelFactory.createPrimitiveOperatorsPanel(buttonFactory, textArea, calculator);
        JPanel trigOperatorsPanel = panelFactory.createTrigonometricOperatorsPanel(buttonFactory, textArea, calculator);
        JPanel commonFunctionOperatorsPanel = panelFactory.createCommonFunctionOperatorsPanel(buttonFactory, textArea, calculator);

        panel.add(textArea);
        panel.add(numericButtonsPanel);
        panel.add(primitiveOperatorsPanel);
        panel.add(trigOperatorsPanel);
        panel.add(commonFunctionOperatorsPanel);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void updateTextArea(Double result) {
        if (!Double.isNaN(result)) {
            textArea.setText(Double.toString(result));
        }
    }
}
