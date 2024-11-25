package Enginear.eds.ExpenseTracker.model;

public class Asset extends Recurring {

    public Asset(String name, FinancialType type, double amount, String period){
        super(name, type, amount, period);
    }
    
    @Override
    public String getCategory(){
        return "asset";
    }
}
