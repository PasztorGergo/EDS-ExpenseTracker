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

    public void setName(String newName){
        name = newName;
    }

    public void setType(FinancialType newType){
        type = newType;
    }

    public void setAmount(double newAmount){
        amount = newAmount;
    }

    @Override
    public boolean equals(Object component){
        if(this.getClass() != component.getClass())
            return false;

        return ((Component)component).name.equals(name);
    }

    /**
     * Turns the data of the instance into JSON formatted string.
     * 
     * @return JSON formatted String
     */
    public abstract String Stringify();
}