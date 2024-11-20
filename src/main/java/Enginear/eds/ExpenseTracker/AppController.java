package Enginear.eds.ExpenseTracker;

import java.awt.Color;

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

    public static void adjustRecurrence(Recurring component, String period){
        modelData.adjustComponentPeriod(component, period);
    }
}
