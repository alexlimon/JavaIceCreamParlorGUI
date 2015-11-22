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

    public int[] getToppings() {
        return toppings;
    }

    public void setToppings(int[] toppings) {
        this.toppings = toppings;
    }
    
    
    
}
