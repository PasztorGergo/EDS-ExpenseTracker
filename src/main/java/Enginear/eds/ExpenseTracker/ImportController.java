package Enginear.eds.ExpenseTracker;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import Enginear.eds.ExpenseTracker.model.FinancialType;

public class ImportController {
    public static void readJsonFrom(String path){
        try {
            JsonParser parser = new JsonFactory().createParser(new File(path));

            while (!parser.isClosed()) {
                JsonToken token = parser.nextToken();
                if (token == null) break;

                if (JsonToken.FIELD_NAME.equals(token)) {
                    String fieldName = parser.getCurrentName();

                    if ("types".equals(fieldName)) {
                        parser.nextToken(); // Start of the types array
                        while (parser.nextToken() != JsonToken.END_ARRAY) {
                            String name = null;
                            Color color = null;

                            while (parser.nextToken() != JsonToken.END_OBJECT) {
                                String subFieldName = parser.getCurrentName();
                                parser.nextToken();

                                if ("name".equals(subFieldName)) {
                                    name = parser.getValueAsString();
                                } else if ("color".equals(subFieldName)) {
                                    color = new Color(Integer.parseInt(parser.getValueAsString().replace("#", "0x")));
                                }
                            }
                            
                            if(!AppController.getModelData().types.contains(new FinancialType(name, color))){
                                AppController.createnewFinancialType(name, color);
                            }
                        }
                    } else if ("components".equals(fieldName)) {
                        parser.nextToken(); // Start of components object
                        while (parser.nextToken() != JsonToken.END_OBJECT) {
                            String componentName = parser.getCurrentName(); // expense, income, asset, liability
                            parser.nextToken(); // Start of array
                            while (parser.nextToken() != JsonToken.END_ARRAY) {
                                String name = null;
                                String type = null;
                                double amount = 0.0;
                                String recurrance = null;

                                while (parser.nextToken() != JsonToken.END_OBJECT) {
                                    String subFieldName = parser.getCurrentName();
                                    parser.nextToken();

                                    switch (subFieldName) {
                                        case "name" -> name = parser.getValueAsString();
                                        case "type" -> type = parser.getValueAsString();
                                        case "amount" -> amount = parser.getDoubleValue();
                                        case "recurrance" -> recurrance = parser.getValueAsString();
                                    }
                                }
                                final String searchName = type;
                                FinancialType finType = AppController.getModelData().types.stream().filter(ti -> ti.getName().equals(searchName)).toList().get(0);
                                
                                /*Convert it to an if statement based on recurrance*/

                                if(recurrance == null){
                                    AppController.createNewComponent(componentName, name, finType, "" + amount);
                                }else{
                                    AppController.createNewComponent(componentName, name, finType, "" + amount, recurrance);
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
