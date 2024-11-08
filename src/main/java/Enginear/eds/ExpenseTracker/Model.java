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

    public void adjustComponentName(Component component, String name){
        try {
            Component searchedComponent = findComponent(component);
            searchedComponent.setName(name);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void adjustComponentType(Component component, FinancialType type){
        try {
            if(types.stream().filter(t -> t.equals(type)).toList().isEmpty()){
                throw new IllegalArgumentException("No such type");
            }

            Component searchedComponent = findComponent(component);
            searchedComponent.setType(type);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void adjustComponentAmount(Component component, double amount){
        try {
            Component searchedComponent = findComponent(component);
            searchedComponent.setAmount(amount);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void adjustComponentPeriod(Recurring component, String period){
        try {
            Recurring searchedComponent = (Recurring)findComponent(component);
            searchedComponent.setPeriod(period);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private Component findComponent(Component component) throws IllegalArgumentException {
        if(!checkComponentExistance(component))
            throw new IllegalArgumentException("The selected component does not exist");
        
        return components.stream().filter(comp -> comp.equals(component)).toList().get(0);
    }

    private boolean checkComponentExistance(Component component){
        return !(components.stream().filter(comp -> comp.equals(component)).toList().isEmpty());
    }
}
