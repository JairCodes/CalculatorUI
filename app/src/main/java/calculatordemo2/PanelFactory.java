package calculatordemo2;
// PanelFactory.java
import javax.swing.*;

public class PanelFactory {
    public JPanel createPanel() {
        return new JPanel();
    }
    public JPanel createPanelForNumericButtons(ButtonFactory buttonFactory, JTextArea textArea) {
        JPanel panel = createPanel();
        JButton[] numericButtons = buttonFactory.createNumericButtons(textArea);
        for (JButton button : numericButtons) {
            panel.add(button);
        }
        return panel;
    }

    public JPanel createPrimitiveOperatorsPanel(ButtonFactory buttonFactory) {
        JPanel panel = createPanel();
        JButton[] primitiveOperatorButtons = buttonFactory.createPrimitiveOperatorButtons();
        for (JButton button : primitiveOperatorButtons) {
            panel.add(button);
        }
        return panel;
    }


    public JPanel createTrigonometricOperatorsPanel(ButtonFactory buttonFactory) {
        JPanel panel = createPanel();
        JButton[] trigonometricOperatorButtons = buttonFactory.createTrigonometricOperatorButtons();
        for (JButton button : trigonometricOperatorButtons) {
            panel.add(button);
        }
        return panel;
    }

    public JPanel createCommonFunctionOperatorsPanel(ButtonFactory buttonFactory) {
        JPanel panel = createPanel();
        JButton[] commonFunctionOperatorButtons = buttonFactory.createCommonFunctionOperatorButtons();
        for (JButton button : commonFunctionOperatorButtons) {
            panel.add(button);
        }
        return panel;
    }
}

