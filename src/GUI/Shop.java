/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.FileNotFoundException;
import static java.lang.Math.floor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 Alex Limon Naranjo
 1000818599
 09/14/2015
 CSE 1325-003
 *///constructor for shop with all of the classes, memory handling is below
public class Shop {
    private ArrayList <XIceCream> icecreamz;
    private ArrayList <XCustomer> customers;
    private ArrayList <XWorker> workers;
    private ArrayList <XOrder> orders;
    private XRegister register;
    private XCustomer tempcustomer;
    private XWorker tempworker;
    private XOrder temporder;
    private XIceCream tempicecream;
    private long workerCount= 100000;
    private int currenttransaction=0;
    private moneyformat cashtransaction;
    private XStocker activestocker=null;
    private XCashier activecashier;
    private String[] toppings;
    private double tempPriceofServing;
    private double Cpennies;
    private double Cnickels;
    private double Cdimes;
    private double Cquarters;
    private double Cones;
    private double Cfives;
    private double Ctens;
    private double Ctwentys;
    private double moneyleft;
  public Shop(){
    icecreamz= new ArrayList<>();
    customers =new ArrayList<>();
    workers= new ArrayList<>();
    orders= new ArrayList<>();
    register = new XRegister();
  
    String[] toppings={"Strawberry","Chocolate Syrup","Marshmellow Cream","Pineapple","Ketchup","Mustard","Pickle Relish","Soda","Banana"};
            
    
 }    
   public String[] getToppings()
   {
        return toppings;  
       
   }

//creates memory for an object of icecream class
    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    //creates memory for an object of serving class
    //creates memory for an object of customer class
    public void createCustomer(String name) {
        tempcustomer= new XCustomer();
        tempcustomer.setName(name);
        customers.add(tempcustomer);
        //System.out.println("");
       
    }
   
    public void createLoadedCustomer(long ID,String name,double totalmoney,int happiness,double pennies, double nickels, double dimes, double quarters, double ones, double fives, double tens, double twentys )
   {
      tempcustomer= new XCustomer();
      tempcustomer.setName(name);
      tempcustomer.setID(ID);
      tempcustomer.setMoney(totalmoney);
      tempcustomer.setHappiness(happiness);
      tempcustomer.setCMoney(pennies, nickels, dimes, quarters, ones, fives, tens, twentys);
      customers.add(tempcustomer);
   }
   
   public void createLoadedWorker(long ID,String name, long customersserved,long scoopstaken,double moneytaken,int workertype,int staminapatience ,boolean onBreak)
   {
       
       XWorker tempworker;
       XStocker tempstocker;
       XCashier tempcashier;
       
       
       if (workertype==1){
           
           tempstocker= new XStocker(name,ID,customersserved,scoopstaken,moneytaken,staminapatience,onBreak);
        
           
           workers.add(tempstocker);
          
       }
        
       else if(workertype==2){
           tempcashier= new XCashier(name,ID,customersserved,scoopstaken,moneytaken,staminapatience,onBreak);
           
           
           workers.add(tempcashier);
       }
           
       else{
          
       tempworker= new XWorker();
       tempworker.setID(ID);
       tempworker.setName(name);
       tempworker.setCustomerserved(customersserved);
       tempworker.setNumberscoops(scoopstaken);
       tempworker.setMoneytaken(moneytaken);
       tempworker.setWorkertype(workertype);
       
       workers.add(tempworker);
       }
     
   }
      
 
      
     
      
      
     
   
   
   //creates memory for an object of worker class
   public void createWorker(String name)
   {
       
       tempworker= new XWorker();
       workerCount+=1;
       tempworker.setID(workerCount);
       tempworker.setName(name);
       workers.add(tempworker);
       
   }
   
   
   
   
   
   
   
   
   public void createIceCream(String flavor,long ID, double price, String Description,int scoopsleft)
   {
       
       tempicecream = new XIceCream();
       tempicecream.setFlavor(flavor);
       tempicecream.setID(ID);
       tempicecream.setPrice(price);
       tempicecream.setDescription(Description);
       tempicecream.setScoopsleft(scoopsleft);
       icecreamz.add(tempicecream);
               
}
   
   
   
