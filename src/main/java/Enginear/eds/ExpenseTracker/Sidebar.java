package Enginear.eds.ExpenseTracker;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;

public class Sidebar extends JPanel {
    public Sidebar(){
        this.setBackground(ETheme.SECONDARY.getColor());
    }

    public void hideComponents(){
        for(Component comp : this.getComponents()){
            this.remove(comp);
        }
    }
}