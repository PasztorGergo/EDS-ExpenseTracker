package Enginear.eds.ExpenseTracker;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewFinancialTypeForm extends JPanel{
    private JButton submitBtn = new JButton("Create");
    private JTextField nameField = new JTextField();
    private JColorChooser colorpicker = new JColorChooser();
    private AppController controller;

    public NewFinancialTypeForm(AppController controller){
        this.controller = controller;
        this.setLayout(new GridLayout(3,1));
        this.setVisible(true);
        initButton();
        this.add(nameField);
        this.add(colorpicker);
    }

    private void initButton(){
        submitBtn.setBackground(ETheme.PRIMARY.getColor());
        submitBtn.setBorder(BorderFactory.createLineBorder(ETheme.WHITE.getColor(),2));
        submitBtn.addActionListener(new SubmitListener());
        this.add(submitBtn);
    }

    private class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.createnewFinancialType(nameField.getText(), colorpicker.getColor());
        }

    }
}