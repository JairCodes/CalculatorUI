package calculatordemo2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

// ButtonFactory.java
import javax.swing.*;

public class ButtonFactory {
    
    public JButton createNumericButton(int value, JTextArea textArea) {
        JButton button = new JButton(String.valueOf(value));
        button.addActionListener(e -> {
            textArea.append(String.valueOf(value)); // Append the value to the text area
        });
        return button;
        
    }    
    public JButton[] createNumericButtons(JTextArea textArea) {

        JButton[] numericButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numericButtons[i] = createNumericButton(i, textArea);
            numericButtons[i].setBackground(Color.pink);
            numericButtons[i].setForeground(Color.black);
            numericButtons[i].setPreferredSize(new Dimension(50,25));


        }
        numericButtons[0].setPreferredSize(new Dimension(150,25));
        return numericButtons;
    }

    public JButton createNumericButton(int value) {
        return new JButton(String.valueOf(value));
    }

    public JButton createOperatorButton(String label) {
        return new JButton(label);
    }

    public JButton createTrigonometricOperatorButton(String label) {
        return new JButton(label);
        // Specific handling for trigonometric operators
    }

    public JButton createCommonFunctionOperatorButton(String label) {
        return new JButton(label);
        // Specific handling for common function operators
    }

    public JButton[] createPrimitiveOperatorButtons() {
        JButton[] primitiveOperatorButtons = new JButton[5];
        primitiveOperatorButtons[0] = createOperatorButton("+");
        primitiveOperatorButtons[1] = createOperatorButton("-");
        primitiveOperatorButtons[2] = createOperatorButton("*");
        primitiveOperatorButtons[3] = createOperatorButton("/");
        primitiveOperatorButtons[4] = createOperatorButton("=");
        for (JButton button : primitiveOperatorButtons) {
            button.setForeground(Color.pink);
            button.setBackground(Color.BLACK); 
            button.setPreferredSize(new Dimension(50,25));  
        }
        return primitiveOperatorButtons;
    }

    public JButton[] createTrigonometricOperatorButtons() {
        JButton[] trigonometricOperatorButtons = new JButton[6];
        trigonometricOperatorButtons[0] = createTrigonometricOperatorButton("Sin");
        trigonometricOperatorButtons[1] = createTrigonometricOperatorButton("Cos");
        trigonometricOperatorButtons[2] = createTrigonometricOperatorButton("Tan");
        trigonometricOperatorButtons[3] = createTrigonometricOperatorButton("ATan");
        trigonometricOperatorButtons[4] = createTrigonometricOperatorButton("Asin");
        trigonometricOperatorButtons[5] = createTrigonometricOperatorButton("ACos");

        for (JButton button : trigonometricOperatorButtons) {
            button.setForeground(Color.pink);
            button.setBackground(Color.BLACK);
            button.setPreferredSize(new Dimension(70,25));
        }
        
        return trigonometricOperatorButtons;
    }

    public JButton[] createCommonFunctionOperatorButtons() {
        JButton[] commonFunctionOperatorButtons = new JButton[3];
        commonFunctionOperatorButtons[0] = createCommonFunctionOperatorButton("√");
        commonFunctionOperatorButtons[1] = createCommonFunctionOperatorButton("x^2");
        commonFunctionOperatorButtons[2] = createCommonFunctionOperatorButton("1/x");

        for (JButton button : commonFunctionOperatorButtons) {
            button.setForeground(Color.pink);
            button.setBackground(Color.BLACK);
            button.setPreferredSize(new Dimension(70,25));
        }

        return commonFunctionOperatorButtons;
    }
}