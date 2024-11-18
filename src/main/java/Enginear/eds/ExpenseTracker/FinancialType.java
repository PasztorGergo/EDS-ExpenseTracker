package Enginear.eds.ExpenseTracker;

import java.awt.Color;

public class FinancialType{
    String name;
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
}