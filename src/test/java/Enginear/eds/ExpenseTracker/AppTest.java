package Enginear.eds.ExpenseTracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        controller.createnewFinancialType("newType", "3F56E0");
        assertFalse(modelData.types.stream().filter(t -> t.name.equals("newType")).toList().isEmpty());
    }

    @Test
    public void checkComponentWithType(){

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
