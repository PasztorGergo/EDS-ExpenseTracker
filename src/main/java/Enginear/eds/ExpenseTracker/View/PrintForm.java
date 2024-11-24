package Enginear.eds.ExpenseTracker.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Enginear.eds.ExpenseTracker.model.ETheme;

public class PrintForm extends JPanel{
    private PrinterJob job;
    public PrintForm(){
        job = PrinterJob.getPrinterJob();
        this.setLayout(new BorderLayout());
        intiButtons();
        job.setPrintable(new PrintFormDesign());
        showPrintFormat();
    }

    private void intiButtons(){
        JPanel btnContainer = new JPanel();
        btnContainer.setLayout(new FlowLayout());

        JButton submitBtn = new JButton("Print");
        submitBtn.setBackground(ETheme.PRIMARY.getColor());
        submitBtn.setBorder(BorderFactory.createLineBorder(ETheme.WHITE.getColor(),2));
        submitBtn.addActionListener(new PrinterJobListener());

        btnContainer.add(submitBtn);
        btnContainer.add(new CancelButton());

        this.add(btnContainer, BorderLayout.SOUTH);
    }

    private void showPrintFormat(){
        //JScrollPane mainArea = new JScrollPane();
        PrintDesignComponent preview = new PrintDesignComponent();
        
        //mainArea.add(preview);
        this.add(preview, BorderLayout.CENTER);
    }

    private class PrinterJobListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                job.printDialog();
                System.out.println("Print is on the way :3");
                job.print();
            } catch (PrinterException err) {
                err.printStackTrace();
            }
        }
        
    }
}