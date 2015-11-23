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
import java.util.Formatter;
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
    public static final String labelUpdate="Save Files";
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

    public static final String cmdUpdateIceCream="Save Ice Cream As";
    public static final String cmdUpdateWorker="Save Worker As";
    public static final String cmdUpdateCustomer="Save Customer As";
    
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
    OnBreakStockerDialog onBreakSDialog;
    OnBreakStockerErrorDialog onBreakSErr;
    OnBreakStockerMessageDialog onBreakSMess;
    UpdatedCustomer updateCustomer;
    UpdateWorker updateWorker;
    UpdatedIceCream updatedIceCream;
   
    AboutOtherDialog aboutOtherDialog;
    Formatter writer;
    public MainFrame()
    {
        this.setTitle("Honey Badger Ice Cream Parlor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        makeMenuBar();
        
        makeDocument();
        
        
        
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
        
        
        onBreakSDialog=new OnBreakStockerDialog(this,true);
        onBreakSErr= new OnBreakStockerErrorDialog(this,true);
        onBreakSMess= new OnBreakStockerMessageDialog(this,true);
        
        
        updateCustomer = new UpdatedCustomer(this, true);
        updateWorker = new UpdateWorker(this, true);
        updatedIceCream = new UpdatedIceCream(this, true);

        dialogAbout=new DialogAbout(this,true);
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
               loadIceCream();
                break;
            case cmdFileWorkers:
                loadWorker();
                break;
            case cmdFileCustomers:
                loadCustomer();
                break;
            case cmdFileExit:
                System.exit(0);
                break;
            case cmdCreateIceCream:
                break;
            case cmdCreateWorker:
                createWDialog.setVisible(true);
                String wName=createWDialog.getWorkerName();
                int wType=createWDialog.getWorkerType();
                shop.createLoadedWorker(2004, wName, 00000,00000,0.00,wType, 10, false);
                break;
            case cmdCreateCustomer:
               createCDialog.setVisible(true);
               String name = createCDialog.getCustomerName();
               shop.createCustomer(name);
               break;
            case cmdUpdateIceCream:
               icecreamUpdatefile();
               updatedIceCream.setVisible(true);
               break;
            case cmdUpdateWorker:
               workerUpdatefile();
               updateWorker.setVisible(true);
               break;
            case cmdUpdateCustomer:
               customerUpdatefile();
               updateCustomer.setVisible(true);
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
                if(dec==0) {
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
                if(decision==0){
                   activateSMess.setVisible(true);
                }
                break;
            case cmdTaskOnBreakCashier:
                //putLine("action:"+cmdTaskOnBreakCashier+"\n");
                break;
             case cmdTaskOnBreakStocker:
                onBreakSDialog.initComponents(shop.getWorkers());
                onBreakSDialog.setVisible(true);
                String StockerN=onBreakSDialog.getStockerChosen();
                int d=shop.stockerBreak(StockerN);
                if(d==-1)
                {
                  onBreakSErr.setVisible(true);
                }
                if(d==0){
                    onBreakSMess.setVisible(true);
                }
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

   
    
    
    
  public void icecreamUpdatefile(){
        
        this.setPreferredSize(new Dimension(800,600)); //this is creating the dialog for the loading of icecream
        this.setSize(new Dimension(800,600));
        this.setLocation(new Point(0,0));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField tf=new JTextField();
        //tf.setInputVerifier(inputVerifier);
        JFileChooser loader=new JFileChooser(".");
        int result=0;
        
        result=loader.showDialog(this, "Save");
        System.out.println(result);
        
        if (result==0)
        {
            System.out.println("Perform Action");
            
            File fp=loader.getSelectedFile();
            
            
            
            try {
                
                writer = new Formatter(fp);
                String elements[];
                int i;
                
                for(i=0;i<shop.getIcecreamz().size();i++){
                    
                    
                    long ID=shop.getIcecreamz().get(i).getID();
                    String flavor=shop.getIcecreamz().get(i).getFlavor();
                    double price =shop.getIcecreamz().get(i).getPrice();
                    String description=shop.getIcecreamz().get(i).getDescription();
                    int scoopsleft=shop.getIcecreamz().get(i).getScoopsleft();
                    writer.format("%s", ID);
                    writer.format(",");
                    writer.format("%s",price);
                    writer.format(",");
                    writer.format("%s",flavor);
                    writer.format(",");
                    writer.format("%s",flavor);
                    writer.format(",");
                    writer.format("%s",description);
                    writer.format(",");
                    writer.format("%s\r\n",scoopsleft);
                    writer.flush();
                    
                }
                
                
                
                
                
                
            } catch (FileNotFoundException ex) {
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
    
    public void customerUpdatefile(){
        
        this.setPreferredSize(new Dimension(800,600)); //this is creating the dialog for the loading of icecream
        this.setSize(new Dimension(800,600));
        this.setLocation(new Point(0,0));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField tf=new JTextField();
        //tf.setInputVerifier(inputVerifier);
        JFileChooser loader=new JFileChooser(".");
        int result=0;
        
        result=loader.showDialog(this, "Save");
        System.out.println(result);
        
        if (result==0)
        {
            System.out.println("Perform Action");
            
            File fp=loader.getSelectedFile();
            
            
            
            try {
                writer = new Formatter(fp);
                String elements[];
                int i;
                
                for(i=0;i<shop.getCustomers().size();i++){
                    
                    
                    long ID=shop.getCustomers().get(i).getID()+1003;
                    shop.getCustomers().get(i).setID(ID);
                    String name=shop.getCustomers().get(i).getName();
                    double pennies= shop.getCustomers().get(i).getWallet().getPennies();
                    double nickels=shop.getCustomers().get(i).getWallet().getNickels();
                    double dimes=shop.getCustomers().get(i).getWallet().getDimes();
                    double quarters=shop.getCustomers().get(i).getWallet().getQuarters();
                    double ones=shop.getCustomers().get(i).getWallet().getOnes();
                    double fives=shop.getCustomers().get(i).getWallet().getFives();
                    double tens=shop.getCustomers().get(i).getWallet().getTens();
                    double twentys=shop.getCustomers().get(i).getWallet().getTwentys();
                    double totalmoney=shop.getCustomers().get(i).getMoney();
                    int happiness=shop.getCustomers().get(i).getHappiness();
                    
                    writer.format("%s", ID);
                    writer.format(",");
                    writer.format("%s",name);
                    writer.format(",");
                    writer.format("%s",totalmoney);
                    writer.format(",");
                    writer.format("%s",happiness);
                    writer.format(",");
                    writer.format("%s",(int)pennies);
                    writer.format(",");
                    writer.format("%s",(int)nickels);
                    writer.format(",");
                    writer.format("%s",(int)dimes);
                    writer.format(",");
                    writer.format("%s",(int)quarters);
                    writer.format(",");
                    writer.format("%s",(int)ones);
                    writer.format(",");
                    writer.format("%s",(int)fives);
                    writer.format(",");
                    writer.format("%s",(int)tens);
                    writer.format(",");
                    writer.format("%s\r\n",(int)twentys);
                    
                    writer.flush();
                    
                }
                
                
                
                
                
                
            } catch (FileNotFoundException ex) {
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
    
    
    public void workerUpdatefile(){
        
        this.setPreferredSize(new Dimension(800,600)); //this is creating the dialog for the loading of icecream
        this.setSize(new Dimension(800,600));
        this.setLocation(new Point(0,0));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField tf=new JTextField();
        //tf.setInputVerifier(inputVerifier);
        JFileChooser loader=new JFileChooser(".");
        int result=0;
        
        result=loader.showDialog(this, "Save");
        System.out.println(result);
        
        if (result==0)
        {
            System.out.println("Perform Action");
            
            File fp=loader.getSelectedFile();
            
            XWorker tempworker;
            XCashier tempcashier;
            XStocker tempstocker;
            long ID=0;
            String name="";
            long customersserved=0;
            long scoopsserved=0;
            double moneytaken=0.00;
            int workertype=0;
            int staminapatience=0;
            boolean onBreak= false;
            try {
                Formatter writer = new Formatter(fp);
                String elements[];
                int i;
                
                
                for(i=0;i<shop.getWorkers().size();i++){
                    ID=shop.getWorkers().get(i).getID()+1434;
                    shop.getWorkers().get(i).setID(ID);
                    if(shop.getWorkers().get(i).getWorkertype()==0){
                        tempworker= shop.getWorkers().get(i);
                        ID = tempworker.getID();
                        name= tempworker.getName();
                        customersserved= tempworker.getCustomersserved();
                        scoopsserved = tempworker.getNumberscoops();
                        moneytaken =tempworker.getMoneytaken();
                        workertype= tempworker.getWorkertype();
                        staminapatience=0;
                        onBreak=false;
                    }
                    if(shop.getWorkers().get(i).getWorkertype()==1){
                        tempstocker=(XStocker) shop.getWorkers().get(i);
                        
                        ID = tempstocker.getID();
                        name= tempstocker.getName();
                        customersserved= tempstocker.getCustomersserved();
                        scoopsserved = tempstocker.getNumberscoops();
                        moneytaken =tempstocker.getMoneytaken();
                        workertype= tempstocker.getWorkertype();
                        staminapatience = tempstocker.getStamina();
                        onBreak = tempstocker.isOnBreak();
                        
                    }
                    if(shop.getWorkers().get(i).getWorkertype()==2){
                        tempcashier=(XCashier)shop.getWorkers().get(i);
                        ID = tempcashier.getID();
                        name= tempcashier.getName();
                        customersserved= tempcashier.getCustomersserved();
                        scoopsserved = tempcashier.getNumberscoops();
                        moneytaken =tempcashier.getMoneytaken();
                        workertype= tempcashier.getWorkertype();
                        staminapatience = tempcashier.getPatience();
                        onBreak = tempcashier.isOnBreak();
                        
                    }
                switch(workertype) {
                    
                    case 0:
                        writer.format("%s",ID);
                        writer.format(",");
                        writer.format("%s","Worker");
                        writer.format(",");
                        writer.format("%s",name);
                        writer.format(",");
                        writer.format("%s",customersserved);
                        writer.format(",");
                        writer.format("%s",scoopsserved);
                        writer.format(",");
                        writer.format("%s\r\n",moneytaken); 
                        break;
                    case 1:
                        writer.format("%s",ID);
                        writer.format(",");
                        writer.format("%s","Stocker");
                        writer.format(",");
                        writer.format("%s",name);
                        writer.format(",");
                        writer.format("%s",customersserved);
                        writer.format(",");
                        writer.format("%s",scoopsserved);
                        writer.format(",");
                        writer.format("%s",moneytaken); 
                        writer.format(",");
                        writer.format("%s\r\n",staminapatience);
                        break;
                    case 2:
                        writer.format("%s",ID);
                        writer.format(",");
                        writer.format("%s","Cashier");
                        writer.format(",");
                        writer.format("%s",name);
                        writer.format(",");
                        writer.format("%s",customersserved);
                        writer.format(",");
                        writer.format("%s",scoopsserved);
                        writer.format(",");
                        writer.format("%s",moneytaken); 
                        writer.format(",");
                        writer.format("%s\r\n",staminapatience);
                        break;
                  }
               writer.flush(); 
               }  
                
                
                
                
            } catch (FileNotFoundException ex) {
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
    



