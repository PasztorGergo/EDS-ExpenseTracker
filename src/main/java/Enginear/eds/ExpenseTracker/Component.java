package Enginear.eds.ExpenseTracker;

public abstract class Component{
    protected String name;
    protected FinancialType type;
    protected double amount;

    public Component(String name, FinancialType type, double amount){
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    /**
     * Turns the data of the instance into JSON formatted string.
     * 
     * @return JSON formatted String
     */
    public abstract String Stringify();
}