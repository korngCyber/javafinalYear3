package code;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator extends JFrame implements ActionListener {
    private JTextField input1, input2, result;
    private JButton Button1, Button2, Button3, Button4, button6, Button5;

    public calculator() {
        createWindow();
        setLayout(new GridBagLayout()); // Using GridBagLayout for flexible layout
        GridBagConstraints grideSetCon = new GridBagConstraints();
        grideSetCon.insets = new Insets(10, 10, 10, 10); // Add padding between components
        JLabel label1 = new JLabel("Number 1:");
        input1 = new JTextField(20);
        JLabel label2 = new JLabel("Number 2:");
        input2 = new JTextField(20);
        JLabel labelResult = new JLabel("Result:");
        result = new JTextField(20);
        Button1 = new JButton("+");
        Button2 = new JButton("-");
        Button3 = new JButton("*");
        Button4 = new JButton("/");
        Button5 = new JButton("%");
        button6 = new JButton("Clear");
        Dimension buttonSize = new Dimension(100, 40);
        Button1.setPreferredSize(buttonSize);
        Button2.setPreferredSize(buttonSize);
        Button3.setPreferredSize(buttonSize);
        Button4.setPreferredSize(buttonSize);
        Button5.setPreferredSize(buttonSize);
        button6.setPreferredSize(buttonSize);
        grideSetCon.gridx = 0;
        grideSetCon.gridy = 0;
        add(label1, grideSetCon);
        grideSetCon.gridx = 1;
        add(input1, grideSetCon);
        grideSetCon.gridx = 0;
        grideSetCon.gridy = 1;
        add(label2, grideSetCon);
        grideSetCon.gridx = 1;
        add(input2, grideSetCon);
        grideSetCon.gridx = 0;
        grideSetCon.gridy = 2;
        add(labelResult, grideSetCon);
        grideSetCon.gridx = 1;
        add(result, grideSetCon);
        grideSetCon.gridx = 0;
        grideSetCon.gridy = 3;
        grideSetCon.gridwidth = 1;
        add(Button1, grideSetCon);
        grideSetCon.gridx = 1;
        add(Button2, grideSetCon);
        grideSetCon.gridx = 0;
        grideSetCon.gridy = 4;
        add(Button3, grideSetCon);
        grideSetCon.gridx = 1;
        add(Button4, grideSetCon);
        grideSetCon.gridx = 0;
        grideSetCon.gridy = 5;
        add(Button5, grideSetCon);
        grideSetCon.gridx = 1;
        add(button6, grideSetCon);
        Button1.addActionListener(this);
        Button2.addActionListener(this);
        Button3.addActionListener(this);
        Button4.addActionListener(this);
        Button5.addActionListener(this);
        button6.addActionListener(this);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void createWindow() {
        setTitle("Calculator");
    }
    public void actionPerformed(ActionEvent e) {
        String s1 = input1.getText();
        String s2 = input2.getText();
        double num1 = 0, num2 = 0;
        try {
            num1 = Double.parseDouble(s1);
            num2 = Double.parseDouble(s2);
        } catch (NumberFormatException ex) {
            result.setText("please input first");
            return;
        }
        if (e.getSource() ==Button1) {
            double sum = num1 + num2;
            result.setText(String.valueOf(sum));
        } else if (e.getSource() == Button2) {
            double diff = num1 - num2;
            result.setText(String.valueOf(diff));
        } else if (e.getSource() == Button3) {
            double product = num1 * num2;
            result.setText(String.valueOf(product));
        } else if (e.getSource() == Button4) {
            if (num2 != 0) {
                double quotient = num1 / num2;
                result.setText(String.valueOf(quotient));
            } else {
                result.setText("Cannot divide by zero");
            }
        } else if (e.getSource() == Button5) {
            double percent = (num1 * num2) / 100;
            result.setText(String.valueOf(percent));
        } else if (e.getSource() == button6) {
            input1.setText("");
            input2.setText("");
            result.setText("");
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}
