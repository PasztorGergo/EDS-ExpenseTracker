package Enginear.eds.ExpenseTracker;

public class FinancialType{
    String name;
    String color;

    public FinancialType(String name, String color){
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