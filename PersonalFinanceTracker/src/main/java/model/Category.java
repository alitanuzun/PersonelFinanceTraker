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
public class Category
{
    private String name;
    private String description;
    
    public Category(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String toJSON()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    
    public static Category fromJSON(String json)
    {
        Gson gson = new Gson();
        return gson.fromJson(json, Category.class);
    }

    public String toString()
    {
        return name + " - " + description;
    }
}
