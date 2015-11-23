/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 *
 */
public class MainFrame extends JFrame implements ActionListener
{
    

    //Here are the constants that define the commands on the menus
    
    public static final String labelFile="File";
    public static final String labelCreate="Create";
    public static final String labelUpdate="Update";
    public static final String labelTasks="Tasks";
    public static final String labelCharts="Charts";
    public static final String labelAbout= "About";    
    
    public static final String cmdFileIceCream="Load Ice Cream";
    public static final String cmdFileWorkers="Load Workers";
    public static final String cmdFileCustomers="Load Customers";
    public static final String cmdFileExit="Exit";
   
    public static final String cmdCreateIceCream="Create Ice Cream";
    public static final String cmdCreateWorker="Create Worker";
    public static final String cmdCreateCustomer="Create Customer";

    public static final String cmdUpdateIceCream="Update Ice Cream";
    public static final String cmdUpdateWorker="Update Worker";
    public static final String cmdUpdateCustomer="Update Customer";
    
    public static final String cmdTaskPlaceOrder="Place Order";
    public static final String cmdTaskPayOrder="Pay Order";
    public static final String cmdTaskActiveCashier="Active Cashier";
    public static final String cmdTaskActiveStocker="Active Stocker";
    public static final String cmdTaskOnBreakCashier="Cashier on Break";
    public static final String cmdTaskOnBreakStocker="Stocker on Break";

    public static final String cmdChartPieHappiness="Happiness Pie Chart";
    public static final String cmdChartPieMoney="Money Pie Chart";
    public static final String cmdChartBarHappiness="Happiness Bar Chart";
    public static final String cmdChartBarMoney="Money Bar Chart";
    
    public static final String cmdAboutTeam="About Team";
    public static final String cmdAboutOther="Other";
    //Here is the Menu Bar. It is very hard to have a Menu Frame without a Menu Bar
    JMenuBar menuBar;
    
    //Here are the Menus
    JMenu menuFile;//Load the three files, and exit
    JMenu menuCreate;//Create individuals
    JMenu menuUpdate;//Update individuals
    JMenu menuTasks;//Placing and paying for orders
    JMenu menuCharts;//Showing Charts
    JMenu menuAbout;
    
   
    
 
    
    
    
    JMenuItem menuItemExit;
    JMenuItem menuItemFileIceCream;
    JMenuItem menuItemFileCustomers;
    JMenuItem menuItemFileWorkers;
    
    JMenuItem menuItemCreateIceCream;
    JMenuItem menuItemCreateCustomer;
    JMenuItem menuItemCreateWorker;
    
    JMenuItem menuItemUpdateIceCream;
    JMenuItem menuItemUpdateCustomer;
    JMenuItem menuItemUpdateWorker;
    
    JMenuItem menuItemTaskPayOrder;
    JMenuItem menuItemTaskPlaceOrder;
    JMenuItem menuItemTaskActiveCashier;
    JMenuItem menuItemTaskActiveStocker;
    JMenuItem menuItemTaskOnBreakCashier;
    JMenuItem menuItemTaskOnBreakStocker;

    JMenuItem menuItemChartPieHappiness;
    JMenuItem menuItemChartPieMoney;
    JMenuItem menuItemChartBarHappiness;
    JMenuItem menuItemChartBarMoney;
    
    JMenuItem menuItemAboutTeam;
    JMenuItem menuItemAboutOther;
    
    JMenuItem menuItemBonus;
    
 
    JTextPane document;
   
    DialogAbout dialogAbout;
    Shop shop;
    LoadICDialog ICDialog;
    LWorkerDialog WorkerDialog;
    LCustomerDialog CustomerDialog;
    CreateCustomerDialog createCDialog;

    CreateWorkerD createWDialog;
    ActivateStockerD activateSDialog;
    ActivateStockerErrorDialog activateSError;
    ActivateStockerMessageDialog activateSMess;
    ActivateCashierDialog activateCDialog;
    ActivateCashierErrorDialog activateCErrDialog;
    ActivateCashierMessageDialog activateCMessDialog;

   
    AboutOtherDialog aboutOtherDialog;

