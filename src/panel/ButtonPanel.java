package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static panel.BasePanel.outTextField;

public class ButtonPanel extends JPanel{
    private JButton buttonZero  = new JButton("0");
    private JButton buttonOne   = new JButton("1");
    private JButton buttonTwo   = new JButton("2");
    private JButton buttonThree = new JButton("3");
    private JButton buttonFour  = new JButton("4");
    private JButton buttonFive  = new JButton("5");
    private JButton buttonSix   = new JButton("6");
    private JButton buttonSeven = new JButton("7");
    private JButton buttonEight = new JButton("8");
    private JButton buttonNine  = new JButton("9");

    private JButton buttonCE  = new JButton("CE");
    private JButton buttonDot = new JButton(".");
    private JButton buttonAdd = new JButton("+");
    private JButton buttonSub = new JButton("-");
    private JButton buttonDiv = new JButton("/");
    private JButton buttonMul = new JButton("*");

    public ButtonPanel(){
        setLayout(new GridLayout(4,4));

        buttonSeven.addActionListener(new ButtonActionListener());
        add(buttonSeven);
        buttonEight.addActionListener(new ButtonActionListener());
        add(buttonEight);
        buttonNine.addActionListener(new ButtonActionListener());
        add(buttonNine);
        buttonAdd.addActionListener(new ButtonActionListener());
        add(buttonAdd);

        buttonFour.addActionListener(new ButtonActionListener());
        add(buttonFour);
        buttonFive.addActionListener(new ButtonActionListener());
        add(buttonFive);
        buttonSix.addActionListener(new ButtonActionListener());
        add(buttonSix);
        buttonSub.addActionListener(new ButtonActionListener());
        add(buttonSub);

        buttonOne.addActionListener(new ButtonActionListener());
        add(buttonOne);
        buttonTwo.addActionListener(new ButtonActionListener());
        add(buttonTwo);
        buttonThree.addActionListener(new ButtonActionListener());
        add(buttonThree);
        buttonMul.addActionListener(new ButtonActionListener());
        add(buttonMul);

        buttonCE.addActionListener(new ButtonActionListener());
        add(buttonCE);
        buttonZero.addActionListener(new ButtonActionListener());
        add(buttonZero);
        buttonDot.addActionListener(new ButtonActionListener());
        add(buttonDot);
        buttonDiv.addActionListener(new ButtonActionListener());
        add(buttonDiv);
    }

    protected static class ButtonActionListener implements ActionListener {
        private double result;
        private static String operationSymbol = "";
        private static String firstValue = "";
        private static String secondValue = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttEvent = (JButton) e.getSource();
            String buttValue = buttEvent.getText();
            switch (buttValue) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "0":
                    outTextField.setText(outTextField.getText().concat(buttValue));
                    System.out.println(buttValue);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    calcOperation(buttValue);
                    break;
//                case "+":
//                    if (operationSymbol != "+" && operationSymbol == "") {
//                        firstValue = outTextField.getText();
//                        operationSymbol = "+";
//                        System.out.println(operationSymbol);
//                        outTextField.setText(outTextField.getText().concat(operationSymbol));
//                    }
//                    break;
//                case "-":
//                    if (operationSymbol != "-" && operationSymbol == "") {
//                        firstValue = outTextField.getText();
//                        operationSymbol = "-";
//                        System.out.println(operationSymbol);
//                        outTextField.setText(outTextField.getText().concat(operationSymbol));
//                    }
//                    break;
//                case "*":
//                    if (operationSymbol != "*" && operationSymbol == "") {
//                        firstValue = outTextField.getText();
//                        operationSymbol = "*";
//                        System.out.println(operationSymbol);
//                        outTextField.setText(outTextField.getText().concat(operationSymbol));
//                    }
//                    break;
//                case "/":
//                    if (operationSymbol != "/" && operationSymbol == "") {
//                        firstValue = outTextField.getText();
//                        operationSymbol = "/";
//                        System.out.println(operationSymbol);
//                        outTextField.setText(outTextField.getText().concat(operationSymbol));
//                    }
//                    break;
                case "CE":
                    outTextField.setText("");
                    System.out.println("firstValue = secondValue = separator = \"\"");
                    firstValue = secondValue = operationSymbol = "";
                    break;
                case ".":
                    outTextField.setText(outTextField.getText().concat(buttValue));
                    break;
                case "=":
                    System.out.println("=");
                    switch (operationSymbol){
                        case "+":
                            System.out.println(operationSymbol);
                            secondValue = outTextField.getText().substring(firstValue.length()+1);
                            result = round(Double.parseDouble(firstValue) + Double.parseDouble(secondValue));
                            secondValue = Double.toString(result);
                            outTextField.setText(secondValue);
                            operationSymbol = "";
                            break;
                        case "-":
                            System.out.println(operationSymbol);
                            secondValue = outTextField.getText().substring(firstValue.length()+1);
                            result = round(Double.parseDouble(firstValue) - Double.parseDouble(secondValue));
                            secondValue = Double.toString(result);
                            outTextField.setText(secondValue);
                            operationSymbol = "";
                            break;
                        case "*":
                            System.out.println(operationSymbol);
                            secondValue = outTextField.getText().substring(firstValue.length()+1);
                            result = round(Double.parseDouble(firstValue) * Double.parseDouble(secondValue));
                            secondValue = Double.toString(result);
                            outTextField.setText(secondValue);
                            operationSymbol = "";
                            break;
                        case "/":
                            System.out.println(operationSymbol);
                            secondValue = outTextField.getText().substring(firstValue.length()+1);
                            if (Double.parseDouble(secondValue) == 0) {
                                outTextField.setText("На ноль делить нельзя!");
                                break;
                            }
                            result = round(Double.parseDouble(firstValue) / Double.parseDouble(secondValue));
                            secondValue = Double.toString(result);
                            outTextField.setText(secondValue);
                            operationSymbol = "";
                            break;
                    }
                    break;
            }
        }
        private void calcOperation(String operation){
            if (operationSymbol != operation && operationSymbol == "") {
                firstValue = outTextField.getText();
                operationSymbol = operation;
                System.out.println(operationSymbol);
                outTextField.setText(outTextField.getText().concat(operationSymbol));
            }
        }
        private double round(double value) {
            int places = 10;
            BigDecimal bd = new BigDecimal(Double.toString(value));
            bd = bd.setScale(places, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }
    }
}
