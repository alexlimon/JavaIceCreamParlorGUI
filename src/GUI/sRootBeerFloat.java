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
public class sRootBeerFloat extends XServing{
    protected String[] scoops;
    public sRootBeerFloat(){
        scoops= new String[2];
        overallprice=1.25;
        
        
        
        
        
    }

    public String[] getScoops() {
        return scoops;
    }

    public void setScoops(String[] scoops) {
        this.scoops = scoops;
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
        scoops[i]=flavor;
        Scanner lineinput= new Scanner(icfile);
        while(lineinput.hasNextLine()){
            line=lineinput.nextLine();
            elements= line.split(",");
            flavorchecka=elements[1];
            price=Double.parseDouble(elements[2]);
            if(flavorchecka==flavor)
            {
                overallprice= price+overallprice;
                
            }
            
            
            
   }
  }
              
        
}   

}
