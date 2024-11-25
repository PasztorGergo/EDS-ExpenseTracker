package Enginear.eds.ExpenseTracker.model;

public class Income extends Component{

    public Income(String name, FinancialType type, double amount){
        super(name, type, amount);
    }

    
    @Override
    public String getCategory(){
        return "income";
    }
}
