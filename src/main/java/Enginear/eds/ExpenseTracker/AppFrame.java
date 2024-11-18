package Enginear.eds.ExpenseTracker;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
    private StatementPanel statementPanel = new StatementPanel();

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
        addComponentBtn.addActionListener(e -> replaceMainArea(new NewComponentForm(controller)));
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
        refreshFrames();
    }

    private void refreshFrames(){
        this.invalidate();
        this.validate();
        this.repaint();
    }

    private void replaceMainArea(JPanel replaceWith){
        this.remove(currentMainAreaPanel);
        this.add(replaceWith,BorderLayout.CENTER);
        currentMainAreaPanel = replaceWith;
        refreshFrames();
    }

    private void createFinancialPanes(){
        this.add(statementPanel, BorderLayout.CENTER);
        currentMainAreaPanel = statementPanel;
    }

    private class HoverMouseAdapter extends MouseAdapter{
        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            evt.getComponent().setForeground(ETheme.PRIMARY.getColor());
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            evt.getComponent().setForeground(ETheme.WHITE.getColor());
        }
    }
}
