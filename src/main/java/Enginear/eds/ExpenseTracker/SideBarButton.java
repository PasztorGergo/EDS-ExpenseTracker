package Enginear.eds.ExpenseTracker;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class SideBarButton extends JButton{
    public SideBarButton(String text){
        this.setText(text);
        this.setBorderPainted(false); 
        this.setContentAreaFilled(false); 
        this.setFocusPainted(false); 
        this.setOpaque(false);
        this.setForeground(ETheme.WHITE.getColor());
        this.setFont(new Font("arial",Font.PLAIN,24));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
