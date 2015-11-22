/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
Alex Limon Naranjo
 1000818599
 09/14/2015
 CSE 1325-003
 */
public class XIceCream {
    private String name;
    private String flavor;
    private String description;
    private double price;
    private long ID;
    private int scoopsleft;
    

    /**
     *
     */
    
    
    //constructor has all the attributes
    //note the null incase the user hasnt updated
    public XIceCream() 
    {
        
        flavor= "NULL";
        description="Simple Vanilla Flavor.";
        price= 1.00;
        scoopsleft=80;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getDescription() {
        return description;
    }

    public int getScoopsleft() {
        return scoopsleft;
    }

    public void setScoopsleft(int scoopsleft) {
        this.scoopsleft = scoopsleft;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
   
 
    
    
    
    
}
    

