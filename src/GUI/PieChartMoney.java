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
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JPanel;

public class PieChartMoney extends JPanel {
    
    private double[] workersMoney;
    private ArrayList <XWorker> workerz;
    public void setWorkersMoney(ArrayList <XWorker> workerList){
        this.workerz=workerList;
        
        int i;
        workersMoney=new double[workerz.size()];
        for(i=0;i<workerz.size();i++)
        {
            workersMoney[i]=workerz.get(i).getMoneytaken();
        }
        
       
    
}
   
    public void paint(Graphics g)
    {
        int x=100;
        int y=100;
        int width=300;
        int height=300;
        int  startAngle=0;
        int  endAngle;
        
        
        
        Color[] colorArray=new Color[]{Color.RED,Color.BLUE,Color.GREEN,Color.BLACK,Color.YELLOW,Color.PINK,Color.CYAN,Color.DARK_GRAY,Color.MAGENTA,Color.ORANGE};
        
        int i;
        double total=0;
        for(i=0;i<workersMoney.length;i++)
        {
            
            total+=workersMoney[i];
            
        }
        int z=500,v=100;
        
         Arrays.sort(this.workersMoney);
         
        for(i=0;i<workersMoney.length;i++)
        {
                
                 Font myFont = new Font("Serif", Font.BOLD, 16);
                if(i==workersMoney.length-1)
                {
                    endAngle=360-startAngle;
                     double temp= workersMoney[i];
                     for(int j=0;j<workerz.size();j++)
                     {
                        if(temp==workerz.get(j).getMoneytaken())
                        {
                           
                            g.setColor(colorArray[i]);
                            g.setFont(myFont);
                            g.drawString(workerz.get(j).getName(), z, v);
                           
                        }
                     }
                }
                else{
                   endAngle=(int) ((workersMoney[i]/total)*360); 
                   double temp= workersMoney[i];
                   for(int j=0;j<workerz.size();j++)
                    {
                        if(temp==workerz.get(j).getMoneytaken())
                        {
                          
                            g.setColor(colorArray[i]);
                            g.setFont(myFont);
                            g.drawString(workerz.get(j).getName(), z, v);
                           
                        }
                    }
                }
               
                
                g.fillArc(x, y, width, height, startAngle, endAngle);
                
                startAngle=endAngle+startAngle;
                v+=15;
            
            
               
        }
        
      
         
            
            
           
          
        
    }
    
    
    
}
