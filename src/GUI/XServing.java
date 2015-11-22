/*
 * Alex Limon Naranjo
 1000818599
 09/14/2015
 CSE 1325-003
 */
package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class XServing {
    protected double overallprice;
    
    protected XIceCream icecream;
    protected String scoops[];
    public XServing() {
    
    
    
    overallprice= 0.00;
    
    
    }
    
    
    
    
    
    
    public void setSIceCream(XIceCream orderedicecream){
        this.icecream= orderedicecream;
        this.overallprice= icecream.getPrice();
        
        
    }
    
//this setter will be used later to update the price
  
    
//not clear why the flavors is an integer, but hey I followed instructions..
   

   
   
   // getter for the price
   public double getOPrice()
   {
       return overallprice;
   }
   //getter for the number of flavors

    public double getOverallprice() {
        return overallprice;
    }

    public void setOverallprice(double overallprice) {
        this.overallprice = overallprice;
    }

    public XIceCream getIcecream() {
        return icecream;
    }

    public void setIcecream(XIceCream icecream) {
        this.icecream = icecream;
    }
  
    
    
    
    
    
    
}
