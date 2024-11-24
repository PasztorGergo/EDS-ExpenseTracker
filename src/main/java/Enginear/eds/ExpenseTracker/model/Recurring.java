package Enginear.eds.ExpenseTracker.model;

public abstract class Recurring extends Component {
    private String period;

    public Recurring(String name, FinancialType type, double amount, String period){
        super(name, type, amount);
        this.period = period;
    }

    public void setPeriod(String newPeriod){
        period = newPeriod;
    }

    public String getPeriod(){
        return period;
    } 
}