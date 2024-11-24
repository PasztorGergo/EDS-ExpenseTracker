package Enginear.eds.ExpenseTracker.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Enginear.eds.ExpenseTracker.model.ETheme;

public class StatementPanel extends JPanel {
    public StatementPanel(){
        JPanel nonrecurringPanels = new JPanel();
        JPanel recurringPanels = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel hiddenIncomePanel = new JPanel();
        JPanel hiddenTwoIncomePanel = new JPanel();

        topPanel.setLayout(new BorderLayout());
        this.setLayout(new GridLayout(2,1,0,32));
        nonrecurringPanels.setLayout(new GridLayout(2,1));
        recurringPanels.setLayout(new GridLayout(1,2));

        hiddenIncomePanel.setPreferredSize(new Dimension(200,400));
        hiddenTwoIncomePanel.setPreferredSize(new Dimension(200,400));
        nonrecurringPanels.setMaximumSize(new Dimension(448,400));
        recurringPanels.setMaximumSize(new Dimension(640,360));

        topPanel.add(hiddenIncomePanel,BorderLayout.WEST);
        topPanel.add(hiddenTwoIncomePanel,BorderLayout.EAST);
        topPanel.add(nonrecurringPanels,BorderLayout.CENTER);

        JPanel incomePanel = new JPanel();
        JPanel expensePanel = new JPanel();
        JPanel assetPanel = new JPanel();
        JPanel liabilityPanel = new JPanel();
        ArrayList<JPanel> panels = new ArrayList<>(List.of(incomePanel, expensePanel, assetPanel, liabilityPanel));

        Dimension portraitSize = new Dimension(448,200);
        Dimension landscapeSize = new Dimension(320,360);

        for(JPanel panel : panels){
            panel.setBackground(new Color(1f,1f,1f,0.25f));
            panel.setBorder(BorderFactory.createLineBorder(ETheme.WHITE.getColor(),2));
            panel.setLayout(new FlowLayout());
        }

        incomePanel.setMaximumSize(portraitSize);
        expensePanel.setMaximumSize(portraitSize);

        assetPanel.setMaximumSize(landscapeSize);
        liabilityPanel.setMaximumSize(landscapeSize);

        nonrecurringPanels.add(incomePanel, 0);
        nonrecurringPanels.add(expensePanel, 1);

        recurringPanels.add(assetPanel,0);
        recurringPanels.add(liabilityPanel,1);

        nonrecurringPanels.setBackground(ETheme.BACKGROUND.getColor());
        recurringPanels.setBackground(ETheme.BACKGROUND.getColor());
        hiddenIncomePanel.setBackground(ETheme.BACKGROUND.getColor());
        hiddenTwoIncomePanel.setBackground(ETheme.BACKGROUND.getColor());

        this.add(topPanel, 0);
        this.add(recurringPanels, 1);

        this.setBackground(ETheme.BACKGROUND.getColor());

        this.setVisible(true);
    }
}
