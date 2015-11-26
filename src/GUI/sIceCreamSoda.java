/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class sIceCreamSoda extends XServing {
    protected String[] scoops;
    
    
    public sIceCreamSoda()
    {
        scoops= new String[3];//we gonna need space for da sodaaaaa
       
        overallprice=overallprice+.05;
        }

    
  
    public String[] getScoops() {
        return scoops;
    }

    public void setScoops(String[] scoops) {
        this.scoops = scoops;
    }
    
    
    
    
}
