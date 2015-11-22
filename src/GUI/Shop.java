/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.FileNotFoundException;
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
       workerCount+=1376;
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
       temporder.createServing(icecreamflavors,servingtype,type,nuts,bananatopping);
       orders.add(temporder);
      
       
       
   }

   public void newtransaction(int customerposition, int workerposition, int[] icecreampositions,int servingtype, int type,boolean nuts,int[] bananatopping) throws FileNotFoundException, NotEnoughIceCreamException{
       int i=0;
       XCashier onbreakcashier; //lets increase some staminas
       XStocker onbreakstocker;
       String[] icecreamflavors;
       
       if(icecreampositions==null){
           
           int[] rootbeer={1};
           icecreampositions=rootbeer;
           
       }
       
       
       
       icecreamflavors= new String[icecreampositions.length+1];
       
       for(i=0;i<icecreampositions.length;i++){
           
           icecreamflavors[i]= icecreamz.get(icecreampositions[i]).getFlavor();
           if(icecreamz.get(icecreampositions[i]).getScoopsleft()<1){
           throw new NotEnoughIceCreamException();
           }
           }
       
       
       
       
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
   
   
  public void addservingct(int[] icecreampositions, int servingtype,int conetype,boolean nuts, int[] bananatopping) throws FileNotFoundException {
      
      int i; 
    if(icecreampositions==null){
           
           int[] rootbeer={1};
           icecreampositions=rootbeer;
           
       }
       String[] icecreamflavors= new String[icecreampositions.length+1];
       for(i=0;i<icecreampositions.length;i++){
           
           icecreamflavors[i]= icecreamz.get(icecreampositions[i]).getFlavor();
           
         }
      
      
      
      orders.get(currenttransaction).createServing(icecreamflavors, servingtype,conetype,nuts,bananatopping);//creates a new serving in the same order
      orders.get(currenttransaction).getOrderWorker().setNumberscoops(1+orders.get(currenttransaction).getOrderWorker().getNumberscoops());//increments the number of scoops the customer has taken
       for(i=0;i<icecreampositions.length;i++){
       icecreamz.get(i).setScoopsleft(icecreamz.get(i).getScoopsleft()-1);//this decrements the number of scoops left in the icecream
       }
  }
   
  public int payorderscash(int orderposition,double pennies, double nickels,double dimes,double quarters,double ones,double fives,double tens, double twentys) throws NotEnoughMoneyException{
    
    double moneyowed=orders.get(orderposition).getTotalCost();
     double cashgiven;
     double moneyleft;
     double changeremaining;
     double Cpennies;
     double Cnickels;
     double Cdimes;
     double Cquarters;
     double Cones;
     double Cfives;
     double Ctens;
     double Ctwentys;
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
         orders.get(orderposition).getOrderCustomer().setHappiness(orders.get(orderposition).getOrderCustomer().getHappiness()+ orders.get(orderposition).getServings().size());//this will set customers happiness based on the number of servings plus what it has already
         register.getTill().increaseupdate(pennies, nickels, dimes, quarters, ones, fives, tens, twentys);
         orders.get(orderposition).getOrderWorker().setMoneytaken(moneyowed+orders.get(orderposition).getOrderWorker().getMoneytaken());//this will update how much worker has taken
         
         
             }
     else if(moneyleft<0){
       /*  changeremaining=cashgiven;
         if(cashgiven%20!=cashgiven)
         {
         changeremaining=cashgiven%20;
         Ctwentys= cashgiven/20;
         Ctwentys= Math.round(Ctwentys);
         }
         if(changeremaining%10!=changeremaining)
         {
         changeremaining=cashgiven%10;
         Ctwentys= cashgiven/10;
         Ctwentys= Math.round(Ctwentys);
             
             
             
             
         }
         
         
         
         }
         */
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
    
    public int activateStocker(int stockerposition){
      
        Scanner changebreak = new Scanner(System.in);
        int switchbreak;
        
        
        
      if(stockerposition>=workers.size()){
          System.out.println("");
          System.out.println("Enter a valid stocker!");
          return -1;
       }  
       if(workers.get(stockerposition).getWorkertype()!=1){
          System.out.println("");
          System.out.println("Enter a valid stocker!");
          return -1; 
        } 
      activestocker= (XStocker)workers.get(stockerposition);
      
      if(activestocker.getStamina()<=0)
      {
          System.out.println("");
          System.out.println("Please choose a stocker that has more stamina.");
          activestocker=null;
          return -1;
          
      }
      if(activestocker.isOnBreak())
      {
         do{ System.out.println("");
          System.out.printf("Do you wish to end a %s's break? 0 for no and 1 for yes: ",activestocker.getName());
          switchbreak = changebreak.nextInt();
          if (switchbreak>1 || switchbreak<0){
              System.out.println("");
              System.out.println("Please enter 0 or 1!");
              
          }
      }while(switchbreak>1 || switchbreak<0);
         if (switchbreak ==1){
             activestocker.setOnBreak(false);
         }
         else{
              System.out.println("");
             System.out.println("Enter a stocker that is not on break!");
             return -1;
        }
         
         
          
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
            
            
   public int stockerBreak(int stockerposition){
       
       if(stockerposition>=workers.size()){
          System.out.println("");
          System.out.println("Enter a valid stocker!");
          return -1;
       }  
       if(workers.get(stockerposition).getWorkertype()!=1){
          System.out.println("");
          System.out.println("Enter a valid stocker!");
          return -1; 
        } 
       
       XStocker breakstocker= (XStocker)workers.get(stockerposition);
       breakstocker.setOnBreak(true);
       System.out.println("");
       System.out.printf("%s is now on break!\n",breakstocker.getWName());
       return 0;
          
   } 
       
       
       
public int activateCashier(int cashierposition){
      
        Scanner changebreak = new Scanner(System.in);
        int switchbreak;
        
        
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
      activecashier= (XCashier)workers.get(cashierposition);
      
      if(activecashier.getPatience()<=0)
      {
          System.out.println("");
          System.out.println("Please choose a cashier that has more patience.");
          activecashier=null;
          return -1;
          
      }
      if(activecashier.isOnBreak())
      {
          do{ System.out.println("");
          System.out.printf("Do you wish to end a %s's break? 0 for no and 1 for yes: ",activecashier.getName());
          switchbreak = changebreak.nextInt();
          if (switchbreak>1 || switchbreak<0){
              System.out.println("");
              System.out.println("Please enter 0 or 1!");
              
          }
      }while(switchbreak>1 || switchbreak<0);
         if (switchbreak ==1){
             activecashier.setOnBreak(false);
         }
         else{
              System.out.println("");
             System.out.println("Enter a cashier that is not on break!");
             return -1;
        }
          
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
        
        
        
        
        
        
        
        
        
        
        
    
    
    
    
    
    
    

    
    
    
    
    






