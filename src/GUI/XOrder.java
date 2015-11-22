/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 Alex Limon Naranjo
 1000818599
 09/14/2015
 CSE 1325-003
 */
public class XOrder {
    private boolean paid;
    private int ordernumber;
    private XWorker orderWorker;
    private XCustomer orderCustomer;
    private ArrayList <XServing> servings;
    private XServing tempserving;
    private sIceCreamCone tempcone;
    private sIceCreamSoda tempsoda;
    private sIceCreamSundae tempsundae;
    private sBananaSplit tempsplit;
    private sRootBeerFloat tempfloat;
    
    
    private double totalCost=0.00;

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public XServing getTempserving() {
        return tempserving;
    }

    public void setTempserving(XServing tempserving) {
        this.tempserving = tempserving;
    }
    
         
  
    
    
   //not much to use here yet... but here is what I was told to put 
    public XOrder(){
    System.out.println("Created Order.");
    paid= false;
    servings = new ArrayList<>();
    
   
}
    public void setPeople(XCustomer currentCustomer,XWorker currentWorker){
        this.orderCustomer= currentCustomer;
        this.orderWorker= currentWorker;
        
        
        
        
}

  public void createServing(String[]icecreamflavors,int servingtype,int type,boolean nuts,int bananatopping[]) throws FileNotFoundException{
      
      
      
      
      
      
      switch(servingtype)
      {
          
          case 1:
            tempcone = new sIceCreamCone();
            tempcone.setConetype(type);
            tempcone.setScoops(icecreamflavors);
            tempcone.calcprice();
            totalCost= totalCost+tempcone.getOverallprice();
            servings.add(tempcone);
            break;
          case 2:
            tempsundae = new sIceCreamSundae();
            tempsundae.setScoops(icecreamflavors);
            tempsundae.setTopping(type);
            tempsundae.setNuts(nuts);
            tempsundae.calcprice();
            totalCost= totalCost+tempsundae.getOverallprice();
            servings.add(tempsundae);
            break;
          case 3:
            tempsplit = new sBananaSplit();
            tempsplit.setScoops(icecreamflavors);
            tempsplit.setToppings(bananatopping);
            tempsplit.setNuts(nuts);
            tempsplit.calcprice();
            totalCost= totalCost+tempsplit.getOverallprice();
            servings.add(tempsplit);
            break;
          case 4:
            tempsoda = new sIceCreamSoda();
            tempsoda.calcprice();
            totalCost= totalCost+(tempsoda.getOverallprice()*2.00);
           servings.add(tempsoda);
            break;
          case 5:
            tempfloat = new sRootBeerFloat();
            tempfloat.calcprice();
            totalCost= totalCost+tempfloat.getOverallprice();
            servings.add(tempfloat);
            break;
      }
           
            
          
         
     
      
              
              
      
      
     
      
      
      
      
   }   

    public boolean isPaid() {
        return paid;
    }

    public XWorker getOrderWorker() {
        return orderWorker;
    }

    public XCustomer getOrderCustomer() {
        return orderCustomer;
    }

    public ArrayList<XServing> getServings() {
        return servings;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    
    
    
  
}
