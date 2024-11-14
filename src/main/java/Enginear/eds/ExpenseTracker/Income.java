package Enginear.eds.ExpenseTracker;

public class Income extends Component{

    public Income(String name, FinancialType type, double amount){
        super(name, type, amount);
    }

    @Override
    public String Stringify() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Stringify'");
    }
    
    @Override
    public String getCategory(){
        return "income";
    }
}
