package Enginear.eds.ExpenseTracker;

public abstract class Recurring extends Component {
    String period;

    public Recurring(String name, FinancialType type, double amount, String period){
        super(name, type, amount);
        this.period = period;
    }
}