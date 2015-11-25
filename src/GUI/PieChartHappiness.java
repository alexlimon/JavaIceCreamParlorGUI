/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author Mistere
 */
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;

public class PieChartHappiness extends JPanel{
    
    private double[] customersHapp;
    private ArrayList <XCustomer> customerz;
    public void setCustomersHappiness(ArrayList <XCustomer> customerList){
        this.customerz=customerList;
        int i;
        customersHapp=new double[customerz.size()];
        for(i=0;i<customerz.size();i++)
        {
            customersHapp[i]=customerz.get(i).getHappiness();
        }
        
        Arrays.sort(this.customersHapp);
    
}
    public void paint(Graphics g)
    {
        int x=100;
        int y=100;
        int width=400;
        int height=400;
        int  startAngle=0;
        int  endAngle;
        
        
        
        Color[] colorArray=new Color[]{Color.BLACK,Color.BLUE,Color.YELLOW,Color.RED,Color.GREEN,Color.PINK,Color.CYAN,Color.DARK_GRAY,Color.MAGENTA,Color.ORANGE};
        
        int i;
        double total=0;
        for(i=0;i<customersHapp.length;i++)
        {
            
            total+=customersHapp[i];
            
        }
        
        for(i=0;i<customersHapp.length;i++)
        {
                if(i==customersHapp.length-1)
                {
                    endAngle=360-startAngle;
                }
                else{
                   endAngle=(int) ((customersHapp[i]/total)*360); 
                }
                g.setColor(colorArray[i]);
                
                g.fillArc(x, y, width, height, startAngle, endAngle);
                startAngle=endAngle+startAngle;
            
            
               
        }
        
       
        
            
            
           
          
        
    }
    
    
    
}
