package calculatordemo2;
// PanelFactory.java

import java.awt.Dimension;

import javax.swing.*;

public class PanelFactory {
    public JPanel createPanel() {
        return new JPanel();
    }
    public JPanel createPanelForNumericButtons(ButtonFactory buttonFactory, JTextArea textArea) {
        JPanel panel = createPanel();
        JButton[] numericButtons = buttonFactory.createNumericButtons(textArea);
        for (int i = 9; i >= 0;i--){
            panel.add(numericButtons[i]);
        }
        return panel;
    }

    public JPanel createPrimitiveOperatorsPanel(ButtonFactory buttonFactory, JTextArea textArea, Calculator calculator) {
        JPanel panel = createPanel();
        JButton[] primitiveOperatorButtons = buttonFactory.createPrimitiveOperatorButtons(textArea, calculator);
        // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (JButton button : primitiveOperatorButtons) {
            panel.add(button);

        }
        return panel;
    }


    public JPanel createTrigonometricOperatorsPanel(ButtonFactory buttonFactory, JTextArea textArea, Calculator calculator) {
        JPanel panel = createPanel();
        JButton[] trigonometricOperatorButtons = buttonFactory.createTrigonometricOperatorButtons(textArea, calculator);
        for (JButton button : trigonometricOperatorButtons) {
            panel.add(button);
        }
        return panel;
    }

    public JPanel createCommonFunctionOperatorsPanel(ButtonFactory buttonFactory, JTextArea textArea, Calculator calculator) {
        JPanel panel = createPanel();
        JButton[] commonFunctionOperatorButtons = buttonFactory.createCommonFunctionOperatorButtons(textArea, calculator);
        for (JButton button : commonFunctionOperatorButtons) {
            panel.add(button);
        }
        return panel;
    }  
}

