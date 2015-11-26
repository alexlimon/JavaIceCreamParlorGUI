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
public class sBananaSplit extends sIceCreamSundae {
    protected int[] toppings;
    public sBananaSplit(){
       scoops= new String[3];
       toppings = new int[4];//this will include topping #8 which is a banana.BANANA.
       overallprice=2.00;
       
        
    } 
        
       
        
  
    public int[] getToppings() {
        return toppings;
    }

    public void setToppings(int[] toppings) {
        this.toppings = toppings;
    }
    
    
    
}
