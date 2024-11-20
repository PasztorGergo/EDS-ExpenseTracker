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
    private JTextField nameField = new JTextField("Name of the new type");
    private JColorChooser colorpicker = new JColorChooser();

    public NewFinancialTypeForm(){
        this.setLayout(new GridLayout(3,1));
        this.setVisible(true);
        initButton();
        nameField.addFocusListener(new FieldFocusListener("Name of the new type"));
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
            AppController.createnewFinancialType(nameField.getText(), colorpicker.getColor());
            AppController.getFrame().submitEvent();
        }

    }
}