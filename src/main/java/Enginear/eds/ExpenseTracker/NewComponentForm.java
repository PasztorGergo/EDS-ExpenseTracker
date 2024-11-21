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
    private JTextField nameField = new JTextField("Your component name");
    private JComboBox<String> categoryBox = new JComboBox<>(new Vector<>(List.of("income","expense","asset","liability")));
    private JComboBox<String> typeBox = new JComboBox<>();
    private JTextField amountField = new JTextField("Financial amount in USD");
    private JTextField recurranceField = new JTextField("Reucrrance (double + period_char)");
    private boolean isRecurring = false;
    /**
     * Uses the passed actionListener for submit event.
     */
    public NewComponentForm(){
        this.setLayout(new GridLayout(6,1));
        initFields();
        initButtons();
        this.setPreferredSize(new Dimension(440,360));
        this.setVisible(true);
    }

    /**
     * Initiates the submit button with the given actionListener
     * to get the text from the JTextFields of the form 
     */
    private void initButtons(){
        JButton submitBtn = new JButton("Create");
        submitBtn.setBackground(ETheme.PRIMARY.getColor());
        submitBtn.setBorder(BorderFactory.createLineBorder(ETheme.WHITE.getColor(),2));
        submitBtn.addActionListener(new NewComponentListener());
        this.add(submitBtn);
    }

    private void initFields(){
        int fieldWidth = 64;
        List<JTextField> fields = List.of(nameField, amountField, recurranceField);
        
        for(int i = 0; i < fields.size(); i++){
            fields.get(i).setColumns(fieldWidth);
            this.add(fields.get(i),i);
        }

        nameField.addFocusListener(new FieldFocusListener("Your component name"));
        amountField.addFocusListener(new FieldFocusListener("Financial amount in USD"));
        recurranceField.addFocusListener(new FieldFocusListener("Reucrrance (double + period_char)"));

        recurranceField.setEditable(isRecurring);

        categoryBox.setSelectedIndex(0);
        categoryBox.addActionListener(new ComboBoxListener());
        this.add(categoryBox);

        for(Object typeName : AppController.getModelData().types.stream().map(t -> t.name).toList()){
            this.typeBox.addItem((String)typeName);
        }
        this.add(typeBox);
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
            return AppController.getModelData()
            .types.stream()
            .filter(t -> t.name.equals((String)typeBox.getSelectedItem())).toList().get(0);
        }

        @Override
        public void actionPerformed(ActionEvent e) throws IllegalArgumentException {
            try {
                AppController.createNewComponent(
                (String)categoryBox.getSelectedItem(), 
                nameField.getText(),
                getTypeFromName(), 
                amountField.getText(), 
                isRecurring ? recurranceField.getText() : null);
                AppController.getFrame().submitEvent();
            } catch (IllegalArgumentException err) {
                err.printStackTrace();
            }
        }
    
    }
}
