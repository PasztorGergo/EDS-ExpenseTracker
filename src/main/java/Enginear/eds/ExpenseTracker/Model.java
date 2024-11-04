package Enginear.eds.ExpenseTracker;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public List<Component> components;
    public List<FinancialType> types;

    public Model(){
        components = new ArrayList<>();
        types = new ArrayList<>();
    }
}
