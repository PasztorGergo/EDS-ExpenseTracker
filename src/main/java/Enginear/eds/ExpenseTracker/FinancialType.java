package Enginear.eds.ExpenseTracker;

public class FinancialType{
    String name;
    String color;

    public FinancialType(){
        
    }

    @Override
    public boolean equals(Object type){
        if(this.getClass() != type.getClass())
            return false;

        return ((FinancialType)type).name.equals(name);
    }
}