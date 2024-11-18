package Enginear.eds.ExpenseTracker;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewComponentForm extends JPanel {
    private AppController controller;
    private JTextField nameField = new JTextField();
    private JComboBox<String> categoryBox = new JComboBox<String>(new Vector<String>(List.of("income","expense","asset","liability")));
    private JComboBox<String> typeBox = new JComboBox<String>();
    private JTextField amountField = new JTextField();
    private JTextField recurranceField = new JTextField();
    private boolean isRecurring = false;
    /**
     * Uses the passed actionListener for submit event.
     */
    public NewComponentForm(AppController controller){
        this.setLayout(new GridLayout(6,1));
        this.controller = controller;
        initButtons();
        initFields();
        this.setPreferredSize(new Dimension(440,360));
        this.setVisible(true);
    }

    /**
     * Initiates the submit button with the given actionListener
     * to get the text from the JTextFields of the form 
     */
    private void initButtons(){
        JButton submitBtn = new JButton();
        submitBtn.setBackground(ETheme.PRIMARY.getColor());
        submitBtn.setBorder(BorderFactory.createLineBorder(ETheme.WHITE.getColor(),2));
        submitBtn.addActionListener(new NewComponentListener());
        this.add(submitBtn);
    }

    private void initFields(){
        int fieldWidth = 64;
        
        for(JTextField field : List.of(nameField, amountField, recurranceField)){
            field.setColumns(fieldWidth);
            this.add(field);
        }

        recurranceField.setEditable(isRecurring);

        categoryBox.setSelectedIndex(0);
        categoryBox.addActionListener(new ComboBoxListener());
        this.add(categoryBox);

        for(Object typeName : controller.getModelData().types.stream().map(t -> t.name).toArray()){
            this.typeBox.addItem((String)typeName);
        }
    }

    private class ComboBoxListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            isRecurring = ((String)categoryBox.getSelectedItem()).equals("asset") ||
            ((String)categoryBox.getSelectedItem()).equals("liability");

            recurranceField.setEditable(isRecurring);
        }

    }

    private class NewComponentListener implements ActionListener {

        private FinancialType getTypeFromName(){
            return controller.getModelData()
            .types.stream()
            .filter(t -> t.name.equals((String)typeBox.getSelectedItem())).toList().get(0);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.createNewComponent(
                (String)categoryBox.getSelectedItem(), 
                nameField.getText(),
                getTypeFromName(), 
                amountField.getText(), 
                isRecurring ? recurranceField.getText() : null);
        }
    
    }
}
