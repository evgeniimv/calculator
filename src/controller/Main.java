package controller;


import view.Calc_form;

import javax.swing.*;

public class Main {



    public static void main(String[] args) {
        Calc_form frame = new Calc_form();
        frame.setContentPane(new Calc_form().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
