package Enginear.eds.ExpenseTracker;

import java.awt.Color;

public class AppController {
    private Model modelData;
    private AppFrame appView;

    public AppController(Model model, AppFrame appFrame){
        modelData = model;
        appView = appFrame;
    }

    public Model getModelData(){
        return modelData;
    }

    private void updateView(){
        appView.updateView(modelData);
    }

    public void createnewFinancialType(String name, Color color){
        modelData.types.add(new FinancialType(name, color));
        updateView();
    }

    public void createNewComponent(String componentType, String name, FinancialType type, String ...args){
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

    public void adjustName(Component component, String name){
        modelData.adjustComponentName(component, name);
    }

    public void adjustAmount(Component component, double amount){
        modelData.adjustComponentAmount(component, amount);
    }

    public void adjustType(Component component, FinancialType type){
        modelData.adjustComponentType(component, type);
    }

    public void adjustRecurrence(Recurring component, String period){
        modelData.adjustComponentPeriod(component, period);
    }
}
