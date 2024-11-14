package Enginear.eds.ExpenseTracker;

public class Asset extends Recurring {

    public Asset(String name, FinancialType type, double amount, String period){
        super(name, type, amount, period);
    }

    @Override
    public String Stringify() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Stringify'");
    }
    
    @Override
    public String getCategory(){
        return "asset";
    }
}
