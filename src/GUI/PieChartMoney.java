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

public class PieChartMoney extends JPanel{
    
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
        
        Arrays.sort(this.workersMoney);
    
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
        for(i=0;i<workersMoney.length;i++)
        {
            
            total+=workersMoney[i];
            
        }
        
        for(i=0;i<workersMoney.length;i++)
        {
                if(i==workersMoney.length-1)
                {
                    endAngle=360-startAngle;
                }
                else{
                   endAngle=(int) ((workersMoney[i]/total)*360); 
                }
                g.setColor(colorArray[i]);
                
                g.fillArc(x, y, width, height, startAngle, endAngle);
                startAngle=endAngle+startAngle;
            
            
               
        }
        
       
        
            
            
           
          
        
    }
    
    
    
}
