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
public class sIceCreamCone extends XServing{
    protected String[] scoops;
    protected int conetype;//1 is cake, 2 is sugar cone, 3 is waffle cone
    
    public sIceCreamCone(){
        scoops= new String[3];
        conetype=0;//0 means unassigned cone type
        overallprice=0.00;
        
        
        
        
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

    public int getConetype() {
        return conetype;
    }

    public void setConetype(int conetype) {
        this.conetype = conetype;
    }
        
        
   






}
