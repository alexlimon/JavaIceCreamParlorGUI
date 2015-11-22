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




public void calcprice() throws FileNotFoundException
{
    File icfile;
    icfile = new File("IceCreamFlavors.txt");
    String line;
    String elements[]=null;
    double price;
    String flavor="";
    String description;
    int scoopsleft;
    int i=0,j=0;
    String flavorchecka="";
    
    for(i=0;i<scoops.length;i++)
    {
        
        flavor=scoops[i];
        
        Scanner lineinput= new Scanner(icfile);
        while(lineinput.hasNextLine()){
            line=lineinput.nextLine();
            elements= line.split(",");
            flavorchecka=elements[1];
            price=Double.parseDouble(elements[2]);
            
            if(flavorchecka.equals(flavor))
            {
                this.overallprice= price+this.overallprice;
                
                
            }
            
  }
    }           
        
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
