package Enginear.eds.ExpenseTracker.View;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.List;

import Enginear.eds.ExpenseTracker.AppController;
import Enginear.eds.ExpenseTracker.model.Component;
import Enginear.eds.ExpenseTracker.model.ETheme;

public class PrintFormDesign implements Printable{
    private int width = 595;
    private int height = 842;
    private Font headerFont = new Font(Font.SANS_SERIF, Font.PLAIN, 32);
    private Font itemFont = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

    public PrintFormDesign(){
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Graphics2D g2D = (Graphics2D) graphics;
        Paper paper = new Paper();
        paper.setSize(width, height);

        if(pageIndex > 0)
            return NO_SUCH_PAGE;
        
        pageFormat.setOrientation(pageFormat.PORTRAIT);
        pageFormat.setPaper(paper);
        renderDesign(g2D);
        
        return PAGE_EXISTS;
    }

    private void renderDesign(Graphics2D g){
        int x = 16;
        int y = 16;
        for(String title : List.of("income","expense","asset","liability")){
            createHeader(x, y, title, g);
            y += 44;
            List<Component> itemsOfCategory = AppController.getModelData().components.stream().filter(c -> c.getCategory().equals(title)).toList();
            
            for(Component item : itemsOfCategory){
                createItem(x, y, item, g);
                y += 32;
            }
        }
        setHeight(y);
    }

    private void createHeader(int x, int y, String title, Graphics2D g){
        int headerHeight = 44;
        int headerWidth = 320;

        Rectangle2D.Double rect = new Rectangle2D.Double(x,y,headerWidth,headerHeight);
        g.setColor(ETheme.PRIMARY.getColor());
        g.fill(rect);

        g.setColor(ETheme.WHITE.getColor());
        g.setFont(headerFont);
        g.drawString(title.toUpperCase(), x+16, y+32);
    }

    private void createItem(int x, int y, Component item, Graphics2D g){
        g.setFont(itemFont);
        g.setColor(item.getType().getColor());
        g.drawString(item.getName(), x+32, y+16);
        g.drawString("$"+item.getAmount(), width-128, y+16);
    }

    private void setHeight(int h){
        height = h;
    }
}