   public void createOrder(XCustomer ordercustomer,XWorker orderworker,String[] icecreamflavors, int servingtype,int type,boolean nuts,int[] bananatopping ) throws FileNotFoundException
   {
       temporder = new XOrder();
       temporder.setPeople(ordercustomer, orderworker);
         
       temporder.setOneservingcost(tempPriceofServing);
       temporder.createServing(icecreamflavors,servingtype,type,nuts,bananatopping);
       
       orders.add(temporder);
      
       
       
   }

   public void newtransaction(int customerposition, int workerposition, int[] icecreampositions,int servingtype, int type,boolean nuts,int[] bananatopping) throws FileNotFoundException, NotEnoughIceCreamException{
       int i=0;
       XCashier onbreakcashier; //lets increase some staminas
       XStocker onbreakstocker;
       String[] icecreamflavors;
       tempPriceofServing=0;
       
       
       
       
       
       
       if(icecreampositions==null){
           
           int[] rootbeer={1};
           icecreampositions=rootbeer;
           tempPriceofServing= 1.25;
       }
       
       
       
       icecreamflavors= new String[icecreampositions.length+1];
       
       for(i=0;i<icecreampositions.length;i++){
           
           icecreamflavors[i]= icecreamz.get(icecreampositions[i]).getFlavor();
           
           switch(servingtype){
               case 1:
                   tempPriceofServing+=icecreamz.get(icecreampositions[i]).getPrice();
                    
                   break;
               case 2: 
                   tempPriceofServing+=icecreamz.get(icecreampositions[i]).getPrice();
                   
                   break;
               case 3:
                   tempPriceofServing+=icecreamz.get(icecreampositions[i]).getPrice();
                   
                   break;
               case 4:
                   tempPriceofServing+=icecreamz.get(icecreampositions[i]).getPrice()+.05;
                    
                   break;
                   
          
         
       }
          
           if(icecreamz.get(icecreampositions[i]).getScoopsleft()<1){
                
               throw new NotEnoughIceCreamException();
           }
           }
       
       
      if(servingtype==2) tempPriceofServing+=1.00; //these take care of the extra prices of banana split and icecreamsundae
      if(servingtype==3) tempPriceofServing+=2.00;
       createOrder(customers.get(customerposition),workers.get(workerposition),icecreamflavors,servingtype,type,nuts,bananatopping);// use the createorder for this
       currenttransaction= orders.size()-1;
       
       workers.get(workerposition).setCustomerserved(1+workers.get(workerposition).getCustomerserved());//this is the counter for customers served
       workers.get(workerposition).setNumberscoops(1+workers.get(workerposition).getNumberscoops());//counter for scoops
       for(i=0;i<icecreampositions.length;i++){
      
       
           icecreamz.get(i).setScoopsleft(icecreamz.get(i).getScoopsleft()-1);//this decrements the number of scoops left in the icecream
       }
       
       for(i=0;i<workers.size();i++){ // first getting all workers
           if (workers.get(i).getWorkertype()==1){ //all stockers
               onbreakstocker=(XStocker)workers.get(i);//assigning stocker
               if(onbreakstocker.isOnBreak()&& onbreakstocker.getStamina()<20)//lets see who is on break
               {
                   onbreakstocker.setStamina(onbreakstocker.getStamina()+1);
               }
           }        
               
           if (workers.get(i).getWorkertype()==2){ //all cashiers
               onbreakcashier=(XCashier)workers.get(i);//assigning cashier
               if(onbreakcashier.isOnBreak()&& onbreakcashier.getPatience()<20)//lets see who is on break
               {
                   onbreakcashier.setPatience(onbreakcashier.getPatience()+1);
               }
          }
       }  
         
           
       
       
   
   
   
   
   
   
   }

