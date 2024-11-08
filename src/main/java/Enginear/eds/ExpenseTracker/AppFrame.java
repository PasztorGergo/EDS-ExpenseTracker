package Enginear.eds.ExpenseTracker;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AppFrame extends JFrame{
    private ImageIcon appIcon = new ImageIcon("src/main/resources/Logo.png");
    private Model modelData = new Model();

    public AppFrame(){
        setTitle("Expense-tracker | EnginEar's EDS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setSize(200,200);
        setIconImage(appIcon.getImage());
        getContentPane().setBackground(new Color(0x07100F));
        setForeground(new Color(0xFFFFFF));
    }

    public void updateView(Model model){
        modelData = model;
    }

    private void createFinancialPanes(){
        
    }
}
