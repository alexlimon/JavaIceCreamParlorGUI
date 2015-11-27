/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.FileNotFoundException;
import java.util.ArrayList;


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
    private int totalicecreams=0;
    
    private double totalCost=0.00;
    private double oneservingcost=0.00;
   
    
         
  
    
    
   //not much to use here yet... but here is what I was told to put 
    public XOrder(){
    System.out.println("Created Order.");
    paid= false;
    servings = new ArrayList<>();
    
   
}
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
    public void setPeople(XCustomer currentCustomer,XWorker currentWorker){
        this.orderCustomer= currentCustomer;
        this.orderWorker= currentWorker;
        
        
        
        
}
 public void setOneservingcost(double oneservingcost) {
        this.oneservingcost = oneservingcost;
    }

    public int getTotalicecreams() {
        return totalicecreams;
    }

   
  public void createServing(String[]icecreamflavors,int servingtype,int type,boolean nuts,int bananatopping[]) throws FileNotFoundException{
      
      totalCost+=oneservingcost;
    
      totalicecreams+=icecreamflavors.length;
      
      switch(servingtype)
      {
          
          case 1:
            tempcone = new sIceCreamCone();
            tempcone.setConetype(type);
            tempcone.setOverallprice(oneservingcost);
            tempcone.setScoops(icecreamflavors);
            servings.add(tempcone);
            break;
          case 2:
            tempsundae = new sIceCreamSundae();
            tempsundae.setOverallprice(oneservingcost);
            tempsundae.setScoops(icecreamflavors);
            tempsundae.setTopping(type);
            tempsundae.setNuts(nuts);
            servings.add(tempsundae);
            break;
          case 3:
            tempsplit = new sBananaSplit();
            tempsplit.setOverallprice(oneservingcost);
            tempsplit.setScoops(icecreamflavors);
            tempsplit.setToppings(bananatopping);
            tempsplit.setNuts(nuts);
           servings.add(tempsplit);
            break;
          case 4:
            tempsoda = new sIceCreamSoda();
            tempsoda.setOverallprice(oneservingcost);
            servings.add(tempsoda);
            break;
          case 5:
            tempfloat = new sRootBeerFloat();
            tempfloat.setOverallprice(oneservingcost);
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