    public MainFrame()
    {
        this.setTitle("Honey Badger Ice Cream Parlor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        makeMenuBar();
        
        makeDocument();
        
        dialogAbout=new DialogAbout(this,true);
        ICDialog = new LoadICDialog(this,true);
        WorkerDialog= new LWorkerDialog(this,true);
        CustomerDialog= new LCustomerDialog(this,true);
        createCDialog=new CreateCustomerDialog(this,true);

        createWDialog= new CreateWorkerD(this,true);
        activateSDialog=new ActivateStockerD(this,true);
        activateSError=new ActivateStockerErrorDialog(this,true);
        activateSMess=new ActivateStockerMessageDialog(this,true);
        activateCDialog=new ActivateCashierDialog(this,true);
        activateCErrDialog=new ActivateCashierErrorDialog(this,true);
        activateCMessDialog= new ActivateCashierMessageDialog(this,true);

        createWDialog= new CreateWorkerD(this,true);
        aboutOtherDialog= new AboutOtherDialog(this,true);

        shop = new Shop();
        
        this.setSize(new Dimension(800,600));
        this.setVisible(true);
        
    }


    private void makeMenuItem(JMenu menuContainer, JMenuItem menuItemObject, String label)
    {
        menuItemObject=new JMenuItem(label);
        menuContainer.add(menuItemObject);
        menuItemObject.addActionListener(this);
    }
    
    private void makeMenuBar() {
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menuFile = new JMenu(labelFile);
        makeMenuItem(menuFile,menuItemFileIceCream,cmdFileIceCream);
        makeMenuItem(menuFile,menuItemFileIceCream,cmdFileWorkers);
        makeMenuItem(menuFile,menuItemFileIceCream,cmdFileCustomers);
        makeMenuItem(menuFile,menuItemFileIceCream,cmdFileExit);
        menuBar.add(menuFile);

        menuCreate = new JMenu(labelCreate);
        makeMenuItem(menuCreate,menuItemCreateIceCream,cmdCreateIceCream);
        makeMenuItem(menuCreate,menuItemCreateWorker,cmdCreateWorker);
        makeMenuItem(menuCreate,menuItemCreateCustomer,cmdCreateCustomer);
        menuBar.add(menuCreate);
        
        menuUpdate = new JMenu(labelUpdate);
        makeMenuItem(menuUpdate,menuItemUpdateIceCream,cmdUpdateIceCream);
        makeMenuItem(menuUpdate,menuItemUpdateWorker,cmdUpdateWorker);
        makeMenuItem(menuUpdate,menuItemUpdateCustomer,cmdUpdateCustomer);
        menuBar.add(menuUpdate);
        
        menuTasks = new JMenu(labelTasks);
        makeMenuItem(menuTasks, menuItemTaskPayOrder,cmdTaskPayOrder);
        makeMenuItem(menuTasks,menuItemTaskPlaceOrder,cmdTaskPlaceOrder);
        makeMenuItem(menuTasks,menuItemTaskActiveCashier,cmdTaskActiveCashier);
        makeMenuItem(menuTasks,menuItemTaskActiveStocker,cmdTaskActiveStocker);
        makeMenuItem(menuTasks,menuItemTaskOnBreakCashier,cmdTaskOnBreakCashier);
        makeMenuItem(menuTasks,menuItemTaskOnBreakStocker,cmdTaskOnBreakStocker);
        menuBar.add(menuTasks);
        
        menuCharts = new JMenu(labelCharts);
        makeMenuItem(menuCharts, menuItemChartPieHappiness, cmdChartPieHappiness);
        makeMenuItem(menuCharts, menuItemChartPieMoney,cmdChartPieMoney);
        makeMenuItem(menuCharts, menuItemChartBarHappiness,cmdChartBarHappiness);
        makeMenuItem(menuCharts, menuItemChartBarMoney,cmdChartBarMoney);       
        menuBar.add(menuCharts);
        
       menuAbout = new JMenu(labelAbout); 
       makeMenuItem(menuAbout,menuItemAboutTeam,cmdAboutTeam);
       makeMenuItem(menuAbout,menuItemAboutOther,cmdAboutOther);
       menuBar.add(menuAbout);
      
       

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String command;
       
       command=e.getActionCommand();
      
       switch(command)
       {
            case cmdFileIceCream:
                //putLine("action:"+cmdFileIceCream+"\n");
                loadIceCream();
                break;
                
            case cmdFileWorkers:
                 //putLine("action:"+cmdFileWorkers+"\n");
                loadWorker();
               
                break;
            case cmdFileCustomers:
                loadCustomer();
                
                break;
            case cmdFileExit:
                System.exit(0);
                break;
            case cmdCreateIceCream:
                //putLine("action:"+cmdCreateIceCream+"\n");
                break;
            case cmdCreateWorker:
                createWDialog.setVisible(true);
                String wName=createWDialog.getWorkerName();
                int wType=createWDialog.getWorkerType();
                shop.createLoadedWorker(2004, wName, 00000,00000,0.00,wType, 10, false);
               
                break;
            case cmdCreateCustomer:
               // putLine("action:"+cmdCreateCustomer+"\n");
               createCDialog.setVisible(true);
               String name = createCDialog.getCustomerName();
               shop.createCustomer(name);
               
                
               break;
            case cmdUpdateIceCream:
            
                //putLine("action:"+cmdUpdateIceCream+"\n");
                break;
            case cmdUpdateWorker:
                //putLine("action:"+cmdUpdateWorker+"\n");
                break;
            case cmdUpdateCustomer:
                //putLine("action:"+cmdUpdateCustomer+"\n");
                break;
            case cmdTaskPlaceOrder:
               // putLine("action:"+cmdTaskPlaceOrder+"\n");
                break;
            case cmdTaskPayOrder:
                //putLine("action:"+cmdTaskPayOrder+"\n");
                break;
            case cmdTaskActiveCashier:
               activateCDialog.initComponents(shop.getWorkers());
               activateCDialog.setVisible(true);
                String CashierName=activateCDialog.getCashierChosen();
                int dec=shop.activateCashier(CashierName);
                if(dec==-1){
                    
                    activateCErrDialog.setVisible(true);
                }
                else {
                   activateCMessDialog.setVisible(true);
                }
                break;
            case cmdTaskActiveStocker:
               
            
                activateSDialog.initComponents(shop.getWorkers());
                
                activateSDialog.setVisible(true);
                String StockerName=activateSDialog.getStockerChosen();
                int decision = shop.activateStocker(StockerName);
                if(decision==-1){
                    
                    activateSError.setVisible(true);
                }
                else {
                   activateSMess.setVisible(true);
                }
                    
                    
                break;
            case cmdTaskOnBreakCashier:
                //putLine("action:"+cmdTaskOnBreakCashier+"\n");
                break;
            case cmdTaskOnBreakStocker:
                //putLine("action:"+cmdTaskOnBreakStocker+"\n");
                break;
            case cmdChartPieHappiness:
                //putLine("action:"+cmdChartPieHappiness+"\n");
                break;
            case cmdChartPieMoney:
                //putLine("action:"+cmdChartPieMoney+"\n");
                break;
            case cmdChartBarHappiness:
                //putLine("action:"+cmdChartBarHappiness+"\n");
                break;
            case cmdChartBarMoney:
                putLine("action:"+cmdChartBarMoney+"\n");
                break;
            case cmdAboutTeam:
                dialogAbout.setVisible(true);
                break;
            case cmdAboutOther:
                aboutOtherDialog.setVisible(true);
                break;
           
                

        }


    }

    private void makeDocument() {
        document=new JTextPane();
        document.setEditable(false);
        this.add(document);
        
    }

    private void putLine(String line) {
        document.setText(document.getText()+line);
    }

    
   public void setShop(Shop shop) {
        this.shop=shop;
    }


public void loadIceCream(){
                
    this.setPreferredSize(new Dimension(800,600)); //this is creating the dialog for the loading of icecream
    this.setSize(new Dimension(800,600));
    this.setLocation(new Point(0,0));
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTextField tf=new JTextField();
   //tf.setInputVerifier(inputVerifier);
    JFileChooser loader=new JFileChooser(".");
                int result=0;
                
		result=loader.showDialog(this, "Load Ice Cream");
                System.out.println(result);
             
		if (result==0)
		{
			System.out.println("Perform Action");
			
			File fp=loader.getSelectedFile();
			System.out.println(fp.getName());
                        String line;
                        String elements[];
                        long ID;
                        double price;
                        String flavor;
                        String description;
                        int scoopsleft;
                        try{
                            Scanner lineinput= new Scanner(fp);
                            while(lineinput.hasNextLine()){
                                line=lineinput.nextLine();
                                int i;
                                
                                elements= line.split(",");
                                
                                for(i=0;i<elements.length;i++)
                                {
                                    elements[i]=elements[i].trim();
                                }
                                ID= Long.parseLong(elements[0]);
                                flavor=elements[2];
                                price=Double.parseDouble(elements[1]);
                                description=elements[4];
                                scoopsleft=Integer.parseInt(elements[5]);
                                shop.createIceCream(flavor, ID, price, description,scoopsleft);
                                
                                }
                            ICDialog.setVisible(true);
                        }   catch (FileNotFoundException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                      }	
                     
                }
                else if(result==1){
                    loader.cancelSelection();
                }
                else 
		{
                       
			System.out.println("Cancel Action");
		}
	}
public void loadWorker(){
    this.setPreferredSize(new Dimension(800,600)); //this is creating the dialog for the loading of icecream
    this.setSize(new Dimension(800,600));
    this.setLocation(new Point(0,0));
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JTextField tf=new JTextField();
   //tf.setInputVerifier(inputVerifier);
    JFileChooser loader=new JFileChooser(".");
                int result=0;
		result=loader.showDialog(this, "Load Workers");
               // System.out.println(result);
             
		if (result==0)
		{
                    File fp=loader.getSelectedFile();
                
                    String line;
                    String elements[];
    
                    long ID=0;
                    String name="";
                    long customersserved=00000;
                    long numberscoops=0;
                    double moneytaken=0.0;
                    int workertype=0;
                    int staminapatience=0;
                    boolean onBreak=false;
                    
                    
                   
  
    
    
                     try{
                        Scanner lineinput= new Scanner(fp);
                     
                        while(lineinput.hasNextLine()){
                            line=lineinput.nextLine();
                        
                            elements= line.split(",");
                            int i;
                            for(i=0; i<elements.length; i++)
                            {
                                elements[i]=elements[i].trim();
                            }
                                
                                
                            ID= Long.parseLong(elements[0]);
                            if("Worker".equals(elements[1]))
                            {
                                workertype = 0;
                            }
                            
                            if("Stocker".equals(elements[1]))
                            {
                                workertype = 1;
                            }
                            
                            if("Cashier".equals(elements[1]))
                            {
                                workertype = 2;
                            }
                               
                            name=elements[2];
                            customersserved=Long.parseLong(elements[3]);
                            numberscoops= Long.parseLong(elements[4]);
                            moneytaken= Double.parseDouble(elements[5]);
                            
                            if(!"Worker".equals(elements[1]))
                            {
                                staminapatience= Integer.parseInt(elements[6]);
                            }
                             
                            shop.createLoadedWorker(ID, name, customersserved, numberscoops, moneytaken,workertype,staminapatience,onBreak);  
                           
                        }   


                        WorkerDialog.setVisible(true);
                    }  
                     
                     
                    catch (FileNotFoundException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(result==1){
                    loader.cancelSelection();
                }
                else 
		{
                       
			System.out.println("Cancel Action");
		}
            
}
    
public void loadCustomer(){
    this.setPreferredSize(new Dimension(800,600)); //this is creating the dialog for the loading of icecream
    this.setSize(new Dimension(800,600));
    this.setLocation(new Point(0,0));
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JTextField tf=new JTextField();
   //tf.setInputVerifier(inputVerifier);
    JFileChooser loader=new JFileChooser(".");
                int result=0;
		result=loader.showDialog(this, "Load Customers");
                System.out.println(result);
             
		if (result==0)
		{
                    System.out.println("Perform Action");
			
	            File fp=loader.getSelectedFile();
                    String line;
                    String elements[];
    
                    long ID;
    
                    String name;
                    double pennies;
                    double nickels;
                    double dimes;
                    double quarters;
                    double ones;
                    double fives;
                    double tens;
                    double twentys;
                    double totalmoney;
                    int happiness;
                    try{
                        Scanner lineinput= new Scanner(fp);
                        while(lineinput.hasNextLine()){
                            line=lineinput.nextLine();
                            elements= line.split(",");
                            int i;
                            for(i=0;i<elements.length;i++)
                            {
                                elements[i]=elements[i].trim();
                            }
                            ID= Long.parseLong(elements[0]);
                            name=elements[1];
                            totalmoney=Double.parseDouble(elements[2]);
                            happiness= Integer.parseInt(elements[3]);
                            pennies= Double.parseDouble(elements[4]);
                            nickels= Double.parseDouble(elements[5]);
                            dimes= Double.parseDouble(elements[6]);
                            quarters= Double.parseDouble(elements[7]);
                            ones= Double.parseDouble(elements[8]);
                            fives= Double.parseDouble(elements[9]);
                            tens= Double.parseDouble(elements[10]);
                            twentys= Double.parseDouble(elements[11]);
                            shop.createLoadedCustomer(ID, name, totalmoney, happiness, pennies, nickels, dimes, quarters, ones, fives, tens, twentys);
            
           
                        }
                        CustomerDialog.setVisible(true);
                    }
        
                    catch (FileNotFoundException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
          
            
                }
    
                else if(result==1){
                    loader.cancelSelection();
                }
                else 
		{
                       
			System.out.println("Cancel Action");
		}
} 

   
    
    
    
    
    
    

} 
    



