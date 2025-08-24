/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.Gson;

/**
 *
 * @author alita
 */
public class Transaction
{
    private String id;
    private String category;
    private double amount;
    private String type;
    private String date;
    
    public Transaction(String id, String category, double amount, String type, String date)
    {
     this.id = id;
     this.category = category;
     this.amount = amount;
     this.type = type;
     this.date = date;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount
    ) {
        this.amount = amount;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
    
     public String toJSON()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    public static Transaction fromJSON(String json)
    {
        Gson gson = new Gson();
        return gson.fromJson(json, Transaction.class);
    }

    public String toString() 
    {
        return date + " | " + type + " | " + category + " | " + amount;
    }

}
