package Enginear.eds.ExpenseTracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.awt.Color;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppTest {
    static Model modelData;
    static AppController controller;
    static AppFrame view;

    @BeforeAll
    public static void init(){
        modelData = new Model();
        view = new AppFrame();
        controller = new AppController(modelData, view);
    }

    @Test
    public void checkTypeCreation(){
        controller.createnewFinancialType("newType", new Color(0x3F56E0));
        assertFalse(modelData.types.stream().filter(t -> t.name.equals("newType")).toList().isEmpty());
    }

    @Test
    public void checkComponentWithType(){
        controller.createnewFinancialType("newType", new Color(0x3F56E0));
        Component comp = new Asset("Gold", controller.getModelData().types.get(0), 1222.03, "1w");
        assertEquals(comp.amount, 1222.03);
        assertEquals(comp.name, "Gold");
        assertEquals(comp.type, controller.getModelData().types.get(0));
        assertEquals(comp.getCategory(), "asset");
        assertEquals(((Recurring)comp).period, "1w");
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

}
