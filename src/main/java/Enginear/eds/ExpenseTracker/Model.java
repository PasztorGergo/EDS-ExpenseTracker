package Enginear.eds.ExpenseTracker;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Enginear.eds.ExpenseTracker.model.Asset;
import Enginear.eds.ExpenseTracker.model.Component;
import Enginear.eds.ExpenseTracker.model.Expense;
import Enginear.eds.ExpenseTracker.model.FinancialType;
import Enginear.eds.ExpenseTracker.model.Income;
import Enginear.eds.ExpenseTracker.model.Liability;
import Enginear.eds.ExpenseTracker.model.Recurring;

public class Model extends AbstractTableModel {
    public List<Component> components;
    public List<FinancialType> types;
    public List<Line2D> lines;

    public Model(){
        components = new ArrayList<>();
        types = new ArrayList<>();
        lines = new ArrayList<>();
    }

    public void createNewComponent(String componentType, String name, FinancialType type, String ...args){
        double amount = Double.parseDouble(args[0]);
        String recurrence = args.length > 1 ? args[1] : null;
        switch(componentType){
            case "income":
                components.add(new Income(name, type, amount));
                break;

            case "expense":
                components.add(new Expense(name, type, amount));
                break;

            case "asset":
                components.add(new Asset(name, type, amount, recurrence));
                break;

            case "liability":
                components.add(new Liability(name, type, amount, recurrence));
                break;

            default:
            //Hülye vagy fiam
            break;
        }
        fireTableRowsInserted(-1, components.size());
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

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return components.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return components.get(rowIndex).getName();
            case 1:
            return components.get(rowIndex).getType().getName();
            case 2:
                return components.get(rowIndex).getAmount();
            case 3:
                if(List.of("asset","liability").contains(components.get(rowIndex).getCategory()))
                    return ((Recurring)components.get(rowIndex)).getPeriod();
                else
                    return "-";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        String[] columnName = {"Name", "Type", "Amount", "Recurrance"};

        return columnName[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?>[] classes = {String.class, String.class, double.class, String.class};
        return  classes[columnIndex];
    }
}
