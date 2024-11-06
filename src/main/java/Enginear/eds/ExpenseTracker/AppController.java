package Enginear.eds.ExpenseTracker;

public class AppController {
    private Model modelData;
    private AppFrame appView;

    public AppController(Model model, AppFrame appFrame){
        modelData = model;
        appView = appFrame;
        appView.setVisible(true);
    }

    private void updateView(){
        appView.updateView(modelData);
    }

    public void createnewFinancialType(String name, String color){
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

    public void adjustComponent(Component component, String ...args) throws IllegalArgumentException {
        if(args.length <= 1){
            throw new IllegalArgumentException("No given parameters");
        }

        updateView();
    }

    private void adjustName(Component component, String name){

    }

    private void adjustAmount(Component component, double amount){

    }

    private void adjustType(Component component, FinancialType type){

    }

    private void adjustRecurrence(Recurring component, String period){

    }
}