    public double getCpennies() {
        return Cpennies;
    }

    public double getCnickels() {
        return Cnickels;
    }

    public double getCdimes() {
        return Cdimes;
    }

    public double getCquarters() {
        return Cquarters;
    }

    public double getCones() {
        return Cones;
    }

    public double getCfives() {
        return Cfives;
    }

    public double getCtens() {
        return Ctens;
    }

    public double getCtwentys() {
        return Ctwentys;
    }

    public double getMoneyleft() {
        return moneyleft;
    }
   
   
  public void addservingct(int[] icecreampositions, int servingtype,int conetype,boolean nuts, int[] bananatopping) throws FileNotFoundException {
      
     int i; 
     tempPriceofServing=0;
    if(icecreampositions==null){
           
           int[] rootbeer={1};
           icecreampositions=rootbeer;
           tempPriceofServing=1.25;
       }
       String[] icecreamflavors= new String[icecreampositions.length+1];
       for(i=0;i<icecreampositions.length;i++){
           
           icecreamflavors[i]= icecreamz.get(icecreampositions[i]).getFlavor();
           
           switch(servingtype){
               case 1:
                   tempPriceofServing+=icecreamz.get(icecreampositions[i]).getPrice();
                   break;
               case 2: 
                    tempPriceofServing+=icecreamz.get(icecreampositions[i]).getPrice()+1.00;
                   break;
               case 3:
                   tempPriceofServing+=icecreamz.get(icecreampositions[i]).getPrice()+2.00;
                   break;
               case 4:
                   tempPriceofServing+=icecreamz.get(icecreampositions[i]).getPrice()+.05;
                   break;
                   
                
         
       }
       }
      
      orders.get(currenttransaction).setOneservingcost(tempPriceofServing);
      orders.get(currenttransaction).createServing(icecreamflavors, servingtype,conetype,nuts,bananatopping);//creates a new serving in the same order
      orders.get(currenttransaction).getOrderWorker().setNumberscoops(1+orders.get(currenttransaction).getOrderWorker().getNumberscoops());//increments the number of scoops the customer has taken
       for(i=0;i<icecreampositions.length;i++){
       icecreamz.get(i).setScoopsleft(icecreamz.get(i).getScoopsleft()-1);//this decrements the number of scoops left in the icecream
       }
  }
   
