package Enginear.eds.ExpenseTracker.View;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class FieldFocusListener implements FocusListener{
    private String placeholder;
    public FieldFocusListener(String placeholder){
        this.placeholder = placeholder;
    }

    @Override
    public void focusGained(FocusEvent e) {
        JTextField field = ((JTextField)e.getComponent());
    
        if(field.getText().equals(placeholder))
            field.setText("");

    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField field = ((JTextField)e.getComponent());
    
        if(field.getText().isBlank())
            field.setText(placeholder);
    }
}
