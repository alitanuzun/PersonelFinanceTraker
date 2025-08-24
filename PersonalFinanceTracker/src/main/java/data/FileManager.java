/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import model.Budget;
import model.Category;
import model.Transaction;

/**
 *
 * @author alita
 */
public class FileManager 
{
    private static final String transactionFile = "transactions.json";
    private static final String categoryFile = "categories.json";
    private static final String budgetFile = "budgets.json";
    
    private static final Gson gson = new Gson();
    
    private static void writeToFile(String fileName, String data)
    {
        try(FileWriter writer = new FileWriter(fileName))
        {
            writer.write(data);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
            
    }
    
    private static String readToFile(String fileName)
    {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while((line = reader.readLine())!= null)
            {
                builder.append(line).append("{\n");
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return builder.toString();
    }
    
    public static void saveTransactions(List<Transaction> transactions)
    {
        try (Writer writer = new FileWriter("transactions.json"))
        {
        gson.toJson(transactions, writer);
        } catch (IOException e)
        {
        e.printStackTrace();
        }
    }
    
    public static List<Transaction> loadTransactions()
    {
        
        File file = new File("transactions.json");

        
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            Type listType = new TypeToken<ArrayList<Transaction>>() {}.getType();
            List<Transaction> list = gson.fromJson(reader, listType);


            return (list != null) ? list : new ArrayList<>();
        } catch (Exception e) {
            System.out.println("️Transaction failed.");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public static void saveCategories(List<Category> categories)
    {
        writeToFile(categoryFile, gson.toJson(categories));
    }
    
    public static List<Category> loadCategory()
    {
        String content = readToFile(categoryFile);
        if(content.isEmpty())
        {
            return new ArrayList<>();
        }
        Type listType = new TypeToken <ArrayList<Category>>(){}.getType();
        return gson.fromJson(content, listType);
    }
    
    public static void saveBudget(List<Budget> budgets)
    {
        try (Writer writer = new FileWriter(("budgets.json")))
        {
        gson.toJson(budgets, writer);
        } catch (IOException e) 
        {
        e.printStackTrace();
        }
    }
    
    public static List<Budget> loadBudget()
    {
        File file = new File("budgets.json");
        if (!file.exists()) 
        {
            return new ArrayList<>();
        }

        try (Reader reader = new FileReader(file)) {
            Type listType = new TypeToken<ArrayList<Budget>>() {}.getType();
            List<Budget> list = gson.fromJson(reader, listType);
            return (list != null) ? list : new ArrayList<>();
        } catch (Exception e) {
            System.out.println("bugets failed.");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
