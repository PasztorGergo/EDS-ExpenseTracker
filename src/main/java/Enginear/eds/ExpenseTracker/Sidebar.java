package Enginear.eds.ExpenseTracker;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Sidebar extends JPanel {

    public Sidebar(){
        this.setLayout(new GridLayout(8,1));
        this.setBackground(ETheme.SECONDARY.getColor());
        this.setPreferredSize(new Dimension(440,1024));
        this.setBorder(BorderFactory.createLineBorder(new Color(0x1C2024),8,false));
    }
    

    public void hideComponents(){
        for(Component comp : this.getComponents()){
            this.remove(comp);
        }
    }
}