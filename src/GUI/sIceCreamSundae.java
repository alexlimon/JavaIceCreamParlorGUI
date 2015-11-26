/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class sIceCreamSundae extends XServing {

    protected String[] scoops;
    
    protected boolean nuts;
    protected int topping;
    /*
    The toppings are indicated as follows:
    1. Strawberry
    2. Chocolate Syrup
    3. Marshmellow cream
    4. Pineapple
    5. Ketchup
    6. Mustard
    7.Pickle Relish
    */
public sIceCreamSundae(){
    scoops = new String[2];
    topping=0;//no topping
    nuts= false;
    overallprice=1.00;
  }    





    public String[] getScoops() {
        return scoops;
    }

    public void setScoops(String[] scoops) {
        this.scoops = scoops;
    }

    public boolean isNuts() {
        return nuts;
    }

    public void setNuts(boolean nuts) {
        this.nuts = nuts;
    }

    public int getTopping() {
        return topping;
    }

    public void setTopping(int topping) {
        this.topping = topping;
    }










}
