package Enginear.eds.ExpenseTracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NewFinancialTypeForm extends JPanel{
    private JButton submitBtn = new JButton("Create");
    public NewFinancialTypeForm(){
        this.setVisible(true);
    }

    private class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        }

    }
}