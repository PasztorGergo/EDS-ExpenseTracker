package Enginear.eds.ExpenseTracker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import Enginear.eds.ExpenseTracker.model.Asset;
import Enginear.eds.ExpenseTracker.model.Component;
import Enginear.eds.ExpenseTracker.model.Expense;
import Enginear.eds.ExpenseTracker.model.FinancialType;
import Enginear.eds.ExpenseTracker.model.Income;
import Enginear.eds.ExpenseTracker.model.Liability;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonFactory;

public class ExportController {
    private ArrayList<Income> incomes = new ArrayList<>();
    private ArrayList<Expense> expenses = new ArrayList<>();
    private ArrayList<Asset> assets = new ArrayList<>();
    private ArrayList<Liability> liabilities = new ArrayList<>();

    public ExportController(){
        sortItemsByCategory();
    }

    private FileOutputStream exportTo(String path){
        try{
            FileOutputStream wr = new FileOutputStream(path);
            return wr;
        }
        catch(IOException err){
            err.printStackTrace();
            return null;
        }
    }

    private void sortItemsByCategory(){
        for(Component item : AppController.getModelData().components){
            switch(item.getCategory()){
                case "income":
                    incomes.add((Income)item);
                    break;
                case "expense":
                    expenses.add((Expense)item);
                    break;
                case "asset":
                    assets.add((Asset)item);
                    break;
                case "liability":
                    liabilities.add((Liability)item);
                    break;
                default:
                    continue;
            }
        }
    }

    public void StringifyModel(String path){
        try {
            JsonGenerator generator = new JsonFactory().createGenerator(exportTo(path));

            generator.writeStartObject();
                generator.writeArrayFieldStart("types");
                    for(FinancialType type: AppController.getModelData().types){
                        generator.writeStringField("name", type.getName());
                        generator.writeStringField("color", type.getHexColor());
                    }
                generator.writeEndArray();
                generator.writeObjectFieldStart("components");
                    generator.writeArrayFieldStart("income");
                    for(Income income : incomes){
                        generator.writeStringField("name", income.getName());
                        generator.writeNumberField("amount", income.getAmount());
                        generator.writeStringField("type", income.getType().getName());
                    }
                    generator.writeEndArray();
                    generator.writeArrayFieldStart("expense");
                        for(Expense expense : expenses){
                            generator.writeStringField("name", expense.getName());
                            generator.writeNumberField("amount", expense.getAmount());
                            generator.writeStringField("type", expense.getType().getName());
                        }
                    generator.writeEndArray();
                    generator.writeArrayFieldStart("asset");
                        for(Asset asset : assets){
                            generator.writeStringField("name", asset.getName());
                            generator.writeNumberField("amount", asset.getAmount());
                            generator.writeStringField("type", asset.getType().getName());
                            generator.writeStringField("recurrance", asset.getPeriod());
                        }
                    generator.writeEndArray();
                    generator.writeArrayFieldStart("liability");
                        for(Liability liability : liabilities){
                            generator.writeStringField("name", liability.getName());
                            generator.writeNumberField("amount", liability.getAmount());
                            generator.writeStringField("type", liability.getType().getName());
                            generator.writeStringField("recurrance", liability.getPeriod());
                        }
                    generator.writeEndArray();
                generator.writeEndObject();
            generator.writeEndObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
