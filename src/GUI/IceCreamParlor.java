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

    import java.io.FileNotFoundException;
    import java.util.Scanner;

     public class IceCreamParlor {
//the constructor will create the menumanager which is the UI and the shop which
//is the subcontroller, and has all the data
    
    private Shop shop;
    private MainFrame mainF;
   /* public IceCreamParlor() 
    {
        
    }
    */
    public void go() throws FileNotFoundException, NotEnoughIceCreamException, NotEnoughMoneyException
     {
        mainF=new MainFrame();
        //shop= new Shop();
        //mainF.setShop(shop);
        
     }
        
        
        
        
    //FINALLY main!
    public static void main(String[] args) throws FileNotFoundException, NotEnoughIceCreamException, NotEnoughMoneyException  {
      //creating the main class
      IceCreamParlor icecreamparlor= new IceCreamParlor();
      icecreamparlor.go();
      
    }
    
}