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
public class Budget
{
    private String month;
    private double limit;
    private String category;
    
    public Budget(String month, String category, double limit)
    {
        this.month = month;
        this.category = category;
        this.limit = limit;
    }

    public String getMonth()
    {
        return month;
    }

    public void setMonth(String month)
    {
        this.month = month;
    }

    public double getLimit()
    {
        return limit;
    }

    public void setLimit(double limit)
    {
        this.limit = limit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
    
    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    public static Budget fromJSON(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Budget.class);
    }

    public String toString() {
        return month + " | Category: " + category + " | Limit: " + limit; 
    }
}
