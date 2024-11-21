package Enginear.eds.ExpenseTracker;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PrintForm extends JFrame{
    private PrinterJob job;
    public PrintForm(){
        this.setLayout(new BorderLayout());
        intiButtons();
    }

    private void intiButtons(){
        JPanel btnContainer = new JPanel();
        btnContainer.setLayout(new FlowLayout());

        JButton submitBtn = new JButton();
        submitBtn.setBackground(ETheme.PRIMARY.getColor());
        submitBtn.setBorder(BorderFactory.createLineBorder(ETheme.WHITE.getColor(),2));
        submitBtn.addActionListener(new PrinterJobListener());

        btnContainer.add(submitBtn);
        btnContainer.add(new CancelButton());

        this.add(btnContainer, BorderLayout.SOUTH);
    }

    private void showPrintFormat(){
        
    }

    private class PrinterJobListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            job = PrinterJob.getPrinterJob();
        }
        
    }
}