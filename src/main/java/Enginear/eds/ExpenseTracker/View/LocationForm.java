package Enginear.eds.ExpenseTracker.View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import Enginear.eds.ExpenseTracker.AppController;
import Enginear.eds.ExpenseTracker.ExportController;
import Enginear.eds.ExpenseTracker.ImportController;

public class LocationForm{
    private String path;
    private JFileChooser fc = new JFileChooser();
    public LocationForm(boolean isExport){
        fc.setFileSelectionMode(isExport ? JFileChooser.DIRECTORIES_ONLY : JFileChooser.FILES_ONLY);
        int option = fc.showOpenDialog(AppController.getFrame());

        path = fc.getSelectedFile().getPath();
        if(option == JFileChooser.APPROVE_OPTION){
            if(isExport){
                ExportController exp = new ExportController();
                exp.StringifyModel(fc.getSelectedFile().getPath());
            }else{
                System.out.println(path);
                ImportController.readJsonFrom(path);
            }
        }

    }
}