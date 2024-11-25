package Enginear.eds.ExpenseTracker;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import Enginear.eds.ExpenseTracker.model.Component;
import Enginear.eds.ExpenseTracker.model.FinancialType;
import Enginear.eds.ExpenseTracker.model.Recurring;

public class Model {
    public List<Component> components;
    public List<FinancialType> types;
    public List<Line2D> lines;

    public Model(){
        components = new ArrayList<>();
        types = new ArrayList<>();
        lines = new ArrayList<>();
    }

    /**
     * Uses the name as unique identifier and renames the filtered component.
     * 
     * @param component - The component that will be renamed
     * @param name - The new name of the component
    */
    public void adjustComponentName(Component component, String name){
        try {
            Component searchedComponent = findComponent(component);
            searchedComponent.setName(name);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reassigns the component's financial type. If the given type doesn't exists an exception will be thrown.
     * 
     * @param component - The component that will be reassigned
     * @param type - The new financial type of the component
    */
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
    /**
     * Sets the monetary value of the component to the received value.
     * 
     * @param component - The adjustable component
     * @param amount - The new monetary value
    */
    public void adjustComponentAmount(Component component, double amount){
        try {
            Component searchedComponent = findComponent(component);
            searchedComponent.setAmount(amount);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    /**
     * Adjusts the recurrance of a <code>Recurring</code> component
     * 
     * @param component - Recurring component
     * @param period - The new recurrance of the finacial component
    */
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

    /***
     * Checks whether a component is contained inside the model.
     * @param component - The searched component
     * @return <code>true</code> if found in the model. Otherwise, <code>false</code>.
    */
    private boolean checkComponentExistance(Component component){
        return !(components.stream().filter(comp -> comp.equals(component)).toList().isEmpty());
    }
}
