package controller;


import view.Calc_form;

import javax.swing.*;

public class Main {



    public static void main(String[] args) {
        JFrame frame = new JFrame("Calc_form");
        frame.setContentPane(new Calc_form().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
