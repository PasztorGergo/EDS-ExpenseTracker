package Enginear.eds.ExpenseTracker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Edge extends Line2D {
    private Point p1;
    private Point p2;
    private Color color;

    public Edge(int x1, int y1, int x2, int y2, Color color, Graphics g){
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
        this.color = color;
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return new Rectangle((int)getX1(), (int)getY1(), (int)(getX1() - getX2()), (int)(getY1() - getY2()));
    }

    @Override
    public Point2D getP1() {
        return p1;
    }

    @Override
    public Point2D getP2() {
        return p2;
    }

    @Override
    public double getX1() {
        return p1.getX();
    }

    @Override
    public double getX2() {
        return p2.getX();
    }

    @Override
    public double getY1() {
        return p1.getY();
    }

    @Override
    public double getY2() {
        return p2.getY();
    }

    @Override
    public void setLine(double x1, double y1, double x2, double y2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLine'");
    }
    
}
