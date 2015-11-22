/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Alex
 */

//this class carries all the money from the shop and thats about it for now

public class XRegister {
   private double tillmoney;
   private moneyformat till;
   
    public XRegister()
    {
       till= new moneyformat();
       till.setPennies(50);
       till.setNickels(40);
       till.setDimes(50);
       till.setQuarters(40);
       till.setOnes(10);
       till.setFives(2);
       till.setTens(1);
       till.setTwentys(0);
       tillmoney = till.getoverallMoney();
        
    }
    //setter for the money
    //not used yet
    /* public void setMoney(double pennies, double nickels, double dimes, double quarters, double ones, double fives, double tens, double twentys)
    {
        till.setPennies(pennies);
        till.setNickels(nickels);
        till.setDimes(dimes);
        till.setQuarters(quarters);
        till.setOnes(ones);
        till.setFives(fives);
        till.setTens(tens);
        till.setTwentys(twentys);
        tillmoney=till.getoverallMoney();
    }
    this is already taken cared of in the moneyformat*/
    //getter for the till
    //again not used yet
    public double seeTill(){
        return tillmoney;
     
    }

    public moneyformat getTill() {
        return till;
    }

    public void setTillmoney(double tillmoney) {
        this.tillmoney = tillmoney;
    }

    



}


