package Enginear.eds.ExpenseTracker;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class CancelButton extends JButton{
    public CancelButton(){
        this.setText("Cancel");
        this.setBackground(new Color(0xe35020));
        this.addActionListener(e -> AppController.getFrame().submitEvent());
        this.addMouseListener(new HoverMouseAdapter());
    }

    private class HoverMouseAdapter extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e) {
            e.getComponent().setBackground(new Color(0xe35020).darker());
        }
        @Override
        public void mouseExited(MouseEvent e) {
            e.getComponent().setBackground(new Color(0xe35020));
        }
    }
}
