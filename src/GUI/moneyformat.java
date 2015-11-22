package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class moneyformat {
    private double pennies;
    private double dimes;
    private double quarters;
    private double nickels;
    private double twentys;
    private double fives;
    private double ones;
    private double tens;
    private double totalprice;
    
    
public  moneyformat()
 {
    
    pennies=0;
    nickels=0;
    dimes=0;
    quarters=0;
    ones=0;
    fives=0;
    tens=0;
    twentys=0;
    
    
}
 public double getoverallMoney()
 {
     totalprice= pennies*.01+nickels*.05+dimes*.10+quarters*.25+ones+fives*5+tens*10+twentys*20;
     return totalprice;
 }

 
 public void  decreaseupdate(double pennies, double nickels, double dimes, double quarters, double ones, double fives, double tens, double twentys){
 
     this.pennies=this.pennies-pennies;
     this.nickels=this.nickels-nickels;
     this.dimes=this.dimes-dimes;
     this.quarters=this.quarters-quarters;
     this.ones=this.ones-ones;
     this.fives=this.fives-fives;
     this.tens=this.tens-tens;
     this.twentys=this.twentys-twentys;
     
     
 }
 
 public void update(double pennies, double nickels, double dimes, double quarters, double ones, double fives, double tens, double twentys){
 
     this.pennies=pennies;
     this.nickels=nickels;
     this.dimes=dimes;
     this.quarters=quarters;
     this.ones=ones;
     this.fives=fives;
     this.tens=tens;
     this.twentys=twentys;
     
     
 }
 public void increaseupdate(double pennies, double nickels, double dimes, double quarters, double ones, double fives, double tens, double twentys){
 
     this.pennies=this.pennies+pennies;
     this.nickels=this.nickels+nickels;
     this.dimes=this.dimes+dimes;
     this.quarters=this.quarters+quarters;
     this.ones=this.ones+ones;
     this.fives=this.fives+fives;
     this.tens=this.tens+tens;
     this.twentys=this.twentys+twentys;
 
 
 
 }
 
 
 
    public double getPennies() {
        return pennies;
    }

    public void setPennies(double pennies) {
        this.pennies = pennies;
    }

    public double getDimes() {
        return dimes;
    }

    public void setDimes(double dimes) {
        this.dimes = dimes;
    }

    public double getQuarters() {
        return quarters;
    }

    public void setQuarters(double quarters) {
        this.quarters = quarters;
    }

    public double getNickels() {
        return nickels;
    }

    public void setNickels(double nickels) {
        this.nickels = nickels;
    }

    public double getTwentys() {
        return twentys;
    }

    public void setTwentys(double twentys) {
        this.twentys = twentys;
    }

    public double getFives() {
        return fives;
    }

    public void setFives(double fives) {
        this.fives = fives;
    }

    public double getOnes() {
        return ones;
    }

    public void setOnes(double ones) {
        this.ones = ones;
    }

    public double getTens() {
        return tens;
    }

    public void setTens(double tens) {
        this.tens = tens;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    
    
    
}
//