  public int payorderscash(int orderposition,double pennies, double nickels,double dimes,double quarters,double ones,double fives,double tens, double twentys) throws NotEnoughMoneyException{
    
     double moneyowed=orders.get(orderposition).getTotalCost();
     double cashgiven;
     
     double changeremaining;
     cashtransaction= new moneyformat();
     cashtransaction.setPennies(pennies);
     cashtransaction.setNickels(nickels);
     cashtransaction.setDimes(dimes);
     cashtransaction.setQuarters(quarters);
     cashtransaction.setOnes(ones);
     cashtransaction.setFives(fives);
     cashtransaction.setTens(tens);
     cashtransaction.setTwentys(twentys);
     cashgiven=cashtransaction.getoverallMoney();
     moneyleft= moneyowed-cashgiven;
     
     
     if(orders.get(orderposition).getOrderCustomer().getMoney()<moneyowed)
     {
         
         throw new NotEnoughMoneyException();
         
     }
     
     
     
     if(moneyleft==0){
         orders.get(orderposition).setPaid(true);//this will deem the order payed
         orders.get(orderposition).getOrderCustomer().setdMoney(pennies, nickels, dimes, quarters, ones, fives, tens, twentys);//this will decrease the customers money
         orders.get(orderposition).getOrderCustomer().setHappiness(orders.get(orderposition).getOrderCustomer().getHappiness()+ orders.get(orderposition).getTotalicecreams());//this will set customers happiness based on the number of servings plus what it has already
         register.getTill().increaseupdate(pennies, nickels, dimes, quarters, ones, fives, tens, twentys);
         orders.get(orderposition).getOrderWorker().setMoneytaken(moneyowed+orders.get(orderposition).getOrderWorker().getMoneytaken());//this will update how much worker has taken
         
         
             }
     else if(moneyleft<0){
         moneyleft= moneyleft*(-1);
         changeremaining=moneyleft;
         if(changeremaining%20!=changeremaining)
         {
         Ctwentys= floor(changeremaining/20);
         changeremaining= changeremaining%20;
         }
         if(changeremaining%10!=changeremaining)
         {
         Ctens= floor(changeremaining/10);
         changeremaining= changeremaining%20;
         }
         if(changeremaining%5!=changeremaining)
         {
         Cfives= floor(changeremaining/5);
         changeremaining= changeremaining%5;
         }
         if(changeremaining%1!=changeremaining)
         {
         Cones= floor(changeremaining/1);
         changeremaining= changeremaining%1;
         }
         if(changeremaining%.25!=changeremaining)
         {
         Cquarters= floor(changeremaining/.25);
         changeremaining= changeremaining%.25;
         }
         if(changeremaining%.10!=changeremaining)
         {
         Cdimes= floor(changeremaining/.10);
         changeremaining= changeremaining%.10;
         }
         if(changeremaining%.05!=changeremaining)
         {
         Cnickels= floor(changeremaining/.05);
         changeremaining= changeremaining%.05;
         }
         if(changeremaining%.01!=changeremaining)
         {
         Cpennies= floor(changeremaining/.01);
         changeremaining= changeremaining%.01;
         }
     
    orders.get(orderposition).setPaid(true);
    orders.get(orderposition).getOrderCustomer().setdMoney(pennies, nickels, dimes, quarters, ones, fives, tens, twentys);
    orders.get(orderposition).getOrderCustomer().setiMoney(Cpennies, Cnickels, Cdimes, Cquarters, Cones, Cfives, Ctens, Ctwentys);
    orders.get(orderposition).getOrderCustomer().setHappiness(orders.get(orderposition).getOrderCustomer().getHappiness()+ orders.get(orderposition).getTotalicecreams());
    register.getTill().increaseupdate(pennies, nickels, dimes, quarters, ones, fives, tens, twentys);
    register.getTill().decreaseupdate(Cpennies, Cnickels, Cdimes, Cquarters, Cones, Cfives, Ctens, Ctwentys);
    orders.get(orderposition).getOrderWorker().setMoneytaken(moneyowed+orders.get(orderposition).getOrderWorker().getMoneytaken());
    
    
    return 1;//returns 1 incase the user put too much
     }
     
     
     else if(moneyleft>0) {
         
          return 2; //returns 2 incase user put too little
         
     }
     
     
     
  return 0;
  }
         
         
         
     public void payorderscredit(int orderposition){
        
         orders.get(orderposition).setPaid(true);
         register.setTillmoney(register.seeTill()+orders.get(orderposition).getTotalCost());
         orders.get(orderposition).getOrderWorker().setMoneytaken(orders.get(orderposition).getTotalCost()+orders.get(orderposition).getOrderWorker().getMoneytaken());
         orders.get(orderposition).getOrderCustomer().setHappiness(orders.get(orderposition).getOrderCustomer().getHappiness()+orders.get(orderposition).getTotalicecreams());
            
     }
    
      
      
      
      
  
   
   
   
    public ArrayList<XIceCream> getIcecreamz() {
        return icecreamz;
    }

    public void setIcecreamz(ArrayList<XIceCream> icecreamz) {
        this.icecreamz = icecreamz;
    }

