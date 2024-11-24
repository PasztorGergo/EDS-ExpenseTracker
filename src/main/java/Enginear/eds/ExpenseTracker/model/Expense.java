package Enginear.eds.ExpenseTracker.model;

public class Expense extends Component {

    public Expense(String name, FinancialType type, double amount){
        super(name, type, amount);
    }
    
    @Override
    public String getCategory(){
        return "expense";
    }
}