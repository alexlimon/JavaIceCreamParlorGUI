/*
 Alex Limon Naranjo
 1000818599
 09/14/2015
 CSE 1325-003
 */
package GUI;

/**
 *
 * @author Alex
 */
public class XWorker {
    
    protected String name;
    protected long ID;
    protected long customersserved;
    protected long numberscoops;
    protected double moneytaken;
    protected int workertype;
 
    
    //constructor, not much to say about it     
    public XWorker()
    {
        
        name="NULL";
        ID=00000;
        customersserved=0;
        moneytaken=0.00;
        workertype=0;
        numberscoops=0;
    }

    public long getCustomersserved() {
        return customersserved;
    }

    public void setCustomersserved(long customersserved) {
        this.customersserved = customersserved;
    }

    public int getWorkertype() {
        return workertype;
    }

    public void setWorkertype(int workertype) {
        this.workertype = workertype;
    }

    
    //this is the editing constructor
    public XWorker(String name, long ID, long customersserved, long numberscoops, double moneytaken)
    {
        
        name="NULL";
        ID=00000;
        customersserved=0;
        moneytaken=0.00;
        workertype=0;
        numberscoops=0;
     
    }
    
    
    
    public long getNumberscoops() {
        return numberscoops;
    }

    public void setNumberscoops(long numberscoops) {
        this.numberscoops = numberscoops;
    }
        
        
 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getCustomerserved() {
        return customersserved;
    }

    public void setCustomerserved(long customerserved) {
        this.customersserved = customerserved;
    }

    public double getMoneytaken() {
        return moneytaken;
    }

    public void setMoneytaken(double moneytaken) {
        this.moneytaken = moneytaken;
    }
    
    
    //getter for the name
    public String getWName(){
        return name;
    }
    
    //setter for the name
    public void setWname(String newname){
        name=newname;
        
        
    }
}
 
   
    

    
        
        
        
        
    

