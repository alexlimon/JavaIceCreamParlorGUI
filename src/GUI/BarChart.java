/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.util.*;

/**
 *
 * @author Lacherois
 */
public class BarChart extends JPanel{
    
    ArrayList<XDataNode> dataNodes;
    int biggest;
    int max;
    int Choice;
   
    Color[] Colors= {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.LIGHT_GRAY, Color.PINK, Color.MAGENTA};
    
    
    
    public BarChart(){
        
        biggest=-1;
        dataNodes=new ArrayList<>();
        max=dataNodes.size();
        Choice=-1;
    }
    
    
    public void findBiggest(ArrayList <XDataNode> dataN){
        
        int i, j, x;
        int[]Arr=new int[max];
        //System.out.println(max);
       for(i=0; i<max; i++)
        {
            Arr[i]=dataNodes.get(i).getAmount();
        }
        
        for(i=0; i<max; i++)
        {
            for(j=i+1; j<max;j++)
            {
                if(Arr[i]>Arr[j])
                {
                    x=Arr[i];
                    Arr[i]=Arr[j];
                    Arr[j]=x;
                }
            }    
        }
        
        biggest=Arr[max-1];
    }        
    
    
    public void paintYAxis(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(150, 450, 150, 200);
        int i;
        int tick=biggest/5;
        int tickPos=200/5;
        
        for(i=0; i<6; ++i)
        {
            String tickLabel=String.format("%-5d", tick*i);
            g.drawLine(145, 450-i*tickPos, 150, 450-i*tickPos);
            g.drawString(tickLabel, 120, 450-i*tickPos+g.getFont().getSize()/2);
        }
        
    }
    
    
     public void paintXAxis(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine(150,450,(120*max+50), 450);
           
    } 
    
     public void calcBarHeights()
    {
        
        //Generate the height of each bar
        int i;
        for (i=0;i<max;i++)
        {
            XDataNode temp=dataNodes.get(i);
            float percent=0.0f;
            int height=0;
            int amount=0;
            amount=temp.getAmount();
            percent=temp.getAmount()*1.0f/biggest;
            height=(int)(percent*100);//pixels
            temp.setHeight(height);
        }
        
    }
    
    
    public void paintBarOutlines(Graphics g)
    {
        int i;
        for (i=0;i<max;i++)
        {
            XDataNode temp=dataNodes.get(i);
            int height=0;
            String text="";
            height=temp.getHeight();
            text=temp.getName();

            int rXPos=150+i*100;
            int rYPos=450-(2*height);//Flip the Y-Axis
            int rWidth=50;
            int rHeight=height*2;//50+height;//Flip the Y-Axis
            g.setColor(Color.BLACK);
            g.drawRect(rXPos,rYPos,rWidth,rHeight);
            g.drawString(text, rXPos,rYPos+rHeight+g.getFont().getSize()+15);
        }
    }
    
    public void paintBarFill(Graphics g)
    {
       
        int i;
        int height=0;
        for (i=0;i<max;i++)
        {
            XDataNode temp=dataNodes.get(i);
            g.setColor(Colors[i]);
            height=temp.getHeight();
            int rXPos=150+i*100;
            int rYPos=450-(2*height);//Flip the Y-Axis
            int rWidth=50;
            int rHeight=(2*height);
            g.fillRect(rXPos,rYPos,rWidth,rHeight);
        }
    
    
    }
    
    public void setTitle(Graphics g)
    {
        String title="";
        if(Choice==0)
        {
            title="HAPPINESS BAR CHART";
        }
        else{
            title="MONEY BAR CHART";
        }
    
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(title, 200, 150);
        g.drawLine(200,153,200+(13*title.length()), 153);
    
    }
    
    
    
    
    public void paint(Graphics g)
    {
        setData(dataNodes);
        findBiggest(dataNodes);
        calcBarHeights();
        paintBarFill(g);
        paintBarOutlines(g);
        paintXAxis(g);
        paintYAxis(g);
        setTitle(g);
    }

    void setData(ArrayList<XDataNode> dataNodes) {
        this.dataNodes=dataNodes;
        this.max=dataNodes.size();
    }

    public int getChoice() {
        return Choice;
    }

    public void setChoice(int Choice) {
        this.Choice = Choice;
    }
      
    
}
