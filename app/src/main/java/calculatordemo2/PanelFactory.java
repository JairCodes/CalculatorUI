package calculatordemo2;
// PanelFactory.java

import java.awt.FlowLayout;

import javax.swing.*;

public class PanelFactory {
    public JPanel createPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        return panel;
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
    public JPanel createC(ButtonFactory buttonFactory, JTextArea textArea, Calculator calculator) {
        JPanel panel = createPanel();
        JButton[] createC = buttonFactory.createC(textArea, calculator);
        for (JButton button : createC) {
            panel.add(button);
        }
        return panel;
    }  
}

