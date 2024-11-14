package Enginear.eds.ExpenseTracker;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame{
    private ImageIcon appIcon = new ImageIcon("src/main/resources/Logo.png");
    private Model modelData = new Model();

    public AppFrame(){
        setTitle("Expense-tracker | EnginEar's EDS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setSize(200,200);
        setIconImage(appIcon.getImage());
        getContentPane().setBackground(ETheme.BACKGROUND.getColor());
        setForeground(ETheme.WHITE.getColor());
        createFinancialPanes();
    }

    public void updateView(Model model){
        modelData = model;
    }

    private void createFinancialPanes(){
        JPanel nonrecurringPanels = new JPanel();
        JPanel recurringPanels = new JPanel();

        JPanel incomePanel = new JPanel();
        JPanel expensePanel = new JPanel();
        JPanel assetPanel = new JPanel();
        JPanel liabilityPanel = new JPanel();
        ArrayList<JPanel> panels = new ArrayList<>(List.of(incomePanel, expensePanel, assetPanel, liabilityPanel));

        nonrecurringPanels.add(incomePanel);
        nonrecurringPanels.add(expensePanel);
        recurringPanels.add(assetPanel);
        recurringPanels.add(liabilityPanel);

        for(JPanel panel : panels){
            panel.setBorder(BorderFactory.createLineBorder(ETheme.WHITE.getColor(), 1, false));
        }
        
        nonrecurringPanels.setBackground(new Color(1f,1f,1f,0.25f));
        recurringPanels.setBackground(new Color(1f,1f,1f,0.25f));

        this.add(nonrecurringPanels);
        this.add(recurringPanels);
    }
}
