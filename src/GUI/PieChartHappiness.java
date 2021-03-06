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
        int width=300;
        int height=300;
        int  startAngle=0;
        int  endAngle;
        
        
        
        Color[] colorArray=new Color[]{Color.BLACK,Color.BLUE,Color.RED,Color.GREEN,Color.ORANGE,Color.PINK,Color.CYAN,Color.DARK_GRAY,Color.MAGENTA,Color.YELLOW};
        
        int i;
        double total=0;
        for(i=0;i<customersHapp.length;i++)
        {
            
            total+=customersHapp[i];
            
        }
         int z=500,v=200;
         ArrayList <String> name= new ArrayList<>();
        for(i=0;i<customersHapp.length;i++)
        {
                Font myFont = new Font("Serif", Font.PLAIN, 16);
                if(i==customersHapp.length-1)
                {
                    endAngle=360-startAngle;
                    double temp= customersHapp[i];
                     for(int j=0;j<customerz.size();j++)
                     {
                        if(temp==customerz.get(j).getHappiness())
                        {
                            if(name.contains(customerz.get(j).getName()))  
                            {
                                continue;
                                
                               
                            }
                            else{
                                name.add(customerz.get(j).getName());  
                                g.setColor(colorArray[i]);
                                g.setFont(myFont);
                                g.drawRect(z-25,v-15,15,15);
                                g.fillRect(z-25, v-15, 15, 15);
                                g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                                g.drawString(customerz.get(j).getName(), z, v);
                                break;
                            }
                        }
                     }
                }
                else{
                   endAngle=(int) ((customersHapp[i]/total)*360); 
                   double temp= customersHapp[i];
                     for(int j=0;j<customerz.size();j++)
                     {
                        if(temp==customerz.get(j).getHappiness())
                        {
                            if(name.contains(customerz.get(j).getName()))  
                            {
                                continue;
                                
                               
                            }
                            else{
                                name.add(customerz.get(j).getName());  
                                g.setColor(colorArray[i]);
                                g.setFont(myFont);
                                g.drawRect(z-25,v-15,15,15);
                                g.fillRect(z-25, v-15, 15, 15);
                                g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                                g.drawString(customerz.get(j).getName(), z, v);
                                break;
                            }
                        }
                     }
                }
                
                
                g.fillArc(x, y, width, height, startAngle, endAngle);
                startAngle=endAngle+startAngle;
                v+=35;
            
               
        }
        
        String title="HAPPINESS PIE CHART";
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(title, 200, 50);
        g.drawLine(200,53,200+(12*title.length()),53);  
            
            
           
          
        
    }
    
    
    
}
