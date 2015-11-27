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
        overallprice=1.25;
        
        }

    public String[] getScoops() {
        return scoops;
    }

    public void setScoops(String[] scoops) {
        this.scoops = scoops;
    }
    }
