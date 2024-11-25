package Enginear.eds.ExpenseTracker;

import java.awt.Color;

import Enginear.eds.ExpenseTracker.model.Asset;
import Enginear.eds.ExpenseTracker.model.Component;
import Enginear.eds.ExpenseTracker.model.ETheme;
import Enginear.eds.ExpenseTracker.model.Expense;
import Enginear.eds.ExpenseTracker.model.FinancialType;
import Enginear.eds.ExpenseTracker.model.Income;
import Enginear.eds.ExpenseTracker.model.Liability;
import Enginear.eds.ExpenseTracker.model.Recurring;

public class AppController {
    private static Model modelData = new Model();
    private static AppFrame appView = new AppFrame();

    public AppController(){
        modelData.types.add(new FinancialType("Relationship", new Color(0x7a0ac4)));
        modelData.types.add(new FinancialType("Rent", new Color(0xffcb2e)));
        modelData.types.add(new FinancialType("Studies", ETheme.PRIMARY.getColor()));
        modelData.types.add(new FinancialType("Job", new Color(0x3be34f)));
    }

    public static Model getModelData(){
        return modelData;
    }

    public static AppFrame getFrame(){
        return appView;
    }

    private static void updateView(){
        appView.updateView();
    }

    public static void createnewFinancialType(String name, Color color){
        modelData.types.add(new FinancialType(name, color));
        updateView();
    }

    /**
     * Creates and add a new financial component to the model.
     * Mostly used only in the forms.
     * 
     * @param componentType - income, expense, asset, or liability. Given other values will result in skipping the creation.
     * @param name - Unique identifier for the component
     * @param type - The FinancialType that belongs to the component
     * @param args - Strinified double and period if the component has recurring attribute
    */
    public static void createNewComponent(String componentType, String name, FinancialType type, String ...args){
        double amount = Double.parseDouble(args[0]);
        String recurrence = args.length > 1 ? args[1] : null;
        switch(componentType){
            case "income":
                modelData.components.add(new Income(name, type, amount));
                break;

            case "expense":
                modelData.components.add(new Expense(name, type, amount));
                break;

            case "asset":
                modelData.components.add(new Asset(name, type, amount, recurrence));
                break;

            case "liability":
                modelData.components.add(new Liability(name, type, amount, recurrence));
                break;

            default:
            //Hülye vagy fiam
            break;
        }
        updateView();
    }

    public static void adjustName(Component component, String name){
        modelData.adjustComponentName(component, name);
    }

    public static void adjustAmount(Component component, double amount){
        modelData.adjustComponentAmount(component, amount);
    }

    public static void adjustType(Component component, FinancialType type){
        modelData.adjustComponentType(component, type);
    }

    /**
     * Given non-recurring component immediately returns.
     * In the other case it fires the period adjustment method of the model.
    */
    public static void adjustRecurrence(Component component, String period){
        if(component.getCategory().equals("income") || component.getCategory().equals("expense"))
            return;

        modelData.adjustComponentPeriod((Recurring)component, period);
    }

}
