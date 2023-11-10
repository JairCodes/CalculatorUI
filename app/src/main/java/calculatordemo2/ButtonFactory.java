package calculatordemo2;
//ButtonFactory
import javax.swing.JButton;
import javax.swing.JTextArea;

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
        }
        return numericButtons;
    }

    public JButton createOperatorButton(String label, JTextArea textArea, Calculator calculator) {
        JButton button = new JButton(label);
        button.addActionListener(e -> {
            String currentText = textArea.getText();

            if (label.equals("=")) {
                Double result = calculator.calculateEqual(Double.valueOf(currentText));
                textArea.setText(String.valueOf(result));
            } else {
                currentText += " " + label + " ";
                textArea.setText(currentText);
            }
        });
        return button;
    }

    public JButton createNumericButton(int value, JTextArea textArea, Calculator calculator) {
        JButton button = new JButton(String.valueOf(value));
        button.addActionListener(e -> {
            textArea.append(String.valueOf(value)); // Append the value to the text area
            double numericValue = Double.parseDouble(textArea.getText());
            double result = calculator.calcScience(Calculator.singleOperator.squareRoot, numericValue);
            textArea.setText(String.valueOf(result)); // Display the square root of the entered number
        });
        return button;
    }
    
    public JButton createPrimitiveOperatorButton(String label, JTextArea textArea, Calculator calculator) {
        JButton button = new JButton(label);
        button.addActionListener(e -> {
            Double result = null;
    
            switch (label) {
                case "+":
                    result = calculator.twoOpCaller(Calculator.twoOperator.add, Double.parseDouble(textArea.getText()));
                    break;
                case "-":
                    result = calculator.twoOpCaller(Calculator.twoOperator.subtract, Double.parseDouble(textArea.getText()));
                    break;
                case "*":
                    result = calculator.twoOpCaller(Calculator.twoOperator.multiply, Double.parseDouble(textArea.getText()));
                    break;
                case "/":
                    result = calculator.twoOpCaller(Calculator.twoOperator.divide, Double.parseDouble(textArea.getText()));
                    break;
                // Add more cases for other arithmetic operations if needed
                default:
                    break;
            }
    
            if (result != null) {
                textArea.setText(String.valueOf(result));
            }
        });
        return button;
    }

    public JButton createCommonFunctionOperatorButton(String label, JTextArea textArea, Calculator calculator) {
        JButton button = new JButton(label);
        button.addActionListener(e -> {
            Double result = null;

            switch (label) {
                case "√":
                    result = calculator.calcScience(Calculator.singleOperator.squareRoot, Double.parseDouble(textArea.getText()));
                    break;
                case "x^2":
                    result = calculator.calcScience(Calculator.singleOperator.square, Double.parseDouble(textArea.getText()));
                    break;
                case "1/x":
                    result = calculator.calcScience(Calculator.singleOperator.oneDevidedBy, Double.parseDouble(textArea.getText()));
                    break;
                // Add additional cases for other functionalities if needed
                default:
                    break;
            }

            if (result != null) {
                textArea.setText(String.valueOf(result));
            }
        });
        return button;
    }
    public JButton createTrigonometricOperatorButton(String label, JTextArea textArea, Calculator calculator) {
        JButton button = new JButton(label);
        button.addActionListener(e -> {
            Double result = null;
            switch (label) {
                case "Sin":
                    result = calculator.calcScience(Calculator.singleOperator.sin, Double.parseDouble(textArea.getText()));
                    break;
                case "Cos":
                    result = calculator.calcScience(Calculator.singleOperator.cos, Double.parseDouble(textArea.getText()));
                    break;
                case "Tan":
                    result = calculator.calcScience(Calculator.singleOperator.tan, Double.parseDouble(textArea.getText()));
                    break;
                // Add additional cases for other trigonometric functions if needed
                default:
                    break;
            }

            if (result != null) {
                textArea.setText(String.valueOf(result));
            }
        });
        return button;
    }

    public JButton[] createPrimitiveOperatorButtons(JTextArea textArea, Calculator calculator) {
        JButton[] primitiveOperatorButtons = new JButton[5];
        primitiveOperatorButtons[0] = createOperatorButton("+", textArea, calculator);
        primitiveOperatorButtons[1] = createOperatorButton("-", textArea, calculator);
        primitiveOperatorButtons[2] = createOperatorButton("*", textArea, calculator);
        primitiveOperatorButtons[3] = createOperatorButton("/", textArea, calculator);
        primitiveOperatorButtons[4] = createOperatorButton("=", textArea, calculator);
        return primitiveOperatorButtons;
    }

    public JButton[] createTrigonometricOperatorButtons(JTextArea textArea, Calculator calculator) {
        JButton[] trigonometricOperatorButtons = new JButton[3];
        trigonometricOperatorButtons[0] = createTrigonometricOperatorButton("Sin", textArea, calculator);
        trigonometricOperatorButtons[1] = createTrigonometricOperatorButton("Cos", textArea, calculator);
        trigonometricOperatorButtons[2] = createTrigonometricOperatorButton("Tan", textArea, calculator);
        return trigonometricOperatorButtons;
    }

    public JButton[] createCommonFunctionOperatorButtons(JTextArea textArea, Calculator calculator) {
        JButton[] commonFunctionOperatorButtons = new JButton[3];
        commonFunctionOperatorButtons[0] = createCommonFunctionOperatorButton("√", textArea, calculator);
        commonFunctionOperatorButtons[1] = createCommonFunctionOperatorButton("x^2", textArea, calculator);
        commonFunctionOperatorButtons[2] = createCommonFunctionOperatorButton("1/x", textArea, calculator);
        return commonFunctionOperatorButtons;
    }
}