    public ArrayList<XCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<XCustomer> customers) {
        this.customers = customers;
    }

    public ArrayList<XWorker> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<XWorker> workers) {
        this.workers = workers;
    }

    public ArrayList<XOrder> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<XOrder> orders) {
        this.orders = orders;
    }

    public XRegister getRegister() {
        return register;
    }

    public void setRegister(XRegister register) {
        this.register = register;
    }




    public long getWorkerCount() {
        return workerCount;
    }

    public void setWorkerCount(long workerCount) {
        this.workerCount = workerCount;
    }

    public XStocker getActivestocker() {
        return activestocker;
    }

    public void setActivestocker(XStocker activestocker) {
        this.activestocker = activestocker;
    }

    public XCashier getActivecashier() {
        return activecashier;
    }

    public void setActivecashier(XCashier activecashier) {
        this.activecashier = activecashier;
    }
// HW3 time!!
    
    public int activateStocker(String stockerName){
      
        int i,stockerposition=0;
        for(i=0;i<workers.size();i++)
        {
            if(workers.get(i).getName().equals(stockerName))
            {
                stockerposition=i;
            }
        }
 
        if(workers.get(stockerposition).getWorkertype()!=1){
         return -1; 
        } 
      activestocker= (XStocker)workers.get(stockerposition);
      
      if(activestocker.getStamina()<=0)
      {
        
          return -1;
          
      }
      if(activestocker.isOnBreak())
      {
       activestocker.setOnBreak(false);
      }
     return 0;       
         
   }

   
    
    public int restockIceCream(int icecreamposition){
        
        XIceCream icecreamrefill= icecreamz.get(icecreamposition);
        
        if(activestocker!=null && activestocker.getStamina()>0){
            System.out.println("");
            icecreamrefill.setScoopsleft(80);
            activestocker.setStamina(activestocker.getStamina()-1);
            activestocker.setNumberscoops(activestocker.getNumberscoops()+1);
            System.out.printf("%s refilled.\n",icecreamrefill.getFlavor());
            return 0;
        }
        
        else if(activestocker==null){
            System.out.println("");
            System.out.println("Please choose an active stocker first.");
            return 0;
        }
        
        else{
            System.out.println("Choose a stocker with more stamina.");
            return -1;
        }
         
    }        
            
            
public int stockerBreak(String stockerName){
       
       int i,stockerposition=0;
        for(i=0;i<workers.size();i++)
        {
            if(workers.get(i).getName().equals(stockerName))
            {
                stockerposition=i;
            }
        }
        if(workers.get(stockerposition).getWorkertype()!=1){
         return -1; 
        } 
       
       XStocker breakstocker= (XStocker)workers.get(stockerposition);
       breakstocker.setOnBreak(true);
       
       return 0;
          
   } 
       
       
       
public int activateCashier(String cashierName){
      
        int i,cashierposition=0;
        for(i=0;i<workers.size();i++)
        {
            if(workers.get(i).getName().equals(cashierName))
            {
                cashierposition=i;
            }
        }
 
        if(workers.get(cashierposition).getWorkertype()!=2){
         return -1; 
        } 
      activecashier=(XCashier)workers.get(cashierposition);
      
      if(activecashier.getPatience()<=0)
      {
        
          return -1;
          
      }
      if(activecashier.isOnBreak())
      {
       activestocker.setOnBreak(false);
      }
     return 0;       
         
   }
   
   
public int cashierBreak(int cashierposition){
       
       if(cashierposition>=workers.size()){
          System.out.println("");
          System.out.println("Enter a valid cashier!");
          return -1;
       }  
       if(workers.get(cashierposition).getWorkertype()!=2){
          System.out.println("");
          System.out.println("Enter a valid cashier!");
          return -1; 
        } 
       
       XCashier breakcashier= (XCashier)workers.get(cashierposition);
       breakcashier.setOnBreak(true);
       System.out.println("");
       System.out.printf("%s is now on break!\n",breakcashier.getWName());
       return 0;
          
   } 






}     
        
        
        
        
        
        
        
        
        
        
        
    
    
    
    
    
    
    

    
    
    
    
    







