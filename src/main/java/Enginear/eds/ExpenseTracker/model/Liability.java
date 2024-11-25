package Enginear.eds.ExpenseTracker.model;

public class Liability extends Recurring {

    public Liability(String name, FinancialType type, double amount, String period){
        super(name, type, amount, period);
    }
    
    @Override
    public String getCategory(){
        return "liability";
    }
}
