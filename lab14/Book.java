/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab14;

import java.io.Serializable;

/**
 *
 * @author vasin
 */
public class Book implements Serializable{
    private String name;
    private double price;
    private String type;
    
    public Book(){
        this("",0.0,"");
    }
    
    public Book(String name,double price,String type){
        this.name = name;
        this.price = price;
        this.type = type;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getType(){
        return this.type;
    }
}
