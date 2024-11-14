package Enginear.eds.ExpenseTracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class AppFrame extends JFrame{
    private ImageIcon appIcon = new ImageIcon("src/main/resources/Logo.png");
    private Model modelData = new Model();
    private AppController controller = new AppController(modelData, this);
    private Sidebar sidebar = new Sidebar();
    private SideBarButton addTypeBtn = new SideBarButton("Add Type");
    private SideBarButton addComponentBtn = new SideBarButton("New Component");
    private SideBarButton printBtn = new SideBarButton("Print");
    private SideBarButton exportBtn = new SideBarButton("Export");
    private SideBarButton importBtn = new SideBarButton("Import");
    private JPanel currentMainAreaPanel;

    public AppFrame(){
        setTitle("Expense-tracker | EnginEar's EDS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setSize(200,200);
        setIconImage(appIcon.getImage());
        getContentPane().setBackground(ETheme.BACKGROUND.getColor());
        setForeground(ETheme.WHITE.getColor());
        setLayout(new BorderLayout());
        createFinancialPanes();
        add(sidebar,BorderLayout.WEST);
        setupButtons();
        setupSidebar();
        setVisible(true);
    }

    private void setupButtons(){
        
    }

    private void setupSidebar(){
        for(SideBarButton btn : List.of(addTypeBtn, addComponentBtn, printBtn, exportBtn, importBtn)){
            btn.addMouseListener(new HoverMouseAdapter());
            sidebar.add(btn);
        }

        JButton credit = new JButton("Made by EnginEar the protogen");
        credit.setIcon(appIcon);
        credit.setBorderPainted(false); 
        credit.setContentAreaFilled(false); 
        credit.setFocusPainted(false); 
        credit.setOpaque(false);
        credit.setForeground(ETheme.WHITE.getColor());
        sidebar.add(credit);
    }

    public void updateView(Model model){
        modelData = model;
    }

    private void replaceMainArea(JPanel replaceWith){
        this.remove(currentMainAreaPanel);
        this.add(replaceWith,BorderLayout.CENTER);
    }

    private void createFinancialPanes(){
        JPanel nonrecurringPanels = new JPanel();
        JPanel recurringPanels = new JPanel();
        JPanel statementPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel hiddenIncomePanel = new JPanel();
        JPanel hiddenTwoIncomePanel = new JPanel();

        topPanel.setLayout(new BorderLayout());
        statementPanel.setLayout(new GridLayout(2,1,0,32));
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

        statementPanel.add(topPanel, 0);
        statementPanel.add(recurringPanels, 1);

        statementPanel.setBackground(ETheme.BACKGROUND.getColor());

        this.add(statementPanel, BorderLayout.CENTER);
        currentMainAreaPanel = statementPanel;
    }

    private class HoverMouseAdapter extends MouseAdapter{
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            evt.getComponent().setForeground(ETheme.PRIMARY.getColor());
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            evt.getComponent().setForeground(ETheme.WHITE.getColor());
        }
    }
}
