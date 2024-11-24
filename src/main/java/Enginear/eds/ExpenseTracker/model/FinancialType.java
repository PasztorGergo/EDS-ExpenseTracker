package Enginear.eds.ExpenseTracker.model;

import java.awt.Color;

public class FinancialType{
    private String name;
    Color color;

    public FinancialType(String name, Color color){
        this.name = name;
        this.color = color;
    }

    @Override
    public boolean equals(Object type){
        if(this.getClass() != type.getClass())
            return false;

        return ((FinancialType)type).name.equals(name);
    }

    public String getName(){
        return name;
    }

    public Color getColor(){
        return color;
    }

    public String getHexColor(){
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }
}