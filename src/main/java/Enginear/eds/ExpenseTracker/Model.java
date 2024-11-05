package Enginear.eds.ExpenseTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model {
    public List<Component> components;
    public List<FinancialType> types;

    public Model(){
        components = new ArrayList<>();
        types = new ArrayList<>();

    }
}
