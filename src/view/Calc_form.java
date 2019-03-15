package view;

import controller.Calc;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc_form {


    Calc calculator;

    private JButton calculateButton;

    private JLabel calcResult;
    public JPanel panelMain;
    private JTextField yourExpression;


    public Calc_form() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                calculator = new Calc();
                String text = yourExpression.getText();
                double result = calculator.calculate(text);
                if (result % 1 == 0) {
                    calcResult.setText("" + (int) result);
                } else {
                    calcResult.setText("" + result);
                }
            }
        });
    }



}
