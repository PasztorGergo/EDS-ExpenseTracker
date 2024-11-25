package Enginear.eds.ExpenseTracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import Enginear.eds.ExpenseTracker.model.Asset;
import Enginear.eds.ExpenseTracker.model.Component;
import Enginear.eds.ExpenseTracker.model.Recurring;

class AppTest {
    @Test
    void checkTypeCreation(){
        AppController.createnewFinancialType("newType", new Color(0x3F56E0));
        assertFalse(AppController.getModelData().types.stream().filter(t -> t.getName().equals("newType")).toList().isEmpty());
    }

    @Test
    void checkComponentWithType(){
        AppController.createnewFinancialType("newType", new Color(0x3F56E0));
        Component comp = new Asset("Gold", AppController.getModelData().types.get(0), 1222.03, "1w");
        assertEquals(comp.getAmount(), 1222.03);
        assertEquals(comp.getName(), "Gold");
        assertEquals(comp.getType(), AppController.getModelData().types.get(0));
        assertEquals(comp.getCategory(), "asset");
        assertEquals(((Recurring)comp).getPeriod(), "1w");
    }

    @Test
    void checkComponentAdjustment(){
        AppController.createnewFinancialType("newType", new Color(0x3F56E0));
        AppController.createnewFinancialType("secondType", new Color(0x06d6e4));
        AppController.createNewComponent("asset", "Gold", AppController.getModelData().types.get(0), "1222.03", "1w");
        
        Component comp = AppController.getModelData().components.get(0);
        assertEquals(1222.03, comp.getAmount());
        assertEquals("Gold",comp.getName());
        assertEquals("asset", comp.getCategory());
        assertEquals(AppController.getModelData().types.get(0), comp.getType());

        AppController.adjustName(comp, "Silver");
        assertEquals("Silver", comp.getName());

        AppController.adjustAmount(comp, 1001.45);
        assertEquals(1001.45, comp.getAmount());

        AppController.adjustRecurrence(comp, "1m");
        assertEquals("1m", ((Recurring)comp).getPeriod());

        AppController.adjustType(comp, AppController.getModelData().types.get(1));
        assertEquals(AppController.getModelData().types.get(1), comp.getType());
    }

    public void checkRecurringIncomeChange(){

    }

    @Test
    public void checkNonRecurringIncomeChange(){

    }

    @Test
    public void checkJSONFormat(){

    }

    @Test
    public void checkJSONImport(){

    }

    @Test
    public void checkJSONExport(){

    }

    @Test
    void checkPrintJobCreated(){
        
    }

}
