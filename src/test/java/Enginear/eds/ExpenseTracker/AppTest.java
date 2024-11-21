package Enginear.eds.ExpenseTracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void checkTypeCreation(){
        AppController.createnewFinancialType("newType", new Color(0x3F56E0));
        assertFalse(AppController.getModelData().types.stream().filter(t -> t.name.equals("newType")).toList().isEmpty());
    }

    @Test
    void checkComponentWithType(){
        AppController.createnewFinancialType("newType", new Color(0x3F56E0));
        Component comp = new Asset("Gold", AppController.getModelData().types.get(0), 1222.03, "1w");
        assertEquals(comp.amount, 1222.03);
        assertEquals(comp.name, "Gold");
        assertEquals(comp.type, AppController.getModelData().types.get(0));
        assertEquals(comp.getCategory(), "asset");
        assertEquals(((Recurring)comp).period, "1w");
    }

    @Test
    void checkComponentAdjustment(){
        AppController.createnewFinancialType("newType", new Color(0x3F56E0));
        AppController.createnewFinancialType("secondType", new Color(0x06d6e4));
        AppController.createNewComponent("asset", "Gold", AppController.getModelData().types.get(0), "1222.03", "1w");
        
        Component comp = AppController.getModelData().components.get(0);
        assertEquals(1222.03, comp.amount);
        assertEquals("Gold",comp.name);
        assertEquals("asset", comp.getCategory());
        assertEquals(AppController.getModelData().types.get(0), comp.type);

        AppController.adjustName(comp, "Silver");
        assertEquals("Silver", comp.name);

        AppController.adjustAmount(comp, 1001.45);
        assertEquals(1001.45, comp.amount);

        AppController.adjustRecurrence(comp, "1m");
        assertEquals("1m", ((Recurring)comp).period);

        AppController.adjustType(comp, AppController.getModelData().types.get(1));
        assertEquals(AppController.getModelData().types.get(1), comp.type);
    }

    @Test
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

}
