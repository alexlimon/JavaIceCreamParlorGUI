/*
  Alex Limon Naranjo
 1000818599
 09/14/2015
 CSE 1325-003
 */
package GUI;


public class XCustomer {
    
    private String name;
    private int happiness;
    private moneyformat wallet;
    private double money;
    private long ID;
    
    //the constructor has all the attributes and once again null until the update
    public XCustomer(){
    
    
    name="NULL";
    happiness=0;
    wallet= new moneyformat();
    wallet.setPennies(4);
    wallet.setNickels(2);
    wallet.setDimes(2);
    wallet.setQuarters(2);
    wallet.setOnes(5);
    wallet.setFives(2);
    wallet.setTens(1);
    wallet.setTwentys(1);
    money= wallet.getoverallMoney();
    
    
    
            
}

    public void setMoney(double money) {
        this.money = money;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public moneyformat getWallet() {
        return wallet;
    }

    public void setWallet(moneyformat wallet) {
        this.wallet = wallet;
    }
    



//getter for the name
    public String getName()
    {
        return name;
    }
    //getter for the money
    public double getMoney()
    {
        return money;
    }
   //getter for the happiness
    public int getHappiness()
    {
        return happiness;
    }
            
            
            
    //setter for the name, maybe one day I'll use "this."        
    public void setName(String newName)
    {
        name=newName;
    }
    //setter for the happiness
    //this makes the user god
    public void setHappiness(int nHappy)
    {
        happiness= nHappy;
    }
    //setter for the money
    public void setdMoney(double pennies, double nickels, double dimes, double quarters, double ones, double fives, double tens, double twentys)
    {
       wallet.decreaseupdate(pennies, nickels, dimes, quarters, ones, fives, tens, twentys);
       money=wallet.getoverallMoney();
    }
    
     public void setiMoney(double pennies, double nickels, double dimes, double quarters, double ones, double fives, double tens, double twentys)
    {
       wallet.increaseupdate(pennies, nickels, dimes, quarters, ones, fives, tens, twentys);
       money=wallet.getoverallMoney();
    }
    
    
    
    
   public void setCMoney(double pennies, double nickels, double dimes, double quarters, double ones, double fives, double tens, double twentys){

   wallet.update(pennies, nickels, dimes, quarters, ones, fives, tens, twentys);
   
   
   }
}
